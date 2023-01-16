package info.nemoworks.fease.repository.mysql.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    private Long id;

    @ManyToOne
    private ContractEntity contract;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
