package com.maxcheung.functionalinterface;

//SupplierFunctionExample.java
import java.util.Date;
import java.util.function.Supplier;

import com.maxcheung.model.User;

public class SupplierFunctionExample {
	public static void main(String args[]) {
		// Supplier instance with lambda expression
		Supplier<String> helloStrSupplier = () -> new String("Hello");
		String helloStr = helloStrSupplier.get();
		System.out.println("String in helloStr is->" + helloStr + "<-");

		// Supplier instance using method reference to default constructor
		Supplier<String> emptyStrSupplier = String::new;
		String emptyStr = emptyStrSupplier.get();
		System.out.println("String in emptyStr is->" + emptyStr + "<-");

		// Supplier instance using method reference to a static method
		Supplier<Date> dateSupplier = SupplierFunctionExample::getSystemDate;
		Date systemDate = dateSupplier.get();
		System.out.println("systemDate->" + systemDate);

		Supplier<String> name1 = new Supplier<String>() {
			@Override
			public String get() {
				return "Hello";
			}
		};
		System.out.println(name1.get());

		Supplier<String> name2 = () -> new String("John");
		System.out.println(name2.get());

		Supplier<String> name3 = () -> "Jim";
		System.out.println(name3.get());

	}

	public static Date getSystemDate() {
		return new Date();
	}


	public static User createUser() {
		return new User(1, "Jenny");
	}

}