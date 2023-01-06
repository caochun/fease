package info.nemoworks.fease.storage.neo4j;

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
public class NodeMapperImpl implements NodeMapper {

    @Override
    public ContractNode contractToContractNode(Contract contract) {
        if ( contract == null ) {
            return null;
        }

        ContractNode contractNode = new ContractNode();

        contractNode.setContents( contract.getContents() );
        contractNode.setCustomer( customerToCustomerNode( contract.getCustomer() ) );
        contractNode.setDate( contract.getDate() );
        contractNode.setId( fromString( contract.getId() ) );
        contractNode.setSubContracts( subContractListToContractNodeList( contract.getSubContracts() ) );

        return contractNode;
    }

    @Override
    public Contract contractNodeToContract(ContractNode contractNode) {
        if ( contractNode == null ) {
            return null;
        }

        Contract contract = new Contract();

        contract.setId( fromLong( contractNode.getId() ) );
        contract.setContents( contractNode.getContents() );
        contract.setCustomer( customerNodeToCustomer( contractNode.getCustomer() ) );
        contract.setDate( contractNode.getDate() );
        contract.setSubContracts( contractNodeListToSubContractList( contractNode.getSubContracts() ) );

        return contract;
    }

    @Override
    public Customer customerNodeToCustomer(CustomerNode customerNode) {
        if ( customerNode == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( fromLong( customerNode.getId() ) );
        customer.setName( customerNode.getName() );

        return customer;
    }

    @Override
    public CustomerNode customerToCustomerNode(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerNode customerNode = new CustomerNode();

        customerNode.setId( fromString( customer.getId() ) );
        customerNode.setName( customer.getName() );

        return customerNode;
    }

    protected ContractNode subContractToContractNode(SubContract subContract) {
        if ( subContract == null ) {
            return null;
        }

        ContractNode contractNode = new ContractNode();

        contractNode.setId( fromString( subContract.getId() ) );

        return contractNode;
    }

    protected List<ContractNode> subContractListToContractNodeList(List<SubContract> list) {
        if ( list == null ) {
            return null;
        }

        List<ContractNode> list1 = new ArrayList<ContractNode>( list.size() );
        for ( SubContract subContract : list ) {
            list1.add( subContractToContractNode( subContract ) );
        }

        return list1;
    }

    protected SubContract contractNodeToSubContract(ContractNode contractNode) {
        if ( contractNode == null ) {
            return null;
        }

        SubContract subContract = new SubContract();

        subContract.setId( fromLong( contractNode.getId() ) );

        return subContract;
    }

    protected List<SubContract> contractNodeListToSubContractList(List<ContractNode> list) {
        if ( list == null ) {
            return null;
        }

        List<SubContract> list1 = new ArrayList<SubContract>( list.size() );
        for ( ContractNode contractNode : list ) {
            list1.add( contractNodeToSubContract( contractNode ) );
        }

        return list1;
    }
}
