package kz.astyq.orderservice.order.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kz.astyq.orderservice.order.model.entity.Address;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCreateRequest {
    @NotNull
    private Long restaurantId;
//    private OrderItem items:
    @NotNull
    @Valid
    private Address deliveryAddress;
    @Size(max = 500)
    private String customerComment;
    private Long customerId; // TODO: get from jwt
}
