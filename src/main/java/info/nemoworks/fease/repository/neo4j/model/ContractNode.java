package info.nemoworks.fease.repository.neo4j.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.persistence.Embedded;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Node
public class ContractNode {

    @Id @GeneratedValue
    private Long id;

    private LocalDate date;

    @Relationship(type = "CUSTOMER")
    private CustomerNode customer;

    @Relationship(type = "SUBCONTRACT")
    private List<ContractNode> subContracts;

    @CompositeProperty
    private Map<String, Object> contents;
}
