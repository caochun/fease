package info.nemoworks.fease.repository.mysql.model;

import javax.persistence.*;

@Entity
@Table(name = "sub_contracts")
public class SubContractEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
