package kz.astyq.orderservice.order.repository;

import kz.astyq.orderservice.order.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
