package az.atlacademy.orderms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "customer-client", url = "http://localhost:8080/customer-app/api/v1/customers")
public interface CustomerFeign {

    @PostMapping("/{customerId}")
    void decreaseBalance(@PathVariable Long customerId, @RequestParam BigDecimal bigDecimal);

  //  @GetMapping("/{id}")
  //  CustomerDto getCustomer(@PathVariable Long id);

}
