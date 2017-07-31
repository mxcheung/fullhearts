package collectionsfun.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedHashMapTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedHashMapTest.class);

	@Test
	public void testLinkedHashmap() {
		LOGGER.info("testLinkedHashmap");

		// Map representing (Company, share price) as (key, value) pair
		Map<String, Double> linkedHashMap = new LinkedHashMap<String, Double>();
		linkedHashMap.put("Apple", new Double(91.98));
		linkedHashMap.put("Sony", new Double(16.76));
		linkedHashMap.put("Dell", new Double(30.47));
		linkedHashMap.put("HP", new Double(33.91));
		linkedHashMap.put("IBM", new Double(181.71));

		// Displaying the contents of the LinkedHashMap
		System.out.println("Contents of LinkedHashMap : " + linkedHashMap);

		// One of the ways of iterating over the map
		// Notice the order of the elements is same as the order of insertion
		System.out.println("\nValues of map after iterating over it : ");
		for (String key : linkedHashMap.keySet()) {
			System.out.println(key + ":\t" + linkedHashMap.get(key));
		}

		// Getting the value for a particular key
		System.out.println("\nThe current share price of HP is : " + linkedHashMap.get("HP"));

		// Getting the size of the LinkedHashMap
		System.out.println("\nThe size of the LinkedHashMap is : " + linkedHashMap.size());

		// Checking whether the LinkedHashMap is empty
		System.out.println("\nIs LinkedHashMap empty? : " + linkedHashMap.isEmpty());

		// Checking whether Map contains a particular key or value
		System.out.println("\nLinkedHashMap contains Sony as key? : " + linkedHashMap.containsKey("Sony"));
		System.out.println("LinkedHashMap contains 999.0 as value? : " + linkedHashMap.containsValue(999.0));

		// Removing a particular value
		System.out.println("\nRemove entry for Dell : " + linkedHashMap.remove("Dell"));
		System.out.println("Content of LinkedHashMap removing Dell: " + linkedHashMap);

		// Clearing the LinkedHashMap
		linkedHashMap.clear();
		System.out.println("\nContent of LinkedHashMap after clearing: " + linkedHashMap);
	}

	@Test
	public void testHashmap() {
		LOGGER.info("testHashmap");

		// Map representing (Company, share price) as (key, value) pair
		Map<String, Double> hashMap = new HashMap<String, Double>();
		hashMap.put("Apple", new Double(91.98));
		hashMap.put("Sony", new Double(16.76));
		hashMap.put("Dell", new Double(30.47));
		hashMap.put("HP", new Double(33.91));
		hashMap.put("IBM", new Double(181.71));

		// Displaying the contents of the HashMap
		System.out.println("Contents of HashMap : " + hashMap);

		// One of the ways of iterating over the map
		// Notice the order of the elements is same as the order of insertion
		System.out.println("\nValues of map after iterating over it : ");
		for (String key : hashMap.keySet()) {
			System.out.println(key + ":\t" + hashMap.get(key));
		}

		// Getting the value for a particular key
		System.out.println("\nThe current share price of HP is : " + hashMap.get("HP"));

		// Getting the size of the LinkedHashMap
		System.out.println("\nThe size of the HashMap is : " + hashMap.size());

		// Checking whether the LinkedHashMap is empty
		System.out.println("\nIs HashMap empty? : " + hashMap.isEmpty());

		// Checking whether Map contains a particular key or value
		System.out.println("\nHashMap contains Sony as key? : " + hashMap.containsKey("Sony"));
		System.out.println("HashMap contains 999.0 as value? : " + hashMap.containsValue(999.0));

		// Removing a particular value
		System.out.println("\nRemove entry for Dell : " + hashMap.remove("Dell"));
		System.out.println("Content of HashMap removing Dell: " + hashMap);

		// Clearing the LinkedHashMap
		hashMap.clear();
		System.out.println("\nContent of HashMap after clearing: " + hashMap);
	}

	@Test
	public void testTreeMap() {
		LOGGER.info("testTreeMap");

		// Map representing (Company, share price) as (key, value) pair
		Map<String, Double> TreeMap = new TreeMap<String, Double>();
		TreeMap.put("Apple", new Double(91.98));
		TreeMap.put("Sony", new Double(16.76));
		TreeMap.put("Dell", new Double(30.47));
		TreeMap.put("HP", new Double(33.91));
		TreeMap.put("IBM", new Double(181.71));

		// Displaying the contents of the TreeMap
		System.out.println("Contents of TreeMap : " + TreeMap);

		// One of the ways of iterating over the map
		// Notice the order of the elements is same as the order of insertion
		System.out.println("\nValues of map after iterating over it : ");
		for (String key : TreeMap.keySet()) {
			System.out.println(key + ":\t" + TreeMap.get(key));
		}

		// Getting the value for a particular key
		System.out.println("\nThe current share price of HP is : " + TreeMap.get("HP"));

		// Getting the size of the LinkedTreeMap
		System.out.println("\nThe size of the TreeMap is : " + TreeMap.size());

		// Checking whether the LinkedTreeMap is empty
		System.out.println("\nIs TreeMap empty? : " + TreeMap.isEmpty());

		// Checking whether Map contains a particular key or value
		System.out.println("\nTreeMap contains Sony as key? : " + TreeMap.containsKey("Sony"));
		System.out.println("TreeMap contains 999.0 as value? : " + TreeMap.containsValue(999.0));

		// Removing a particular value
		System.out.println("\nRemove entry for Dell : " + TreeMap.remove("Dell"));
		System.out.println("Content of TreeMap removing Dell: " + TreeMap);

		// Clearing the LinkedTreeMap
		TreeMap.clear();
		System.out.println("\nContent of TreeMap after clearing: " + TreeMap);
	}

}
