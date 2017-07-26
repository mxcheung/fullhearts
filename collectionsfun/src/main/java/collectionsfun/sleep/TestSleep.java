package collectionsfun.sleep;

import java.util.Date;

public class TestSleep {

	public static void main(String[] args) {

		System.out.println("Testing..." + new Date());

		try {

			//sleep 5 seconds
			Thread.sleep(5000);

			System.out.println("Testing..." + new Date());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}