package info.nemoworks.fease.storage.mongodb;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.Entity;
import info.nemoworks.fease.storage.EntityStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class DocumentStorage implements EntityStorage {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    CustomerRepository customerRepository;

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
            ContractDocument contractDocument = DocumentMapper.INSTANCE.contractToContractDocument((Contract) entity);
            return DocumentMapper.INSTANCE.contractDocumentToContract(contractRepository.save(contractDocument));
        }
        if (entity instanceof Customer) {
            CustomerDocument customerDocument = DocumentMapper.INSTANCE.customerToCustomerDocument((Customer) entity);
            customerDocument = customerRepository.save(customerDocument);
            Customer customer = DocumentMapper.INSTANCE.customerDocumentToCustomer(customerDocument);
            return customer;
        }
        return null;
    }
}
