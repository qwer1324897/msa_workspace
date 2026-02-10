package com.ch.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Value("${app.productId}")
    private long productId;

    @Value("${app.productName}")
    private String productName;

    @GetMapping("/main")  // 원래 REST 방식에선 list 가 필요없지만 지금은 연습이므로 강조하기 위해 list 를 부여.
    public ResponseEntity<Map<String, Object>> getOrderList() {
        return ResponseEntity.ok(Map.of(
                "orderId", productId,
                "orderName", productName
        )) ;
    }
}