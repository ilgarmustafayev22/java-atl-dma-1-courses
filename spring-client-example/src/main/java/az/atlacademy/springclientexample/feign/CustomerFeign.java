package az.atlacademy.springclientexample.feign;

import az.atlacademy.springclientexample.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customer-client", url = "http://localhost:8083/customer-app/api/v1/customers")
public interface CustomerFeign {

    @PostMapping
    void createCustomerWithFeign(@RequestBody CustomerDto customerDto);

    @GetMapping("/{id}")
    CustomerDto getCustomer(@PathVariable Long id);

}
