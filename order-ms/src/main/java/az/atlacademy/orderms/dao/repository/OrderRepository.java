package az.atlacademy.orderms.dao.repository;

import az.atlacademy.orderms.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
