package com.maxcheung.functionalinterface;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyFunctionalInterfaceImplTest {
	
	MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterfaceImpl();
	
	
    @Test
    public void shouldSayHello() {
        assertEquals("Hello", myFunctionalInterface.sayHello());
    }

}
