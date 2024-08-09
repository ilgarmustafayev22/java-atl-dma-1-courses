package az.atlacademy.customerms.service;

import az.atlacademy.customerms.model.CustomerDto;

import java.math.BigDecimal;

public interface CustomerService {

    void createCustomer(CustomerDto customer);

    CustomerDto findById(Long id);

    void updateCustomer(Long id, CustomerDto customerDto);

    void deleteCustomer(Long id);

    void decreaseBalance(Long customerId, BigDecimal price);

}
