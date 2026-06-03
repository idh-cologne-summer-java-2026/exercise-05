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
		tree = new Tree<String>("A");
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
		Tree<String> someTree = new Tree<String>("R");
		assertEquals(1, someTree.size());

		someTree.addChild("A");
		assertEquals(2, someTree.size());

		assertEquals(9, tree.size());
	}
	
	@Test
	public void testContains() {
		Tree<String> someTree = new Tree<String>("R");
		assertFalse(someTree.contains("A"));
		someTree.addChild("A");
		assertTrue(someTree.contains("A"));
		
		assertTrue(tree.contains("A"));
		assertTrue(tree.contains("B1"));
		assertFalse(tree.contains("B3"));
		assertTrue(tree.contains("D1"));
	}

}
