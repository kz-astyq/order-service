package kz.astyq.orderservice.order.view.service;

import kz.astyq.orderservice.order.model.dto.OrderCreateRequest;
import kz.astyq.orderservice.order.model.dto.OrderViewResponse;

import java.util.UUID;

public interface OrderViewService {
    OrderViewResponse createOrder(UUID idempotencyKey, OrderCreateRequest request);
}
