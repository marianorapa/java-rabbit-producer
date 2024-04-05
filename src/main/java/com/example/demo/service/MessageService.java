package com.example.demo.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class MessageService {
    private final static String EXCHANGE_NAME = "logs-direct";

    @Value("${spring.rabbitmq.host}")
    private String rabbitHost;

    public void sendMessage(String content, String severity) {
        ConnectionFactory factory = getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            channel.basicPublish(EXCHANGE_NAME, severity, null, content.getBytes());
            System.out.println(" [x] Sent '" + content + "'");

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitHost);
        return factory;
    }

}
