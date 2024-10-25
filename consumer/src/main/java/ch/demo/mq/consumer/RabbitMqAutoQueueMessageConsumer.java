package ch.demo.mq.consumer;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Log4j2
public class RabbitMqAutoQueueMessageConsumer {

  @RabbitListener(queues = "#{autoDeleteQueue1.name}")
  public void receive1(String in) throws InterruptedException {
    receive(in, 1);
  }

  @RabbitListener(queues = "#{autoDeleteQueue2.name}")
  public void receive2(String in) throws InterruptedException {
    receive(in, 2);
  }

  @RabbitListener(queues = "#{autoDeleteQueue3.name}")
  public void receive3(String in) throws InterruptedException {
    receive(in, 3);
  }

  public void receive(String message, int instance) throws InterruptedException {
    Thread.sleep(StringUtils.countMatches(message, '.'));
    log.info("Consumer {}: {}", instance, message);
  }
}