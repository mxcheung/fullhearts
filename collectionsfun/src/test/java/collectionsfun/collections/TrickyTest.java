package collectionsfun.collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrickyTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrickyTest.class);

	@Test
	public void testMinValue() {
		LOGGER.info("testMinValue");
		  System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		  System.out.println(Double.MIN_VALUE);

	}

}
