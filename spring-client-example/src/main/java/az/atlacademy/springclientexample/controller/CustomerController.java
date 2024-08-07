package az.atlacademy.springclientexample.controller;

import az.atlacademy.springclientexample.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto) {
        restTemplate.postForEntity("http://localhost:8083/customer-app/api/v1/customers",
                customerDto,
                CustomerDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomer(@PathVariable Long id) {
        return restTemplate.getForEntity("http://localhost:8083/customer-app/api/v1/customers/{id}",
                CustomerDto.class,
                id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
         restTemplate.delete("http://localhost:8083/customer-app/api/v1/customers/{id}",
                id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody CustomerDto customerDto){

        // Set the headers
       // HttpHeaders headers = new HttpHeaders();
       // headers.setContentType(MediaType.APPLICATION_JSON);
       // // Create an HttpEntity object with the customerDto and headers
       // HttpEntity<CustomerDto> requestEntity = new HttpEntity<>(customerDto, headers);

        // Send the PUT request
        restTemplate.put("http://localhost:8083/customer-app/api/v1/customers",
                customerDto,
                CustomerDto.class);
        return ResponseEntity.ok().build();
    }

}
