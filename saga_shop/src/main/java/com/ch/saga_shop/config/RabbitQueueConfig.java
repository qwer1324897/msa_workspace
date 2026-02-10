package com.ch.saga_shop.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 추후 MSA 로 분리시켰을 때 아래의 Bean 은 Consumer 쪽에 둬야 한다.
@Configuration
public class RabbitQueueConfig {

    @Bean
    public Queue orderCreateQueue() {
        return new Queue("order.create.queue", true);   // durable 은 영구저장을 의미. 안 해놓으면 서버 껏다키면 다 사라짐.
    }
}
