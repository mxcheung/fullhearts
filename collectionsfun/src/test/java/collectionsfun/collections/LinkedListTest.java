package collectionsfun.collections;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListTest.class);
	
	@Test 
	public void testLinkedList() {
		LOGGER.info("linked list");
		LinkedList<String> al=new LinkedList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");
		assertEquals("Ravi", al.get(2));
		assertEquals("Ajay", al.get(3));
		assertEquals(4, al.size());
	}


}
