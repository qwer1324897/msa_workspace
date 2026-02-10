package com.ch.productservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    // 나의 로컬에서 가져온 변수가 아닌, 외부의 Github 에서 진짜로 변수를 가져오는지 테스트해보자
    @Value("${app.productId}")
    private long productId;

    @Value("${app.productName}")
    private String productName;

    // 목록보기
    @GetMapping("/list")  // 원래 REST 방식에선 list 가 필요없지만 지금은 연습이므로 강조하기 위해 list 를 부여.
    public ResponseEntity<Map<String, Object>> getProductList() {
        return ResponseEntity.ok(Map.of(
                "productId", productId,
                "productName", productName
        )) ;
    }

    // 상세보기
    @GetMapping("/detail")
    public ResponseEntity<?> getDetail() {

        return ResponseEntity.ok(Map.of(
                "productId", productId,
                "productName", productName
        ));
    }

    // 추후 위의 api 메서드들은 http://localhost:9991/swagger-ui/index.html 로


}