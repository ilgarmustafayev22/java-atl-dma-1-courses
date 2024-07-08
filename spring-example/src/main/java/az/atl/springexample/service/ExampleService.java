package az.atl.springexample.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Service
public class ExampleService {

    public List<String> getAllStrings(){
        return List.of("A", "B", "C");
    }

}
