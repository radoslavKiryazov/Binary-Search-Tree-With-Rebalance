package test;

import main.BinarySearchTree;
import main.BinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
        // Create a sample binary search tree for testing
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
    }
    @Test
    void testInsertSuccess() {
        //assertEquals(1, 0);
        assertTrue(tree.insert(6));
    }

    @Test
    void testInsertExists() {
        //assertEquals(1, 0);
        assertFalse(tree.insert(5));
    }
    @Test
    void testRemoveElementSuccess() {
        //assertEquals(1, 0);
        assertTrue(tree.removeElement(4));
    }
    @Test
    void testRemoveElementFail() {
        //assertEquals(1, 0);
        assertFalse(tree.removeElement(1));
    }

    @Test
    void testFindMin() {
        //assertEquals(1, 0);
        assertEquals(2, tree.findMin().intValue());
    }

    @Test
    void testFindMax() {
        //assertEquals(1, 0);
        assertEquals(7, tree.findMax().intValue());
    }

    @Test
    void testContainsContains() {
        //assertEquals(1, 0);
        assertTrue(tree.contains(3));
    }
    @Test
    void testContainsDoesNotContain() {
        //assertEquals(1, 0);
        assertFalse(tree.contains(8));
    }

    @Test
    void testRebalance() {
        tree.rebalance();
        //assertEquals(1, 0);
        assertTrue(isBalanced(tree.getRoot()));
    }



















    // Helper methods
    private boolean isBalanced(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.getLeftChild());
        int rightHeight = getHeight(node.getRightChild());
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.getLeftChild()) && isBalanced(node.getRightChild());
    }
    private int getHeight(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeftChild());
        int rightHeight = getHeight(node.getRightChild());
        return Math.max(leftHeight, rightHeight) + 1;
    }
}