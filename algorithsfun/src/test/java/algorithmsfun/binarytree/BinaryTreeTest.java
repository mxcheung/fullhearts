package algorithmsfun.binarytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryTreeTest {
	
	BinaryTree theTree = new BinaryTree();
	 
    @Test
    public void shouldReturnItem() {

		theTree.addNode(50, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");

		theTree.addNode(85, "Salesman 1");
		
		assertEquals("Vice President", theTree.findNode(25).name);
		assertEquals("Sales Manager", theTree.findNode(75).name);

    }

}
