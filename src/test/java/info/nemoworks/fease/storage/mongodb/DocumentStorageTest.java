package info.nemoworks.fease.storage.mongodb;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import info.nemoworks.fease.MMOSApplication;
import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;

import java.time.LocalDateTime;

@ContextConfiguration(classes = {MMOSApplication.class, DocumentStorage.class})
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class DocumentStorageTest {

    @Test
    public void test(@Autowired DocumentStorage documentStorage) throws JSONException {

        Customer customer = new Customer();
        customer.setName("张三3");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "jon doe");
        jsonObject.put("age", "22");
        jsonObject.put("city", "chicago");

//        Contract contract = Contract.builder().date(LocalDateTime.now()).customer(customer).build();
        Contract contract = new Contract();
        contract.setDate(LocalDateTime.now());
//        contract.setContents(jsonObject);


//        customer.setContract(contract);

        customer = (Customer) documentStorage.save(customer);
        contract.setCustomer(customer);
        documentStorage.save(contract);


//        // then
//        assertThat(mongoTemplate.findAll(DBObject.class, "abc")).extracting("key")
//                .containsOnly("value");
    }
}
