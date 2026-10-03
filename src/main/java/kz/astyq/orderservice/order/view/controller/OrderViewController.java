package kz.astyq.orderservice.order.view.controller;

import kz.astyq.orderservice.order.model.dto.OrderCreateRequest;
import kz.astyq.orderservice.order.model.dto.OrderViewResponse;
import kz.astyq.orderservice.order.view.service.OrderViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderViewController {
    private final OrderViewService service;

    @PostMapping
    public ResponseEntity<OrderViewResponse> createOrder(
            @RequestHeader("Idempotency-Key") UUID idempotencyKey,
            @RequestBody OrderCreateRequest request) {
        return ResponseEntity.ok(service.createOrder(idempotencyKey, request));
    }
}
