package info.nemoworks.fease.repository.mysql.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectEntity {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
