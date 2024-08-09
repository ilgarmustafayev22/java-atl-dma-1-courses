package az.atlacademy.customerms.service.impl;

import az.atlacademy.customerms.dao.entity.CustomerEntity;
import az.atlacademy.customerms.exception.CustomerNotFoundException;
import az.atlacademy.customerms.dao.repository.CustomerRepository;
import az.atlacademy.customerms.mapper.CustomerMapper;
import az.atlacademy.customerms.model.CustomerDto;
import az.atlacademy.customerms.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void createCustomer(CustomerDto customer) {
        customerRepository.save(customerMapper.toEntity(customer));
    }

    @Override
    public CustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
        customerEntity.setFullName(customerDto.getFullName());
        customerEntity.setAge(customerDto.getAge());
        customerEntity.setPin(customerDto.getPin());
        customerEntity.setBalance(customerDto.getBalance());
        customerRepository.save(customerEntity);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void decreaseBalance(Long customerId, BigDecimal price) {
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));

        customerEntity.setBalance(customerEntity.getBalance().min(price));
        customerRepository.save(customerEntity);
    }

}
