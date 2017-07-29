package collectionsfun.collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionTest.class);

	@Test(expected = ArithmeticException.class)
	public void testUncheckedException() {
		LOGGER.info("testUncheckedException");
		int num1 = 10;
		int num2 = 0;
		/*
		 * Since I'm dividing an integer with 0 it should throw
		 * ArithmeticException
		 */
		int res = num1 / num2;
		System.out.println(res);
	}

	@Test
	public void testCheckedException() {
		LOGGER.info("testCheckedException");
		try {
			int arr[] = { 1, 2, 3, 4, 5 };
			System.out.println(arr[7]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The specified index does not exist " + "in array. Please correct the error.");
		}
	}

}
