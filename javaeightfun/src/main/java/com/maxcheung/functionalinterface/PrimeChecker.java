package com.maxcheung.functionalinterface;

import java.util.function.Predicate;

@FunctionalInterface
public interface PrimeChecker {
	 boolean isPrime(int number);
}
