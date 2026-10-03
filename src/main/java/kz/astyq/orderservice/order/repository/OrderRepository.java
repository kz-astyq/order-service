package kz.astyq.orderservice.order.repository;

import kz.astyq.orderservice.order.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByCustomerIdAndIdempotencyKey(Long customerId, UUID idempotencyKey);
}
