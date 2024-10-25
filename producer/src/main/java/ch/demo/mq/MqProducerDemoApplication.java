package ch.demo.mq;

import java.util.stream.IntStream;

import ch.demo.mq.producer.configuration.RabbitMqConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class MqProducerDemoApplication implements CommandLineRunner {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public static final String FANOUT_EXCHANGE_NAME = "fanout-exchange-name";
  public static final String DIRECT_EXCHANGE_NAME = "direct-exchange-name";
  public static final String TOPIC_EXCHANGE_NAME = "topic-exchange-name";

  public static final String RPC_DIRECT_EXCHANGE_NAME = "rpc-direct-exchange-name";
  
  private static final String[] GROUPS = {"group1","group2","group3"};
  
  public static void main(String[] args) {
    SpringApplication.run(MqProducerDemoApplication.class, args);
  }

  @Override
  public void run(final String... args) {
    IntStream.range(0, 5).forEach(value -> rabbitTemplate.convertAndSend(RabbitMqConfiguration.QUEUE_NAME, "Hello" + ".".repeat(value)));
    IntStream.range(0, 5).forEach(value -> rabbitTemplate.convertAndSend(FANOUT_EXCHANGE_NAME, "","Fanout exchange message" + ".".repeat(value)));
    IntStream.range(0, 10).forEach(value -> rabbitTemplate.convertAndSend(DIRECT_EXCHANGE_NAME, GROUPS[value % 2],"Direct exchange message " + GROUPS[value % 2]));


    rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME,"nyse.stock.usd","apple inc 145.00$");
    rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME,"nyse.bill.usd", "T-bill 3 month 100.00$");
    rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME,"swx.stock.chf", "abb n 43.00 chf");
    rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME,"swx.stock.chf", "ubs n 26.50 chf");

    log.info("RPC result: {}" , rabbitTemplate.convertSendAndReceive(RPC_DIRECT_EXCHANGE_NAME,"rpc",15));
  }
}
