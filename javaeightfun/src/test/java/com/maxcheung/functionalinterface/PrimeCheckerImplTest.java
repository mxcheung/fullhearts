package com.maxcheung.functionalinterface;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrimeCheckerImplTest {

	private PrimeChecker primeChecker = new PrimeCheckerImpl();

	@Test
	public void shouldValidatePrime() {
		assertTrue(primeChecker.isPrime(2));
		assertTrue(primeChecker.isPrime(7));
		assertFalse(primeChecker.isPrime(8));
	}

}
