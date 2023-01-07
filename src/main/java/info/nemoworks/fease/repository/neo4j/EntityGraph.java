package info.nemoworks.fease.repository.neo4j;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.Entity;
import info.nemoworks.fease.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntityGraph implements EntityRepository {

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

    @Override
    public List<Entity> findAll() {
        return null;
    }
}
