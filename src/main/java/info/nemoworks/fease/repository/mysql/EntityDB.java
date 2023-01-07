package info.nemoworks.fease.repository.mysql;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.Entity;
import info.nemoworks.fease.repository.EntityRepository;
import info.nemoworks.fease.repository.mysql.model.CustomerEntityRepository;
import info.nemoworks.fease.repository.mysql.model.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EntityDB implements EntityRepository {

    @Autowired
    private ContractEntityRepository contractEntityRepository;

    @Autowired
    private CustomerEntityRepository customerEntityRepository;

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
            return EntityMapper.INSTANCE.contractEntityToContract(contractEntityRepository.save(EntityMapper.INSTANCE.contractToContractEntity((Contract) entity)));
        }
        if (entity instanceof Customer) {
            return EntityMapper.INSTANCE.customerEntityToCustomer(customerEntityRepository.save(EntityMapper.INSTANCE.customerToCustomerEntity((Customer) entity)));
        }
        return null;
    }

    @Override
    public List<Entity> findAll() {
        return null;
    }
}
