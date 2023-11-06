package com.always.demo.rabbitmq.publisher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() {
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello, spring amqp!";
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    public void testSendTopicQueue() {
        // 交换机名称
        String exchangeName = "JKCGY.TEST";
        // obd消息
        String obdMessage = "OBD已插入";
        // 发送obd消息
        rabbitTemplate.convertAndSend(exchangeName, "car.device.obd", obdMessage);
        // adas消息
        String adasMessage = "ADAS已插入";
        // 发送obd消息
        rabbitTemplate.convertAndSend(exchangeName, "car.device.adas", adasMessage);
    }
}
