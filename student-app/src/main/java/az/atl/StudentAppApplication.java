package az.atl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class StudentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAppApplication.class, args);
    }

}
