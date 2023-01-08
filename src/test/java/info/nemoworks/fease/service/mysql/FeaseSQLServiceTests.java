package info.nemoworks.fease.service.mysql;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.service.FeaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
public class FeaseSQLServiceTests {

    @Autowired
    private FeaseService feaseService;

    @Test
    void testFindByCode() {
        Contract contract = feaseService.getContractByCode("TDjZ-2019-HZ-1015");
        assertNotNull(contract);
        Contract contractNotExist = feaseService.getContractByCode("TDjZ-222-HZ-1015");
        assertNull(contractNotExist);
    }
}
