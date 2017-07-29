package collectionsfun.collections;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListIteratorTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ListIteratorTest.class);

	@Test
	public void testMyListIterator() {
		LOGGER.info("MyListIterator");
		List<Integer> li = new ArrayList<Integer>();
		ListIterator<Integer> litr = null;
		li.add(23);
		li.add(98);
		li.add(29);
		li.add(71);
		li.add(5);
		litr = li.listIterator();
		System.out.println("Elements in forward directiton");
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}
		System.out.println("Elements in backward directiton");
		while (litr.hasPrevious()) {
			System.out.println(litr.previous());
		}
	}

	@Test
	public void testIterator() {
		LOGGER.info("testIterator");
		ArrayList names = new ArrayList();
		names.add("Chaitanya");
		names.add("Steve");
		names.add("Jack");

		Iterator it = names.iterator();

		while (it.hasNext()) {
			String obj = (String) it.next();
			System.out.println(obj);
		}

		ListIterator litr = names.listIterator();

		System.out.println("Elements in forward directiton");
		while (it.hasNext()) {
			String obj = (String) it.next();
			System.out.println(obj);
		}

		while (litr.hasNext()) {
			System.out.println(litr.next());
		}
		System.out.println("Elements in backward directiton");
		while (litr.hasPrevious()) {
			System.out.println(litr.previous());
		}
	}

	@Test
	public void testMyVector() {
		LOGGER.info("testMyVector");
		Vector v = new Vector(3, 2);
		System.out.println("Initial size: " + v.size());
		System.out.println("Initial capacity: " + v.capacity());
		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		System.out.println("Capacity after four additions: " + v.capacity());
		v.addElement(new Double(5.45));
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(new Double(6.08));
		v.addElement(new Integer(7));
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(new Float(9.4));
		v.addElement(new Integer(10));
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(new Integer(11));
		v.addElement(new Integer(12));
		System.out.println("First element: " + (Integer) v.firstElement());
		System.out.println("Last element: " + (Integer) v.lastElement());
		if (v.contains(new Integer(3)))
			System.out.println("Vector contains 3.");
		// enumerate the elements in the vector.
		Enumeration vEnum = v.elements();
		System.out.println("\\nElements in vector:");
		while (vEnum.hasMoreElements())
			System.out.print(vEnum.nextElement() + " ");
		System.out.println();
	}

	

}
