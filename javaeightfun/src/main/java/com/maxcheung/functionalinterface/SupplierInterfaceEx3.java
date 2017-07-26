package com.maxcheung.functionalinterface;

import java.util.function.Supplier;

import com.maxcheung.model.User;

public class SupplierInterfaceEx3 {
	public static void main(String[] args) {
		
		Supplier<User> userSupplier1  = () -> createUser(88, "Jenny");
		printUser(userSupplier1);
	}
	
	public static void printUser(Supplier<User> userSupplier) {
		System.out.println(userSupplier.get());
	}
	
	public static User createUser(int id, String name) {
		User user1 = new User(id,name);
		return user1;
	}
}