package info.nemoworks.fease.repository.mysql.model;

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
public class ContractEntity {
    @Id
    @GeneratedValue
    @Column(name = "contract_id")
    protected Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "date_sign")
    private LocalDate date;

    @Type(type = "json")
    @Column(name = "additional_Properties")
    private Map<String, Object> additionalProperties;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "sub_contracts")
    private List<SubContractEntity> subContracts;
//
//    @OneToMany(mappedBy = "contract")
//    @Column(name = "projects")
//    private List<ProjectEntity> projects;

}
