package com.yihg.rabbitmq.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yihg.rabbitmq.model.RabbitMessage;
/**
 * 生产者
 * rabbitmq会有默认的exchange，所以你不指定exchange，会使用默认的DirectExchange
 * 因为消息队列本身就是松耦合的，消息发布者不应该去关心queue name的
 */
@Service
public class RmqProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private RabbitAdmin rabbitAdmin;

	/**
	 * 发送信息 
	 * 默认Direct的模式 发送(路由的实现其实就是通过设置路由规则来实现)  
	 * 由生产者初始化exchange 可以达到 消费者不启动 也可以发送消息的效果 
	 * @param msg
	 */
	public void sendMessage(RabbitMessage msg) {
	   // 发送信息
	   Exchange exchange = new DirectExchange(msg.getExchange(),true,false);
	   rabbitAdmin.declareExchange(exchange);
	   rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(),msg);
	}
	/**
	 * 发送信息 
	 * Fanout的模式 发送(分发给全部消费者（广播）默认持久化和不自动删除)  
	 * 由生产者初始化exchange 可以达到 消费者不启动 也可以发送消息的效果 
	 * @param msg
	 */
	public void sendFanoutMessage(RabbitMessage msg) {
	   // 发送信息
	   Exchange exchange = new FanoutExchange(msg.getExchange(),true,false);
	   rabbitAdmin.declareExchange(exchange);
	   rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(),msg);
	}
	
	/**
	 * 发送信息 
	 * 以Topic的模式 发送(路由的实现  区别与DirectExchange RouteKey可以用通配符 *表示一个词 #表示0或多个词)  
	 * 由生产者初始化exchange 可以达到 消费者不启动 也可以发送消息的效果 
	 * @param msg
	 */
	public void sendTopicMessage(RabbitMessage msg) {
	   // 发送信息
	   Exchange exchange = new TopicExchange(msg.getExchange(),true,false);
	   rabbitAdmin.declareExchange(exchange);
	   rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(),msg);
	}
	

}