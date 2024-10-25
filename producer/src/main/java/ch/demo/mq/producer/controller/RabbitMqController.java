package ch.demo.mq.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  
  @GetMapping
  public String hello(){

    rabbitTemplate.convertAndSend("RoutingKey", "Hello");
    return "hello";
    
  }
  
}