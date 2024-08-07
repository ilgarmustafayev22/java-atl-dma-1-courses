package az.atlacademy.springclientexample;

import az.atlacademy.springclientexample.feign.CustomerFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = CustomerFeign.class)
public class SpringClientExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClientExampleApplication.class, args);
    }

}
