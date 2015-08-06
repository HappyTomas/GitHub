package  com.yihg.rabbitmq.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yihg.rabbitmq.model.RabbitMessage;
import com.yihg.rabbitmq.model.User;
import com.yihg.rabbitmq.producer.RmqProducer;

public class RabbitMqSenderTest {
	
	public static final ClassPathXmlApplicationContext context ;
	static{
	    context = new ClassPathXmlApplicationContext(new String[] {"spring-rabbitmq-producer.xml"});
	}
	public static ClassPathXmlApplicationContext getContext() {
		return context;
	}
	
	RmqProducer rmqProducer;
	
    @org.junit.Before
	public void setUp() throws Exception {
		getContext();
		context.start();
		rmqProducer = (RmqProducer) context.getBean(RmqProducer.class);
	}
	@Test
	public void testSenderMessage(){

       for(int i=0;i<100;i++){
        	User u=new User();
        	u.setId(i);
        	u.setName("name"+i);
        	List<String> likes = Arrays.asList("a", "b");
        	u.setLikes(likes);
           String exchange="exchange_demo";////交换器  
           String routeKey="exchange_demo_key";//队列  
        	//参数  
           Map<String,Object> param=new HashMap<String, Object>();  
           param.put("data","hello"+i);  
           param.put("user", u);
           RabbitMessage  msg=new RabbitMessage(exchange,routeKey, param); 
           rmqProducer.sendMessage(msg);
        }
	    System.out.println("-------------send message-------");
	}
}