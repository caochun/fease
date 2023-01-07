package info.nemoworks.fease.repository.neo4j.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
public class CustomerNode {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
