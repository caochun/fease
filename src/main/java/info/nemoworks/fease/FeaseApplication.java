package info.nemoworks.fease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages="info.nemoworks.fease.repository.mysql")
@EnableNeo4jRepositories(basePackages="info.nemoworks.fease.repository.neo4j")
public class FeaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeaseApplication.class, args);
    }
}