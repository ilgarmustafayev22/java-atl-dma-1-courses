package az.atlacademy.customerms.controller;

import az.atlacademy.customerms.CustomerMsApplication;
import az.atlacademy.customerms.dao.entity.CustomerEntity;
import az.atlacademy.customerms.dao.repository.CustomerRepository;
import az.atlacademy.customerms.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = CustomerMsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "integration")
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "az.atlacademy.customerms.dao.repository")
class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Sql(scripts = "classpath:sql/customers.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clear-customer.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void givenGetCustomerByIdWhenFoundThenReturnDto() {
        ResponseEntity<CustomerDto> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/customer-app/api/v1/customers/1", CustomerDto.class
        );

        CustomerDto customerDto = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(customerDto);
        assertEquals("Test Test", customerDto.getFullName());
    }

    @Test
    @Sql(scripts = "classpath:sql/clear-customer.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void givenCreateCustomerWhenCreatedThenReturnNothing() {
        CustomerDto customerDto = CustomerDto.builder()
                .fullName("Test Test")
                .age(222)
                .pin("A1234")
                .balance(BigDecimal.valueOf(1000))
                .build();

        ResponseEntity<?> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/customer-app/api/v1/customers", customerDto, CustomerDto.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Optional<CustomerEntity> customerEntity = customerRepository.findById(1L);

        assertFalse(customerEntity.isEmpty());
        CustomerEntity customer = customerEntity.get();
        assertEquals(customer.getId(), customerDto.getId());
        assertEquals(customer.getFullName(), customerDto.getFullName());
        assertEquals(customer.getAge(), customerDto.getAge());
        assertEquals(customer.getPin(), customerDto.getPin());
        assertEquals(customer.getBalance(), customerDto.getBalance());

    }
}