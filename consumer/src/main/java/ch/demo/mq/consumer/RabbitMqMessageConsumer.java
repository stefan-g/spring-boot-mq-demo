package ch.demo.mq.consumer;

import ch.demo.mq.consumer.configuration.RabbitMqConfiguration;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Log4j2
public class RabbitMqMessageConsumer {

  private final int instance;

  public RabbitMqMessageConsumer(final int instance) {
    this.instance = instance;
  }

  @RabbitListener(queues = RabbitMqConfiguration.QUEUE_NAME)
  public void handleMessage(String message) throws InterruptedException {
    Thread.sleep(StringUtils.countMatches(message, '.'));
    log.info("Consumer {}: {}",instance, message);
  }
}