package ch.demo.mq.consumer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectExchangeConfiguration {

  public static final String DIRECT_EXCHANGE_NAME = "direct-exchange-name";

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(DIRECT_EXCHANGE_NAME);
  }

  @Bean
  public Binding directExchangeBinding1(DirectExchange directExchange, Queue autoDeleteQueue1) {
    return BindingBuilder.bind(autoDeleteQueue1).to(directExchange).with("group1");
  }

  @Bean
  public Binding directExchangeBinding2(DirectExchange directExchange, Queue autoDeleteQueue2) {
    return BindingBuilder.bind(autoDeleteQueue2).to(directExchange).with("group2");
  }

  @Bean
  public Binding directExchangeBinding3(DirectExchange directExchange, Queue autoDeleteQueue3) {
    return BindingBuilder.bind(autoDeleteQueue3).to(directExchange).with("group3");
  }

}