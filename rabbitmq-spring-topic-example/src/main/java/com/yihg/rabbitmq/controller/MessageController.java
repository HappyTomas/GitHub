package com.yihg.rabbitmq.controller;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yihg.rabbitmq.model.RabbitMessage;
import com.yihg.rabbitmq.model.User;
import com.yihg.rabbitmq.producer.RmqProducer;
 
@Controller
public class MessageController {
      
    @Autowired
    private RmqProducer rmqProducer;
    
    @RequestMapping("/producer")
    public String producer() throws Exception {
    	System.out.println("producer");
        for(int i=0;i<100;i++){
        	User u=new User();
        	u.setId(i);
        	u.setName("name"+i);
        	List<String> likes = Arrays.asList("a", "b");
        	u.setLikes(likes);
        	Map<String, Object> map=new HashMap<String, Object>();
        	map.put("user", u);
        	String exchange="exchange_demo";////交换器  
            String routeKey="exchange_demo_key";//队列  
        	//参数  
            Map<String,Object> param=new HashMap<String, Object>();  
            param.put("data","hello"+i);  
            param.put("user", u);
            RabbitMessage  msg=new RabbitMessage(exchange,routeKey, param); 
            rmqProducer.sendTopicMessage(msg);
            		
            //rmqProducer.sendMessage(exchange,routeKey, param);   
        }
        return "index";
    }
 
    @RequestMapping("/index")
    public String index() throws Exception {
    	
        return "index";
    }
 
}