package info.nemoworks.fease.storage.neo4j;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.Entity;
import info.nemoworks.fease.storage.EntityStorage;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityGraph implements EntityStorage {

    @Autowired
    private ContractNodeRepository contractNodeRepository;

    @Autowired
    private CustomerNodeRepository customerNodeRepository;

    @Override
    public Entity get(String id) {
        return null;
    }

    @Override
    public void delete(Entity entity) {

    }

    @Override
    public Entity save(Entity entity) {
        if (entity instanceof Contract) {
            return NodeMapper.INSTANCE.contractNodeToContract(contractNodeRepository.save(NodeMapper.INSTANCE.contractToContractNode((Contract) entity)));
        }
        if (entity instanceof Customer) {
            return NodeMapper.INSTANCE.customerNodeToCustomer(customerNodeRepository.save(NodeMapper.INSTANCE.customerToCustomerNode((Customer) entity)));

        }
        return null;
    }
}
