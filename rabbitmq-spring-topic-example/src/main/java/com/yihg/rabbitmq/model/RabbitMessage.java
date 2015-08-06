package com.yihg.rabbitmq.model;
import java.io.Serializable;
import java.util.Map;

 /**
  *  消息
  */
public class RabbitMessage implements Serializable
{
	private static final long serialVersionUID = -6487839157908352120L;
	
	private String exchange;//交换器
	
	private String routeKey;//路由key 	
	
	private Map<String, Object> params;
	
	public RabbitMessage(){}

	public RabbitMessage(String exchange,String routeKey,Map<String, Object> params)
	{
		this.params=params;		
		this.exchange=exchange;
		this.routeKey=routeKey;
	}
	
	public String getRouteKey() {
		return routeKey;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public void setRouteKey(String routeKey) {
		this.routeKey = routeKey;
	}	
	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
}