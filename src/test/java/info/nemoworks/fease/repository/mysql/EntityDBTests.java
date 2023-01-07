package info.nemoworks.fease.repository.mysql;

import info.nemoworks.fease.model.Entity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EntityDBTests {
    @Autowired
    private EntityDB entityDB;

    @Test
    void testFindAllReturnsName() {
        // This is defined in tc-initscript.sql
        List<Entity> entities = entityDB.findAll();
        assertThat(entities.size()).isOne();
    }
}
