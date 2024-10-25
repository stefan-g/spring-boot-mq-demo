package ch.demo.mq.consumer.configuration;

import ch.demo.mq.consumer.RabbitMqMessageConsumer;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfiguration {

  private final AmqpAdmin rabbitAdmin;

  public RabbitMqConfiguration(AmqpAdmin rabbitAdmin) {
    this.rabbitAdmin = rabbitAdmin;
  }


  public static final String QUEUE_NAME = "my-queue-name";


  @Bean
  public Queue autoDeleteQueue1() {
    return new AnonymousQueue();
  }

  @Bean
  public Queue autoDeleteQueue2() {
    return new AnonymousQueue();
  }
  
  @Bean
  public Queue autoDeleteQueue3() {
    return new AnonymousQueue();
  }

  

//  @Bean
//  public Exchange myExchange() {
//    return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE_NAME).durable(true).build();
//  }

  @Bean
  public Queue queue(){
    return new Queue(QUEUE_NAME, true);
  }

  @Bean
  public RabbitMqMessageConsumer receiver1(){
    return new RabbitMqMessageConsumer(1);
  }


  @Bean
  public RabbitMqMessageConsumer receiver2(){
    return new RabbitMqMessageConsumer(2);
  }
  
//  @Bean
//  Binding binding(Queue queue) {
//    return BindingBuilder.bind(queue).to(new TopicExchange(TOPIC_EXCHANGE_NAME)).with("foo.bar.#");
//  }
  
//
//
//  public void declareQueue() {
//    String name = "my-queue";
//    String routingKey = "my-key";
//    boolean durable = true;
//    boolean exclusive = false;
//    boolean autoDelete = false;
//
//
//    String queueName = rabbitAdmin.declareQueue(new Queue(name, durable));
//
//    String exchangeName = "my-exchange";
//    DirectExchange exchange = new DirectExchange(exchangeName, durable, autoDelete);
//    rabbitAdmin.declareExchange(exchange);
//
//    Binding.DestinationType destinationType = Binding.DestinationType.QUEUE;
//    Map<String, Object> arguments = null;
//    Binding binding = new Binding(queueName, destinationType, exchangeName, routingKey, arguments);
//    rabbitAdmin.declareBinding(binding);
//  }

}