package test;
import main.BinaryTree;
import main.BinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    private BinaryTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
        // Create a sample binary tree for testing
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.addLeftChild(new BinaryTreeNode<>(2));
        root.addRightChild(new BinaryTreeNode<>(3));
        tree.setRoot(root);
    }

    @Test
    void testIsEmpty() {
        //assertEquals( 1, 0);
        assertFalse(tree.isEmpty());
        tree.setRoot(null);
        assertTrue(tree.isEmpty());
    }

    @Test
    void testSize() {
        //assertEquals( 1, 0);
        assertEquals(3, tree.size());
        tree.setRoot(null);
        assertEquals(0, tree.size());
    }

    @Test
    void testContains() {
        //assertEquals( 1, 0);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertFalse(tree.contains(4));
    }

    @Test
    void testInOrder() {
        //assertEquals( 1, 0);
        assertEquals("[2, 1, 3]", tree.inOrder().toString());
    }

    @Test
    void testPreOrder() {
        //assertEquals( 1, 0);
        assertEquals("[1, 2, 3]", tree.preOrder().toString());
    }

    @Test
    void testPostOrder() {
        //assertEquals( 1, 0);
        assertEquals("[2, 3, 1]", tree.postOrder().toString());
    }

    @Test
    void testLevelOrder() {
        //assertEquals( 1, 0);
        assertEquals("[1, 2, 3]", tree.levelOrder().toString());
    }
}