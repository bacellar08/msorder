package io.github.bacellar08.btgpactual.msorder.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String ORDER_CREATED_QUEUE = "btg-pactual-order-created";
}
