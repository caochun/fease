package info.nemoworks.fease.repository.neo4j;

import info.nemoworks.fease.repository.neo4j.model.ContractNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractNodeRepository extends Neo4jRepository<ContractNode, Long> {
}
