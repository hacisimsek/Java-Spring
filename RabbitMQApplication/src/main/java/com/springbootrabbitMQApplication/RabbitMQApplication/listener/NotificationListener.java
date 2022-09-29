package com.springbootrabbitMQApplication.RabbitMQApplication.listener;

import com.springbootrabbitMQApplication.RabbitMQApplication.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "${sr.rabbit.queue.name}")
    public void handleMessages(Notification notification){
        System.out.println("Message received.." );
        System.out.println("Notification received: " + notification.toString());
    }
}
