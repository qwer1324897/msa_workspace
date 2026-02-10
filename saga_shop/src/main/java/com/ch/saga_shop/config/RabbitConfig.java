package com.ch.saga_shop.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 래빗엠큐 메세지를 만드는 생산자를 Producer 라고 함.
 레빗엠큐 메세지를 읽어들이는 쪽(소비자)을 Consumer 라고 함.
*/
@Configuration
public class RabbitConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    // 이걸 해주면 rabbit 에 보낼 때 자동으로 자바 객체를 json 으로 보내주고, queue 에서 다시 서버로 보내줄 때 json을 다시 자바객체로 변환해줌.
    // 얘가 알아서 자동으로 다 해줌.
}
