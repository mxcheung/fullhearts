package com.maxcheung.functionalinterface;

import java.util.function.Supplier;

import com.maxcheung.model.User;

public class UserFetcher implements Supplier {
	private int id;
	private String name;

	public UserFetcher(int id, String name) {
		this.id = id;
		this.name = name;
	}

	
	@Override
	public User get() {
		User user1 = new User(id, name);
		return user1;
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


	
	
	
	
}
