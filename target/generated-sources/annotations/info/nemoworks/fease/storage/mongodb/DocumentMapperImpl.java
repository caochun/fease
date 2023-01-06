package info.nemoworks.fease.storage.mongodb;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.SubContract;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-06T15:53:27+0800",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
public class DocumentMapperImpl implements DocumentMapper {

    @Override
    public ContractDocument contractToContractDocument(Contract contract) {
        if ( contract == null ) {
            return null;
        }

        ContractDocument contractDocument = new ContractDocument();

        contractDocument.setContents( contract.getContents() );
        contractDocument.setCustomer( contract.getCustomer() );
        contractDocument.setDate( contract.getDate() );
        contractDocument.setId( contract.getId() );
        contractDocument.setSubContracts( subContractListToContractList( contract.getSubContracts() ) );

        return contractDocument;
    }

    @Override
    public Contract contractDocumentToContract(ContractDocument contractDocument) {
        if ( contractDocument == null ) {
            return null;
        }

        Contract contract = new Contract();

        contract.setId( contractDocument.getId() );
        contract.setContents( contractDocument.getContents() );
        contract.setCustomer( contractDocument.getCustomer() );
        contract.setDate( contractDocument.getDate() );
        contract.setSubContracts( contractListToSubContractList( contractDocument.getSubContracts() ) );

        return contract;
    }

    @Override
    public Customer customerDocumentToCustomer(CustomerDocument customerDocument) {
        if ( customerDocument == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDocument.getId() );
        customer.setName( customerDocument.getName() );

        return customer;
    }

    @Override
    public CustomerDocument customerToCustomerDocument(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDocument customerDocument = new CustomerDocument();

        customerDocument.setId( customer.getId() );
        customerDocument.setName( customer.getName() );

        return customerDocument;
    }

    protected Contract subContractToContract(SubContract subContract) {
        if ( subContract == null ) {
            return null;
        }

        Contract contract = new Contract();

        contract.setId( subContract.getId() );

        return contract;
    }

    protected List<Contract> subContractListToContractList(List<SubContract> list) {
        if ( list == null ) {
            return null;
        }

        List<Contract> list1 = new ArrayList<Contract>( list.size() );
        for ( SubContract subContract : list ) {
            list1.add( subContractToContract( subContract ) );
        }

        return list1;
    }

    protected SubContract contractToSubContract(Contract contract) {
        if ( contract == null ) {
            return null;
        }

        SubContract subContract = new SubContract();

        subContract.setId( contract.getId() );

        return subContract;
    }

    protected List<SubContract> contractListToSubContractList(List<Contract> list) {
        if ( list == null ) {
            return null;
        }

        List<SubContract> list1 = new ArrayList<SubContract>( list.size() );
        for ( Contract contract : list ) {
            list1.add( contractToSubContract( contract ) );
        }

        return list1;
    }
}
