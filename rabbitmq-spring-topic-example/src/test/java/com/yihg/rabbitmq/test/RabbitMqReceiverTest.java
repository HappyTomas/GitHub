package  com.yihg.rabbitmq.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yihg.rabbitmq.model.User;
import com.yihg.rabbitmq.producer.RmqProducer;

public class RabbitMqReceiverTest {
	
	public static final ClassPathXmlApplicationContext context ;
	static{
	    context = new ClassPathXmlApplicationContext(new String[] {"spring-rabbitmq-receiver.xml"});
	}
	public static ClassPathXmlApplicationContext getContext() {
		return context;
	}
	
	
    @org.junit.Before
	public void setUp() throws Exception {
		getContext();
		context.start();
	}
	@Test
	public void testSenderMessage(){
            System.out.println("---");
            
	}
}