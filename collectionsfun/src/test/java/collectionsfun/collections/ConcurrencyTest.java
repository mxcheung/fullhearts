package collectionsfun.collections;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrencyTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrencyTest.class);

	@Test(expected = ConcurrentModificationException.class)
	public void testConcurrency() {
		LOGGER.info("testConcurrency");
		Vector<String> v = new Vector<String>();
		v.add("Amit");
		v.add("Raj");
		v.add("Pathak");
		v.add("Sumit");
		v.add("Aron");
		v.add("Trek");

		Enumeration<String> en = Collections.enumeration(v);// v.elements();

		while (en.hasMoreElements()) {
			String value = (String) en.nextElement();
			System.out.println(value);
			v.remove(value);
		}

		System.out.println("************************************");

	}

	@Test
	public void testConcurrency2() {
		LOGGER.info("testConcurrency");
		Vector<String> v = new Vector<String>();
		v.add("Amit");
		v.add("Raj");
		v.add("Pathak");
		v.add("Sumit");
		v.add("Aron");
		v.add("Trek");


		System.out.println("************************************");

		Iterator<String> iter = v.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
			System.out.println(v.size());
		}
	}
	
	
	
	@Test
	public void testEnumeration() {
		LOGGER.info("testEnumeration");
		Vector<String> v = new Vector<String>();
		v.add("Amit");
		v.add("Raj");
		v.add("Pathak");
		v.add("Sumit");
		v.add("Aron");
		v.add("Trek");
		Enumeration<String> en = v.elements();

		while (en.hasMoreElements()) {
			String value = (String) en.nextElement();
			System.out.println(value);
			v.remove(value);

		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testIteratorAgain() {
		LOGGER.info("testIterator");
		Vector<String> v = new Vector<String>();
		v.add("Amit");
		v.add("Raj");
		v.add("Pathak");
		v.add("Sumit");
		v.add("Aron");
		v.add("Trek");

		Iterator<String> it = v.iterator();
		while (it.hasNext()) {
			String value = (String) it.next();
			System.out.println(value);
			v.remove(value);
		}
	}

}
