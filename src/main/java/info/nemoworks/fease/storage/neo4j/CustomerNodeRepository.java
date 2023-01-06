package info.nemoworks.fease.storage.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CustomerNodeRepository extends Neo4jRepository<CustomerNode, Long> {
    CustomerNode findByName(String name);
}
