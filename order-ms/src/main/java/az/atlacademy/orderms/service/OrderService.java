package az.atlacademy.orderms.service;

import az.atlacademy.orderms.model.OrderDto;

import java.util.List;

public interface OrderService {

    void createOrder(OrderDto orderDto);
    OrderDto findById(Long id);
    List<OrderDto> findAll();
    void updateOrder(Long id,OrderDto orderDto);
    void deleteOrder(Long id);

}
