package info.nemoworks.fease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.util.Arrays;

//@SpringBootApplication
//@ComponentScan(basePackages = {"info.nemoworks.fease.service", "info.nemoworks.fease.repository"})
public class FeaseApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(FeaseApplication.class, args);
    }

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private Environment environment;


    @Override
    public void run(String... args) throws Exception {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }

        String[] profiles = this.environment.getActiveProfiles();
        System.out.println(profiles.length);

        for (String profile : profiles) {
            System.out.println(profile);
        }

    }
}