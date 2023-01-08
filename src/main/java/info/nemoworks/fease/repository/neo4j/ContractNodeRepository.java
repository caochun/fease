package info.nemoworks.fease.repository.neo4j;

import info.nemoworks.fease.repository.neo4j.model.ContractNode;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("neo4j")
public interface ContractNodeRepository extends Neo4jRepository<ContractNode, Long> {
}
