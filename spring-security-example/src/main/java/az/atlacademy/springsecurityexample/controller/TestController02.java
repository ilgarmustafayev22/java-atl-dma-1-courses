package az.atlacademy.springsecurityexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
public class TestController02 {

    @GetMapping("/test-admin")
    public String test2() {
        return "test2";
    }

}
