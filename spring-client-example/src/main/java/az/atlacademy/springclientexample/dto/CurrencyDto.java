package az.atlacademy.springclientexample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyDto {

    private String code;
    private String symbol;
    private String rate;
    private String description;

    @JsonProperty("rate_float")
    private Double rateFloat;

}
