package az.atlacademy.springclientexample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BpiDto {

    @JsonProperty("USD")
    private CurrencyDto usd;

    @JsonProperty("GBP")
    private CurrencyDto gbp;

    @JsonProperty("EUR")
    private CurrencyDto eur;

}
