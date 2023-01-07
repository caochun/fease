package info.nemoworks.fease.repository.neo4j;

import org.junit.jupiter.api.Test;

import info.nemoworks.fease.model.Customer;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeMappertest {

    @Test
    public void fromNodeToEntityTest(){
        CustomerNode customerNode = new CustomerNode();
        customerNode.setName("张三");
        customerNode.setId(101L);

        NodeMapper mapper = NodeMapper.INSTANCE;

        Customer customer = mapper.customerNodeToCustomer(customerNode);

        assertThat(customer.getName().equals("张三"));
        assertThat(customer.getId().equals("101"));

    }
}
