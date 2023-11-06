package com.always.demo.rabbitmq.consummer.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class JkcgyCarDeviceListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "OBD"),
            exchange = @Exchange(name = "JKCGY.TEST", type = ExchangeTypes.TOPIC),
            key = "#.obd"
    ))
    public void listenObdMessage(String msg) throws InterruptedException {
        System.out.println("消费者接收到obd消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "ADAS"),
            exchange = @Exchange(name = "JKCGY.TEST", type = ExchangeTypes.TOPIC),
            key = "#.adas"
    ))
    public void listenAdasMessage(String msg) throws InterruptedException {
        System.out.println("消费者接收到adas消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "LOCATION"),
            exchange = @Exchange(name = "JKCGY.TEST", type = ExchangeTypes.TOPIC),
            key = "car.device.#"
    ))
    public void listenLocationMessage(String msg) throws InterruptedException {
        System.out.println("消费者接收到location消息：【" + msg + "】");
    }
}
