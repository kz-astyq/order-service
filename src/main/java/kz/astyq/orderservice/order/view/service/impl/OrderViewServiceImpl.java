package kz.astyq.orderservice.order.view.service.impl;

import kz.astyq.orderservice.order.mapper.OrderMapper;
import kz.astyq.orderservice.order.model.dto.OrderCreateRequest;
import kz.astyq.orderservice.order.model.dto.OrderViewResponse;
import kz.astyq.orderservice.order.model.entity.Order;
import kz.astyq.orderservice.order.repository.OrderRepository;
import kz.astyq.orderservice.order.view.service.OrderViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderViewServiceImpl implements OrderViewService  {
    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Override
    public OrderViewResponse createOrder(UUID idempotencyKey, OrderCreateRequest request) {
        Order order = repository.findByCustomerIdAndIdempotencyKey(request.getCustomerId(), idempotencyKey);
        if (order != null) {
            return mapper.toViewResponse(order);
        }
        order = repository.save(mapper.toEntity(request));
        order.setIdempotencyKey(idempotencyKey);
        return mapper.toViewResponse(order);
    }
}
