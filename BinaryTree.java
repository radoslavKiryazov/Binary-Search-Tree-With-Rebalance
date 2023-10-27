import java.sql.Array;
import java.util.ArrayList;
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

    public ArrayList<T> inOrder(){
        ArrayList<T> result = new ArrayList<>();
        if(isEmpty()) return result;

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        var current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.getLeftChild();
            }
            current = stack.pop();
            result.add(current.getElement());
            current = current.getRightChild();
        }
        return result;
    }
    public ArrayList<T> preOrder(){
        ArrayList<T> result = new ArrayList<>();
        if(isEmpty()) return result;

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            var current = stack.pop();
            result.add(current.getElement());
            if(current.getRightChild() != null) stack.push(current.getRightChild());
            if(current.getLeftChild() != null) stack.push(current.getLeftChild());
        }
        return result;
    }
    public ArrayList<T> postOrder(){
        ArrayList<T> result = new ArrayList<>();
        if(isEmpty()) return result;

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        var current = root;

        while(current != null || !stack.isEmpty()){
            if(current!= null){
                stack.push(current);
                result.add(0, current.getElement());
                current = current.getRightChild();
        } else {
                current = stack.pop();
                current = current.getLeftChild();
            }
        }
        return result;
    }
    public ArrayList<T> levelOrder(){
        ArrayList<T> result = new ArrayList<>();
        if (isEmpty()) {
            return result;
        }

        Stack<BinaryTreeNode<T>> stack1 = new Stack<>();
        Stack<BinaryTreeNode<T>> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            var current = stack1.pop();
            result.add(current.getElement());

            if (current.getRightChild() != null) {
                stack2.push(current.getRightChild());
            }
            if (current.getLeftChild() != null) {
                stack2.push(current.getLeftChild());
            }

            if (stack1.isEmpty()) {
                Stack<BinaryTreeNode<T>> temp = stack1;
                stack1 = stack2;
                stack2 = temp;
            }
        }

        return result;
    }


}
