package az.atlacademy.orderms.service.impl;

import az.atlacademy.orderms.dao.entity.OrderEntity;
import az.atlacademy.orderms.dao.repository.OrderRepository;
import az.atlacademy.orderms.exception.CustomerNotFoundException;
import az.atlacademy.orderms.feign.CustomerFeign;
import az.atlacademy.orderms.feign.ProductFeign;
import az.atlacademy.orderms.mapper.OrderMapper;
import az.atlacademy.orderms.model.OrderDto;
import az.atlacademy.orderms.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final CustomerFeign customerFeign;
    private final ProductFeign productFeign;

    @Override
    @Transactional
    public void createOrder(OrderDto orderDto) {
        customerFeign.decreaseBalance(orderDto.getCustomerId(),
                orderDto.getPrice().multiply(BigDecimal.valueOf(orderDto.getCount())));
        productFeign.decreaseCount(orderDto.getProductId(), orderDto.getCount());
        orderRepository.save(orderMapper.toEntity(orderDto));
    }

    @Override
    public OrderDto findById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public void updateOrder(Long id, OrderDto orderDto) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));

        orderEntity.setName(orderDto.getName());
        orderEntity.setPrice(orderDto.getPrice());
        orderEntity.setCount(orderEntity.getCount());
        orderRepository.save(orderEntity);
    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
