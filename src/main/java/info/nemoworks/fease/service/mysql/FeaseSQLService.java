package info.nemoworks.fease.service.mysql;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.repository.mysql.ContractEntityRepository;
import info.nemoworks.fease.repository.mysql.CustomerEntityRepository;
import info.nemoworks.fease.repository.mysql.model.ContractEntity;
import info.nemoworks.fease.service.FeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("mysql")
public class FeaseSQLService implements FeaseService {

    private ContractEntityRepository contractEntityRepository;

    private CustomerEntityRepository customerEntityRepository;

    private EntityMapper mapper = EntityMapper.INSTANCE;

    @Autowired
    public void setContractEntityRepository(ContractEntityRepository contractEntityRepository) {
        this.contractEntityRepository = contractEntityRepository;
    }

    @Autowired
    public void setCustomerEntityRepository(CustomerEntityRepository customerEntityRepository) {
        this.customerEntityRepository = customerEntityRepository;
    }

    @Override
    public Contract saveContract(Contract contract) {
        ContractEntity contractEntity = this.contractEntityRepository.save(mapper.contractToContractEntity(contract));
        return mapper.contractEntityToContract(contractEntity);
    }

    @Override
    public void removeContract(Contract contract) {

    }

    @Override
    public Contract updateContract(Contract contract) {
        return null;
    }

    @Override
    public Contract getContractByCode(String code) {
        ContractEntity contractEntity = contractEntityRepository.getContractEntityByCode(code);
        return mapper.contractEntityToContract(contractEntity);
    }

    @Override
    public Customer getCustomerById(String id) {
        return null;
    }


}
