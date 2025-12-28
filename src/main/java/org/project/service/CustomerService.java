package org.project.service;


import org.project.dto.CustomerDTO;

public interface CustomerService {
    Long create(CustomerDTO customerDto);

    CustomerDTO read(Long customerId);

    boolean update(CustomerDTO customerDto);

    boolean delete(Long customerId);

    CustomerDTO search(String cifNumber, String loanAccountNumber, String loanApplicationId);

    CustomerDTO getByCIFNumber(String cifNumber);

    CustomerDTO getCustomerWithAddressByCIFNumber(String cifNumber);

}
