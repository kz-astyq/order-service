package kz.astyq.orderservice.order.model.dto;

import kz.astyq.orderservice.order.model.entity.Address;
import kz.astyq.orderservice.order.model.enums.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderViewResponse {
    private Long id;
    private Long customerId;
    private Long restaurantId;
    private String restaurantName;
    private OrderStatus status;
//    private List<OrderItemViewResponse> orderItems;
    private BigDecimal subtotal;
    private BigDecimal totalAmount;
    private BigDecimal deliveryFee;
    private Address deliveryAddress;
    private String customerComment;
    private String cancellationReason;
    private Instant createdAt;
    private Instant updatedAt;
}
