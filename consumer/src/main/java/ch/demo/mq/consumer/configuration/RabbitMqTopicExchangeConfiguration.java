package ch.demo.mq.consumer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicExchangeConfiguration {


  public static final String TOPIC_EXCHANGE_NAME = "topic-exchange-name";

  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(TOPIC_EXCHANGE_NAME);
  }
  
  @Bean
  public Binding topicExchangeBinding1(TopicExchange exchange, Queue autoDeleteQueue1) {
    return BindingBuilder.bind(autoDeleteQueue1).to(exchange).with("*.*.usd");
  }

  @Bean
  public Binding topicExchangeBinding2(TopicExchange exchange, Queue autoDeleteQueue2) {
    return BindingBuilder.bind(autoDeleteQueue2).to(exchange).with("nyse.#");
  }
  
  @Bean
  public Binding topicExchangeBinding3(TopicExchange exchange, Queue autoDeleteQueue3) {
    return BindingBuilder.bind(autoDeleteQueue3).to(exchange).with("*.stock.*");
  }

}