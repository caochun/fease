package info.nemoworks.fease;

import com.alibaba.fastjson.JSONObject;
import info.nemoworks.fease.controller.dto.DtoMapper;
import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.repository.neo4j.ContractNodeRepository;
import info.nemoworks.fease.repository.neo4j.model.ContractNode;
import info.nemoworks.fease.service.FeaseService;
import org.neo4j.configuration.connectors.BoltConnector;
import org.neo4j.configuration.helpers.SocketAddress;
import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.io.fs.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.neo4j.configuration.GraphDatabaseSettings.DEFAULT_DATABASE_NAME;

@SpringBootApplication
@EnableNeo4jRepositories("info.nemoworks.fease.repository.neo4j")
public class FeaseNeo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeaseNeo4jApplication.class, args);
    }

    private static final Path DB_PATH = Path.of("fease_graph");


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

    @Autowired
    private FeaseService feaseService;

    @Bean
    CommandLineRunner demo(ContractNodeRepository contractNodeRepository) {
        return args -> {

            contractNodeRepository.deleteAll();

            Customer customer = new Customer();
            customer.setName("张三");
            customer.setId("202");

            JSONObject jsonObject = JSONObject.parseObject(new String(getClass().getClassLoader().getResourceAsStream("contract_main.json").readAllBytes()));
            Contract contract = DtoMapper.INSTANCE.jsonObjectToContract(jsonObject);

            contract.setDate(LocalDate.now());
            contract.setCustomer(customer);

            feaseService.saveContract(contract);
//            ContractNode contractNode = new ContractNode();
//            Map<String, Object> p = new HashMap<>();
//
//            p.put("a1", 1);
//            p.put("a2", "abc");
//            contractNode.setId(11L);
//            contractNode.setDate(LocalDate.now());
//            contractNode.setContents(p);
//
//            contractNodeRepository.save(contractNode);



        };
    }


}
