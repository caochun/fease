package info.nemoworks.fease.repository.mysql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contracts")
@Data
public class ContractEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    protected Long id;

    @Column(name="code")
    private String code;

    @Column(name="date_sign")
    private LocalDate date;

}
