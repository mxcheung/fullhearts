package algorithmsfun.binarysearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
	
	 BinarySearch mbs = new BinarySearch();
	 
    @Test
    public void shouldReturnIndex() {
    	 int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        assertEquals(6, mbs.binarySearch(arr, 14));
        
        int[] arr1 = {6,34,78,123,432,900};
        assertEquals(4, mbs.binarySearch(arr1, 432));
        
    }

}
