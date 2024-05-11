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
    private final static String EXCHANGE_NAME = "logs-topic";

    @Value("${spring.rabbitmq.host}")
    private String rabbitHost;

    @Value("${spring.rabbitmq.user}")
    private String rabbitUser;

    @Value("${spring.rabbitmq.password}")
    private String rabbitPassword;

    public void sendMessage(String content, String topic) {
        ConnectionFactory factory = getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            channel.basicPublish(EXCHANGE_NAME, topic, null, content.getBytes());
            System.out.println(" [x] Sent '" + content + "'");

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitHost);
        factory.setUsername(rabbitUser);
        factory.setPassword(rabbitPassword);
        return factory;
    }

}
