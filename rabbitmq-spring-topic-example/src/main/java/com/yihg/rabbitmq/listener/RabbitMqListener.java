package com.yihg.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

public class RabbitMqListener implements ChannelAwareMessageListener {
 
 
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String str = new String(message.getBody());
        // TODO 接受消息
        System.out.println(message.getMessageProperties().getMessageId());
        System.out.println("Recived msg:" + str);
      //  channel.
    }
}