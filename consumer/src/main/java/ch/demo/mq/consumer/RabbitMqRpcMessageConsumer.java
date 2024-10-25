package ch.demo.mq.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Log4j2
public class RabbitMqRpcMessageConsumer {

  @RabbitListener(queues = "#{rpcQueue.name}")
  public int receive(int value)  {
    return value * 100;
  }
}