package kz.astyq.orderservice.order.mapper;

import kz.astyq.orderservice.order.model.dto.OrderCreateRequest;
import kz.astyq.orderservice.order.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "restaurantName", ignore = true)
    @Mapping(target = "restaurantOwnerId", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "subtotal", ignore = true)
    @Mapping(target = "deliveryFee", ignore = true)
    @Mapping(target = "totalAmount", ignore = true)
    @Mapping(target = "idempotencyKey", ignore = true)
    @Mapping(target = "cancellationReason", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Order toEntity(OrderCreateRequest request);
}
