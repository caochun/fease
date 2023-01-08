package info.nemoworks.fease.service.mysql;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.Project;
import info.nemoworks.fease.repository.mysql.model.ContractEntity;
import info.nemoworks.fease.repository.mysql.model.CustomerEntity;
import info.nemoworks.fease.repository.mysql.model.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    @Mapping(source = "contents", target ="additionalProperties")
    ContractEntity contractToContractEntity(Contract contract);

    @Mapping(source = "additionalProperties", target ="contents")
    Contract contractEntityToContract(ContractEntity contractEntity);

    CustomerEntity customerToCustomerEntity(Customer customer);

    Customer customerEntityToCustomer(CustomerEntity customerEntity);


    ProjectEntity projectToProjectEntity(Project project);

    Project projectEntityToProject(ProjectEntity projectEntity);


}
