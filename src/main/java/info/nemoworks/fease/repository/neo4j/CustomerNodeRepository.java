package info.nemoworks.fease.repository.neo4j;

import info.nemoworks.fease.repository.neo4j.model.CustomerNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerNodeRepository extends Neo4jRepository<CustomerNode, Long> {
    CustomerNode findByName(String name);
}
