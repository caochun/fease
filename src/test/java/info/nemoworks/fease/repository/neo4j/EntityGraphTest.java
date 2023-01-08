package info.nemoworks.fease.repository.neo4j;

import info.nemoworks.fease.repository.neo4j.model.ContractNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.transaction.annotation.Propagation.NEVER;

@DataNeo4jTest
@Testcontainers
@Transactional(propagation = NEVER)
@ActiveProfiles("neo4j")
public class EntityGraphTest {

    @Container
    static Neo4jContainer<?> neo4jContainer = new Neo4jContainer<>("neo4j:4.4.5")
            .withStartupTimeout(Duration.ofMinutes(5));

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.neo4j.uri", neo4jContainer::getBoltUrl);
        registry.add("spring.neo4j.authentication.username", () -> "neo4j");
        registry.add("spring.neo4j.authentication.password", neo4jContainer::getAdminPassword);
    }

    @Autowired
    private ContractNodeRepository contractNodeRepository;

    @Test
    void testFindAllReturnsName() {
        contractNodeRepository.save(new ContractNode());
        List<ContractNode> entities = contractNodeRepository.findAll();
        assertThat(entities.size()).isOne();
    }


}
