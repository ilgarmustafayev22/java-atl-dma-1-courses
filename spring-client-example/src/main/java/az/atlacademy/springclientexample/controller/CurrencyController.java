package az.atlacademy.springclientexample.controller;

import az.atlacademy.springclientexample.dto.PriceDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @GetMapping
    public ResponseEntity<PriceDto> getPrice(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json",
                PriceDto.class);
    }

}
