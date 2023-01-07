package info.nemoworks.fease.repository.mysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACTS")
public class ContractEntity {
    @Id
    @GeneratedValue
    protected Long id;


}
