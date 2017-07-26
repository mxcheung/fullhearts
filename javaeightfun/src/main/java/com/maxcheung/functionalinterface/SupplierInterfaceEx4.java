package com.maxcheung.functionalinterface;

import java.util.function.Supplier;

import com.maxcheung.model.User;

public class SupplierInterfaceEx4 {
	public static void main(String[] args) {
		Supplier<User> name1 = new UserFetcher(88, "Jenny") ;
		printUser(name1);
	}
	
	public static void printUser(Supplier<User> userSupplier) {
		System.out.println(userSupplier.get());
	}
	
}