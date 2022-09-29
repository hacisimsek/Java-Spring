package com.springbootrabbitMQApplication.RabbitMQApplication.producer;

import com.springbootrabbitMQApplication.RabbitMQApplication.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${sr.rabbit.routing.key}")
    private String routingKey;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Hello World");
        notification.setSeen(false);

        sendToQueue(notification);
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification) {
        System.out.println("Sending notification Id: " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, notification);
    }

}
