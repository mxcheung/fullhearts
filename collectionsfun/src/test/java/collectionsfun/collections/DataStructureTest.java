package collectionsfun.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataStructureTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataStructureTest.class);

	@Test
	public void testUniqueness() {
		LOGGER.info("checking set");
		Set<Integer> numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(1);
		assertEquals(2, numbers.size());
	}

	
	@Test
	public void testArray() {
		LOGGER.info("checking set");
		int a[]=new int[5];//declaration and instantiation.
		a[0]=10;//initialization.
		a[1]=20;
		a[2]=70;
		a[3]=40;
		a[4]=50;
		assertEquals(5, a.length);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class) 
	public void testArrayOutOfBounds() {
		LOGGER.info("checking set");
		int a[]=new int[5];//declaration and instantiation.
		a[0]=10;//initialization.
		a[1]=20;
		a[2]=70;
		a[3]=40;
		a[4]=50;
		a[5]=50;
		assertEquals(5, a.length);
	}

	@Test 
	public void testArrayResize() {
		LOGGER.info("checking set");
		int[] a = {1, 2, 3};
	    // make a one bigger
	    a = Arrays.copyOf(a, a.length + 1);
	    for (int i : a)
	        System.out.println(i);
		assertEquals(4, a.length);
	}

	@Test 
	public void testRemoveArray() {
		LOGGER.info("checking set");
		int[] a = {1, 2, 3};
	    a = removeElement(a, 2);
		assertEquals(2, a.length);
	}
	
	public static int[] removeElement(int[] original, int element){
	    int[] n = new int[original.length - 1];
	    System.arraycopy(original, 0, n, 0, element );
	    System.arraycopy(original, element+1, n, element, original.length - element-1);
	    return n;
	}
	
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

	@Test 
	public void testArrayList() {
		LOGGER.info("linked list");
		ArrayList<String> obj = new ArrayList<String>();
		  /*This is how elements should be added to the array list*/
		  obj.add("Ajeet");
		  obj.add("Harry");
		  obj.add("Chaitanya");
		  obj.add("Steve");
		  obj.add("Anuj");
		  assertEquals(5, obj.size());
		  assertEquals(1, obj.indexOf("Harry"));


	}

}
