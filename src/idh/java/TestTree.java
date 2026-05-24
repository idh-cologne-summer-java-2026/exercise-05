package idh.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTree {
	Tree<String> tree;

	@BeforeEach
	public void setUp() {
		tree = new Tree<String>();
		tree.setValue("A");
		tree.addChild("B1");
		tree.addChild("B2");
		tree.getChildren().get(0).addChild("C1");
		tree.getChildren().get(0).addChild("C2");
		tree.getChildren().get(0).addChild("C3");
		tree.getChildren().get(1).addChild("C4");
		tree.getChildren().get(1).addChild("C5");
		tree.getChildren().get(1).getChildren().get(0).addChild("D1");
	}

	@Test
	public void testSize() {
		Tree<String> someTree = new Tree<String>();
		System.out.println("someTree.size0 = "+someTree.size());
		assertEquals(0, someTree.size());

		someTree.addChild("A");
		System.out.println("someTree.size1 = "+someTree.size());
		assertEquals(1, someTree.size());

		System.out.println("tree.size = "+tree.size());
		assertEquals(9, tree.size());
		System.out.println("==================================");
	}
	
	@Test
	public void testContains() {
		Tree<String> someTree = new Tree<String>();
		
		System.out.println("someTree0 contains A = "+someTree.contains("A"));
		assertFalse(someTree.contains("A"));
		someTree.addChild("A");
		System.out.println("someTree1 contains A = "+someTree.contains("A"));
		assertTrue(someTree.contains("A"));

		System.out.println("Tree contains A = "+tree.contains("A"));
		System.out.println("Tree contains B1 = "+tree.contains("B1"));
		System.out.println("Tree contains B3 = "+tree.contains("B3"));		
		System.out.println("Tree contains D1 = "+tree.contains("D1"));
		System.out.println("Tree contains D2 = "+tree.contains("D2"));
		assertTrue(tree.contains("A"));
		assertTrue(tree.contains("B1"));
		assertFalse(tree.contains("B3"));
		assertTrue(tree.contains("D1"));
		assertFalse(tree.contains("D2"));
	}

}
