package az.atlacademy.springclientexample.controller;

import az.atlacademy.springclientexample.dto.CustomerDto;
import az.atlacademy.springclientexample.feign.CustomerFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feign-client")
public class CustomerFeignController {

    private final CustomerFeign customerFeign;
    @PostMapping
    public ResponseEntity<Void> createCustomerWithFeign(@RequestBody CustomerDto customerDto) {
        customerFeign.createCustomerWithFeign(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomer(@PathVariable Long id) {
      return ResponseEntity.ok(customerFeign.getCustomer(id));
    }

}
