package info.nemoworks.fease;

import info.nemoworks.fease.storage.neo4j.ContractNode;
import info.nemoworks.fease.storage.neo4j.ContractNodeRepository;
import info.nemoworks.fease.storage.neo4j.CustomerNode;
import info.nemoworks.fease.storage.neo4j.CustomerNodeRepository;
import org.neo4j.configuration.connectors.BoltConnector;
import org.neo4j.configuration.helpers.SocketAddress;
import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.io.fs.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

import static org.neo4j.configuration.GraphDatabaseSettings.DEFAULT_DATABASE_NAME;

@SpringBootApplication
@EnableNeo4jRepositories
public class Neo4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }


    private static final Path DB_PATH = Path.of("neo4jdb");

    @Bean
    public GraphDatabaseService graphDb() throws IOException {
        FileUtils.deleteDirectory(DB_PATH);

        DatabaseManagementService managementService = new DatabaseManagementServiceBuilder(DB_PATH)
                .setConfig(BoltConnector.enabled, true)
                .setConfig(BoltConnector.listen_address, new SocketAddress("localhost", 7687)).
                build();
        registerShutdownHook(managementService);

        return managementService.database(DEFAULT_DATABASE_NAME);
    }

    private static void registerShutdownHook(final DatabaseManagementService managementService) {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                managementService.shutdown();
            }
        });
    }

    @Bean
    CommandLineRunner demo(ContractNodeRepository contractNodeRepository) {
        return args -> {

            contractNodeRepository.deleteAll();

            CustomerNode customerNode = new CustomerNode();
            customerNode.setName("张三");

            ContractNode contractNode = new ContractNode();
            contractNode.setDate(LocalDateTime.now());
            contractNode.setCustomer(customerNode);

            contractNodeRepository.save(contractNode);


            System.out.println(contractNode);


        };
    }

}
