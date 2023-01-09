# F(inance l)ease

此项目用以金融租赁（Finance lease）为例介绍特定领域业务系统的设计开发。

### 问题与动机

依照常规开发方法，业务系统开发首先对业务领域进行建模，抽象提炼其中受管理的关键性概念，继而将领域概念实现为相应业务模型，并编写相关的模型持久化层和业务服务访问层代码。例如一个简化的金融租赁场景业务模型如下图。

![](https://www.plantuml.com/plantuml/png/XL7TIW916BtVf_ZOIsMbxaDy5T6vMpMSzI8gSA4VpJA3I53Cii0A2eFKnHdqPMOSzyfNQFDhTqUwQA_Ed3dV-SwSpL0dMtOg1HiAfJon3OCKAmMG7uDbRQe-cRnlmA41mIUuAxmEGkzDp6ORw7VFP7TW71j6pivI-Zk84uWLlvFNKusGhIir76q8nVh2gwhdkU0TiNXKjo-2FQa7L_DhrMJh4lqGevz6-ESt_g27Vk_pLR2ZFV7RNx67y1Wg8u8rGoAw0yiwIaD8HmgTrjK9oz9jy6KGa6RIETWdvbQ3qRsPj0cbXC2k2NiRSQvKTChPd4DX9vLAc77MxP5I-P-Hlx7Ji1gVYDamVBGQzbTZLzLV0TjSyvfgZjQyBjXKLdbSrx9nAXQzM8XdRFb75Hi5tKHRKAMn-cuyeHrYxIzYHmWl9ikg6yQJpRuUBqEA-My0)

这一领域模型对该业务中固有概念及其关系进行了刻画，所开发实现的业务系统也要提服务实现对相应数据的管理。例如依照模型所实现的`主合同`可能如下：

```java
public class Contract extends Entity {
    private String code;
    private LocalDate date;
    private Customer customer;
    private List<SubContract> subContracts;
    private Map<String, Object> contents;
    private List<Project> projects;
}
```

在一般开发实践，业务模型往往直接对应业务数据的存储模型。例如上述`Contract`类型在实际开发中可能直接基于特定持久化技术（JPA等）实现为一个数据模型：

```java
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "contracts")
@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Contract {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "date_sign")
    private LocalDate date;

    @Type(type = "json")
    @Column(columnDefinition = "additional_Properties")
    private Map<String, Object> additionalProperties;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract", fetch = FetchType.EAGER)
    private List<SubContract> subContracts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract", fetch = FetchType.EAGER)
    private List<Project> projects;
}
```

从上述示例我们可以发现，`主合同`中除了基本的`合同编号`、`签订日期`等固定属性外，`合同内容`可能在每个具体合同中存在非确定性，模型中将其表达为保存多个Key-Value对的`Map`，当然也可以用`JSON`对象等实现。
也就是说，**`主合同`模型对象的数据存在结构化部分和非结构化部分**。这样的对象可以采用关系型数据库存储，其中的`合同内容`可定义为MySQL中的`JSON`类型字段，或者采用非关系型数据库存储整个`主合同`,例如文档数据库MongoDB或者图数据库Neo4j等。`合同内容`
可在这些数据库中可展开将每个KV都作为文档内容或图节点属性存储。

这些存储方案可能存在不同的问题。比如MySQL中`JSON`字段不支持索引导致查询性差；采用Mongodb等文档数据库时则要权衡`Customer`是作为内嵌文档还是作为文档引用存储，前者在数据一致性维护上困难，
后者则需要使用`aggregate`和`$lookup`进行查询，性能也相对低下。Neo4j这样的图数据库同样也存在查询结果排序性能差等问题。

因此，代码中的注解提供了持久化层所需的信息实现将业务对象与存储对象的直接映射存在的问题可归结如下：

1. 这一开发方法要求系统所采用的数据库是预先选定的，如果需要开发时同时适配多种类型（关系型或非关系型）数据库或者在开发完成以后改变底层数据库将会非常困难；
2. 将业务模型直接用数据模型实现要求领域建模与存储建模同时进行且相互协调，一方面业务概念需要清晰，另一方面要从业务服务的角度考虑存储模型是否能满足性能要求，这对建模提出了很高的要求。


### 业务模型与存储模型分离

依照关注分离原则，我们将业务模型`Contract`与存储模型`ContractEntity`进行分别设计，并采用模型转换器`ContractMapper`将这两个模型进行双向翻译映射。
针对`ContractEntity`我们实现其持久化层`ContractRepository`，在业务层我们定义服务`ContractService`，`ContractService`使用`ContractMapper`对
待管理`Contract`对象转换为`ContractEntity`，并委托`ContractRepository`执行具体的存储管理过程，返回的存储层结果对象再通过`ContractMapper`转换为业务层对象。
如下图所示。

![](https://www.plantuml.com/plantuml/png/SoWkIImgAStDuKhEIImkLd3EpoifIamkuKBZk-QLP9PKeelw9XOKf1QXYmQd5fLb9gUY2mUb5kGNPvRa5m6DoSilILLGUh9ZoOk6rkUpTppPDUd5tZNFUXSfAIGMA_WPSN7v6IdewI5SW-eCe1H84QehW89sS0qALWhFPYnukg45OYmkfGWZqJLmeNa6tVGNVTkVxfl-TEsCfqqhNgpR_tBwEWKx33tvkhfeGGNK-MJl_kTJLW1LOuOBTdSXMuBF2eH1O5tBfpphd06qXiiXDIy5J01Z6G00)

这样，我们针对不同数据库设计不同存储模型，例如针对图数据库将一个`Contract`的存储模型设计为Neo4j中的节点`ContractNode`，或MongoDB中的文档`ContractDocument`，再分别实现图数据库或文档库持久化层。
一方面在不改变业务模型的条件下，我们可以实现业务数据在不同类型数据库中存储管理；另一方面具体数据库相关的存储结构设计优化难点可以从领域建模过程中分离，将存储模型的详细设计和调优留给对数据库技术熟悉的开发人员实施。
