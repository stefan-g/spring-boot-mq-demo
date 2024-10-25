package ch.demo.mq.consumer.configuration;

import ch.demo.mq.consumer.RabbitMqRpcMessageConsumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqRpcDirectExchangeConfiguration {


  public static final String RPC_QUEUE_NAME = "rpc-queue-name";
  public static final String DIRECT_EXCHANGE_NAME = "rpc-direct-exchange-name";

  @Bean
  public Queue rpcQueue(){
    return new Queue(RPC_QUEUE_NAME);
  }
  
  @Bean
  public DirectExchange rpcDirectExchange() {
    return new DirectExchange(DIRECT_EXCHANGE_NAME);
  }
  
  @Bean
  public Binding rpcDirectExchangeBinding(DirectExchange rpcDirectExchange, Queue rpcQueue) {
    return BindingBuilder.bind(rpcQueue).to(rpcDirectExchange).with("rpc");
  }
  
  @Bean
  public RabbitMqRpcMessageConsumer rabbitMqRPCMessageConsumer(){
    return new RabbitMqRpcMessageConsumer();
  }
  
  
}