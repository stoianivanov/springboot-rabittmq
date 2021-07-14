package com.example.rabbitmq;

import java.util.UUID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestRest {
  @Autowired
  private MqttPushClient mqttPushClient;

  @GetMapping("/test")
  public ResponseEntity test() {
    System.out.println("Sending message...");
    mqttPushClient.publish(0, false, "test", "test test test  " + UUID.randomUUID());
//    mqttPushClient.publish(0, false, "test-queue", "test test test  " + UUID.randomUUID());
    return new ResponseEntity("test", HttpStatus.OK);
  }
}
