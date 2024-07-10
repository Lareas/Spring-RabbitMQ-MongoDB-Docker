package com.btgtest.configuration;

import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.btgtest.configuration.AppConstants.BTG_PEDIDOS_QUEUE;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Declarable pedidosCreatedQueue() {
        return new Queue(BTG_PEDIDOS_QUEUE);
    }
}
