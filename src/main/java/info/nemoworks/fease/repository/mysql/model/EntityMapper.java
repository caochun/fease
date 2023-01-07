package info.nemoworks.fease.repository.mysql.model;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.Project;
import info.nemoworks.fease.repository.neo4j.ContractNode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    ContractEntity contractToContractEntity(Contract contract);

    Contract contractEntityToContract(ContractEntity contractEntity);

    CustomerEntity customerToCustomerEntity(Customer customer);

    Customer customerEntityToCustomer(CustomerEntity customerEntity);


    ProjectEntity projectToProjectEntity(Project project);

    Project projectEntityToProject(ProjectEntity projectEntity);
}
