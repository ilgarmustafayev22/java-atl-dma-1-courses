package az.atlacademy.customerms.service.impl;

import az.atlacademy.customerms.dao.entity.CustomerEntity;
import az.atlacademy.customerms.dao.repository.CustomerRepository;
import az.atlacademy.customerms.exception.CustomerNotFoundException;
import az.atlacademy.customerms.mapper.CustomerMapper;
import az.atlacademy.customerms.model.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void find_by_id_customer_success_case() {
        //arrange
        Long customerId = 1L;
        CustomerDto customerDto = CustomerDto
                .builder()
                .fullName("Test Test")
                .age(222)
                .pin("A123")
                .balance(BigDecimal.valueOf(1000))
                .build();

        CustomerEntity customerEntity = CustomerEntity.builder()
                .fullName(customerDto.getFullName())
                .age(customerDto.getAge())
                .pin(customerDto.getPin())
                .balance(customerDto.getBalance())
                .build();

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));
        when(customerMapper.toDto(customerEntity)).thenReturn(customerDto);

        //assert
        Assertions.assertEquals(customerEntity.getId(), customerDto.getId());
        Assertions.assertEquals(customerEntity.getFullName(), customerDto.getFullName());
        Assertions.assertEquals(customerEntity.getAge(), customerDto.getAge());
        Assertions.assertEquals(customerEntity.getPin(), customerDto.getPin());
        Assertions.assertEquals(customerEntity.getBalance(), customerDto.getBalance());
        Assertions.assertDoesNotThrow(() -> customerService.findById(customerId));
    }

    @Test
    public void find_by_id_customer_failed_case() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.findById(customerId));
    }

    @Test
    public void create_customer_success_case() {
        CustomerDto customerDto = CustomerDto
                .builder()
                .fullName("Test Test")
                .age(222)
                .pin("A123")
                .balance(BigDecimal.valueOf(1000))
                .build();

        CustomerEntity customerEntity = CustomerEntity.builder()
                .fullName(customerDto.getFullName())
                .age(customerDto.getAge())
                .pin(customerDto.getPin())
                .balance(customerDto.getBalance())
                .build();

        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
        when(customerMapper.toEntity(customerDto)).thenReturn(customerEntity);

        Assertions.assertDoesNotThrow(() -> customerService.createCustomer(customerDto));
    }

    @Test
    public void update_customer_success_case(){
        Long customerId = 1L;
        CustomerEntity customerEntity = CustomerEntity
                .builder()
                .fullName("Test Test")
                .age(222)
                .pin("A123")
                .balance(BigDecimal.valueOf(1000))
                .build();

        CustomerDto customerDto = CustomerDto
                .builder()
                .fullName("Test Test")
                .age(222)
                .pin("A123")
                .balance(BigDecimal.valueOf(1000))
                .build();

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));

        Assertions.assertEquals(customerEntity.getId(), customerDto.getId());
        Assertions.assertEquals(customerEntity.getFullName(), customerDto.getFullName());
        Assertions.assertEquals(customerEntity.getAge(), customerDto.getAge());
        Assertions.assertEquals(customerEntity.getPin(), customerDto.getPin());
        Assertions.assertEquals(customerEntity.getBalance(), customerDto.getBalance());
        Assertions.assertDoesNotThrow(() -> customerService.updateCustomer(customerId, customerDto));
    }

    @Test
    public void update_customer_failed_case(){
        Long customerId = 1L;

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.findById(customerId));
    }

    @Test
    public void delete_customer_success_case(){
        Long customerId = 1L;

        // Act
        customerService.deleteCustomer(customerId);

        // Assert
        verify(customerRepository).deleteById(customerId);
    }

    @Test
    public void decrease_balance_success_case(){
        Long customerId = 1L;
        BigDecimal price = BigDecimal.valueOf(100);

        BigDecimal initialPrice = BigDecimal.valueOf(1000);
        BigDecimal expectedBalance  = initialPrice.subtract(price);

        CustomerEntity customerEntity = CustomerEntity.builder()
                .fullName("Test Test")
                .age(222)
                .pin("A123")
                .balance(BigDecimal.valueOf(1000))
                .build();

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        Assertions.assertEquals(expectedBalance, customerEntity.getBalance().subtract(price));
        Assertions.assertDoesNotThrow(() -> customerService.decreaseBalance(customerId, price));
    }

    @Test
    public void decrease_balance_failed_case(){
        Long customerId = 1L;
        BigDecimal price = BigDecimal.valueOf(100);

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.decreaseBalance(customerId, price));
    }

}