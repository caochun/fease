package info.nemoworks.fease.service;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;

public interface FeaseService {

    Contract saveContract(Contract contract);

    void removeContract(Contract contract);

    Contract updateContract(Contract contract);
  
    Contract getContractByCode(String code);

    Customer getCustomerById(String id);

    
}