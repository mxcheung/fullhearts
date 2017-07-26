package com.maxcheung.functionalinterface;

import java.util.stream.IntStream;

public class PrimeCheckerImpl implements PrimeChecker {

	public boolean isPrime(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}

//	@Override
//	public boolean isPrime(int number) {
//		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
//	}

}
