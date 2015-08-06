package com.yihg.rabbitmq.consumer;

import java.util.Map;

import com.yihg.rabbitmq.model.RabbitMessage;

/**
 * 消费者
 * 此处充分解耦 普通的java类来处理业务  
 * 因为messageListener指定监听器配置成了： 消息侦听器适配器 messageListenerAdapter
 * 然后XML中指定了  处理类(RmqConsumer)   
 * <property name="defaultListenerMethod" value="rmqProducerMessage"></property>    
 * <property name="messageConverter" ref="serializerMessageConverter"></property> 
 */
public class RmqConsumer  {
	
	public void rmqProducerMessage(Object object){
		
		RabbitMessage rabbitMessage=(RabbitMessage) object;
		Map<String, Object> map = rabbitMessage.getParams();
		System.out.println("接受到Message："+map.get("user").toString()+"---data:"+map.get("data").toString());	
		
	}
		
}