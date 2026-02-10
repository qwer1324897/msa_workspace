package com.ch.saga_shop.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class OrderCreatedMessage {
    private String productId;  // 주문 시 주문과 관련된 로그 추적용 ID +@ Micrometer Tracing. 로그 ID 쓸 때 많이 쓰이는 프레임워크 (이런 것도 있다)
    private Long requestId;
    private String productName;
}
