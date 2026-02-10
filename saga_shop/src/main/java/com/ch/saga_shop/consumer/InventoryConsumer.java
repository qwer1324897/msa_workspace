package com.ch.saga_shop.consumer;

// 메세지를 받는 쪽. 주문 > 물류 구조면 물류쪽에 해당.

import com.ch.saga_shop.message.OrderCreatedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryConsumer {

    // RabbitMQ에 구독한 Queue 로부터 메세지 가져오기
//    @RabbitListener(queues = "order.create.queue")
    public void receiveMessage(OrderCreatedMessage msg) {
        log.debug("RabbitMQ로 수신한 메세지는: {}", msg);

        // 재고관리 팀의 개발자는 여기서 재고처리를 해야 한다.
        log.debug("재고 관리팀으로부터 주문정보 수신 받음. 지금부터 재고 처리 할 예정.");

    }

}
