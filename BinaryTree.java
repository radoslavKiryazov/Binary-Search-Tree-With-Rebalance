import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree<T> {
    BinaryTreeNode<T> root;

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root){
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size() {
        if (isEmpty()) return 0;

        int counter = 0;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            var node = stack.pop();
            counter++;
            if(node.getLeftChild() != null) stack.push(node.getLeftChild());
            if (node.getRightChild() != null) stack.push(node.getRightChild());
        }
        return counter;
    }
    public boolean contains(T element){
        if (isEmpty()) return false;

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            var current = stack.pop();
            if(current.getElement().equals(element)) return true;
            if(current.getLeftChild() != null) stack.push(current.getLeftChild());
            if(current.getRightChild() != null) stack.push(current.getRightChild());
        }
        return false;
    }

    



}
