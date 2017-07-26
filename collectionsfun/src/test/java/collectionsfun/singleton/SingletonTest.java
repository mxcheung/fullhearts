package collectionsfun.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonTest {

	private ClassicSingleton sone = null, stwo = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(SingletonTest.class);

	@Before
	public void setUp() {
		LOGGER.info("getting singleton...");
		sone = ClassicSingleton.getInstance();
		LOGGER.info("...got singleton: " + sone);
		LOGGER.info("getting singleton...");
		stwo = ClassicSingleton.getInstance();
		LOGGER.info("...got singleton: " + stwo);
	}

	@Test
	   public void testUnique() {
		LOGGER.info("checking singletons for equality");
	      Assert.assertEquals(true, sone == stwo);
	   }

}
