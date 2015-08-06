package com.yihg.rabbitmq.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3082608448194312694L;
	
	
	private int id;
	
	private String  name;
	
	private List<String> likes;
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, List<String> likes) {
		super();
		this.id = id;
		this.name = name;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(List<String> likes) {
		this.likes = likes;
	}
	

}
