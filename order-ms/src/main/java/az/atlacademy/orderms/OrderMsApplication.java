package az.atlacademy.orderms;

import az.atlacademy.orderms.feign.CustomerFeign;
import az.atlacademy.orderms.feign.ProductFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {CustomerFeign.class, ProductFeign.class})
public class OrderMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMsApplication.class, args);
    }

}
