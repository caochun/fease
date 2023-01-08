package info.nemoworks.fease.service.neo4j;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.repository.neo4j.ContractNodeRepository;
import info.nemoworks.fease.repository.neo4j.CustomerNodeRepository;
import info.nemoworks.fease.repository.neo4j.model.ContractNode;
import info.nemoworks.fease.service.FeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("neo4j")
public class FeaseGraphService implements FeaseService {


    private ContractNodeRepository contractNodeRepository;

    private CustomerNodeRepository customerNodeRepository;


    private NodeMapper mapper = NodeMapper.INSTANCE;

    @Autowired
    public void setContractNodeRepository(ContractNodeRepository contractNodeRepository) {
        this.contractNodeRepository = contractNodeRepository;
    }

    @Autowired
    public void setCustomerNodeRepository(CustomerNodeRepository customerNodeRepository) {
        this.customerNodeRepository = customerNodeRepository;
    }

    @Override
    public Contract saveContract(Contract contract) {
        ContractNode contractNode = contractNodeRepository.save(mapper.contractToContractNode(contract));
        return mapper.contractNodeToContract(contractNode);
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
        return null;
    }

    @Override
    public Customer getCustomerById(String id) {
        return null;
    }


}
