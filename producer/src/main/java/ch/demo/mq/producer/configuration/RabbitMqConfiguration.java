package ch.demo.mq.producer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfiguration {

//  static final String TOPIC_EXCHANGE_NAME = "my-topic";

  public static final String QUEUE_NAME = "my-queue-name";


//  private final AmqpAdmin rabbitAdmin;

//  public RabbitMqConfiguration(AmqpAdmin rabbitAdmin) {
//    this.rabbitAdmin = rabbitAdmin;
//  }

//  @Bean
//  public Exchange myExchange() {
//    return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE_NAME).durable(true).build();
//  }
  
  @Bean
  public Queue queue(){
    return new Queue(QUEUE_NAME, true);
  }
  
//  @Bean
//  Binding binding(Queue queue) {
//    return BindingBuilder.bind(queue).to(new TopicExchange(TOPIC_EXCHANGE_NAME)).with("foo.bar.#");
//  }
//  
  
//  public void declareQueue() {
//    String routingKey = "my-key";
//    boolean durable = true;
//    boolean exclusive = false;
//    boolean autoDelete = false;
//
//
//    String queueName = rabbitAdmin.declareQueue(new Queue(QUEUE_NAME, durable, exclusive, autoDelete));
//
//    DirectExchange exchange = new DirectExchange(TOPIC_EXCHANGE_NAME, durable, autoDelete);
//    rabbitAdmin.declareExchange(exchange);
//
//    Binding.DestinationType destinationType = Binding.DestinationType.QUEUE;
//    Map<String, Object> arguments = null;
//    Binding binding = new Binding(queueName, destinationType, TOPIC_EXCHANGE_NAME, routingKey,
//                                  arguments);
//    rabbitAdmin.declareBinding(binding);
//  }
  
}