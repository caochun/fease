package info.nemoworks.fease.storage.mongodb;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    ContractDocument contractToContractDocument(Contract contract);

    Contract contractDocumentToContract(ContractDocument contractDocument);

    Customer customerDocumentToCustomer(CustomerDocument customerDocument);

    CustomerDocument customerToCustomerDocument(Customer customer);

}
