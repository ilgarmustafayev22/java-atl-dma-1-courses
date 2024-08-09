package az.atlacademy.orderms.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto {

    private Long id;
    private Long customerId;
    private Long productId;
    private String name;
    private BigDecimal price;
    private Integer count;

}
