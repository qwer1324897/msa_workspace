package com.ch.saga_shop.controller;

import com.ch.saga_shop.dto.OrderRequest;
import com.ch.saga_shop.message.OrderCreatedMessage;
import com.ch.saga_shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> handleOrder(@RequestBody OrderRequest orderRequest) {
        log.debug("상품 pk 값은 {}", orderRequest.getProductId());
        log.debug("상품명은 {}", orderRequest.getProductName());

        OrderCreatedMessage msg = new OrderCreatedMessage(UUID.randomUUID().toString(), orderRequest.getProductId(), orderRequest.getProductName());
        orderService.sendMessage(msg);
        return ResponseEntity.ok(Map.of("주문성공", orderRequest));
    }
}
