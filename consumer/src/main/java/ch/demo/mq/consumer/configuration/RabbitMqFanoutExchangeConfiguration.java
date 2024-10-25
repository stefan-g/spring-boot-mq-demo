package ch.demo.mq.consumer.configuration;

import ch.demo.mq.consumer.RabbitMqAutoQueueMessageConsumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqFanoutExchangeConfiguration {


  public static final String FANOUT_EXCHANGE_NAME = "fanout-exchange-name";

  @Bean
  public FanoutExchange fanout() {
    return new FanoutExchange(FANOUT_EXCHANGE_NAME);
  }
  

  @Bean
  public Binding fanoutBinding1(FanoutExchange exchange, Queue autoDeleteQueue1) {
    return BindingBuilder.bind(autoDeleteQueue1).to(exchange);
  }

  @Bean
  public Binding fanoutBinding2(FanoutExchange exchange, Queue autoDeleteQueue2) {
    return BindingBuilder.bind(autoDeleteQueue2).to(exchange);
  }
  
  @Bean
  public RabbitMqAutoQueueMessageConsumer rabbitMqFanoutMessageConsumer(){
    return new RabbitMqAutoQueueMessageConsumer();
  }

}