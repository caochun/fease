package info.nemoworks.fease.repository.mysql.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "contracts")
@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class ContractEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    protected Long id;

    @Column(name="code")
    private String code;

    @Column(name="date_sign")
    private LocalDate date;

    @Type(type = "json")
    @Column(columnDefinition = "additional_Properties")
    private Map<String, Object> additionalProperties;

}
