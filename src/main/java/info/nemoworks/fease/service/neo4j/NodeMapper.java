package info.nemoworks.fease.service.neo4j;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.repository.neo4j.model.ContractNode;
import info.nemoworks.fease.repository.neo4j.model.CustomerNode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NodeMapper {
    NodeMapper INSTANCE = Mappers.getMapper(NodeMapper.class);

    ContractNode contractToContractNode(Contract contract);

    Contract contractNodeToContract(ContractNode contractNode);

    Customer customerNodeToCustomer(CustomerNode customerNode);

    CustomerNode customerToCustomerNode(Customer customer);

    default String fromLong(Long id) {
        return id.toString();
    }

    default Long fromString(String id) {
        return Long.parseLong(id);
    }

}
