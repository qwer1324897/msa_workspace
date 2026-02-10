package com.ch.saga_shop.service;

import com.ch.saga_shop.message.OrderCreatedMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderCreatedMessage msg) {
        rabbitTemplate.convertAndSend("", "order.create.queue", msg);
        log.debug("RabbitMQ로 주문 메세지 전송 함");
    }
}
