import java.util.ArrayList;

public class BinarySearchTreeADT<T extends Comparable<T>> extends BinaryTree<T> {


    private boolean insert(T element) {
        if (element == null) return false;
        var newNode = new BinaryTreeNode<>(element);

        if (getRoot() == null) {
            setRoot(newNode);
            return true;
        }

        BinaryTreeNode<T> currentRoot = getRoot();

        while (currentRoot != null) {
            int compare = element.compareTo(currentRoot.getElement());

            if (compare < 0) {
                if (currentRoot.getLeftChild() == null) {
                    currentRoot.addLeftChild(newNode);
                    return true;
                }
            } else if (compare > 0) {
                if (currentRoot.getRightChild() == null) {
                    currentRoot.addRightChild(newNode);
                    return true;
                }
                currentRoot = currentRoot.getRightChild();
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean removeElement(T element) {
        if (element == null || !contains(element)) {
            return false;
        }

        BinaryTreeNode<T> parent = null;
        var current = getRoot();

        while (current != null) {
            int compare = element.compareTo(current.getElement());

            if (compare == 0) {
                if (current.getLeftChild() == null && current.getRightChild() == null) {
                    if (parent == null) {
                        setRoot(null);
                    } else if (parent.getLeftChild() == current) {
                        parent.addLeftChild(null);
                    } else {
                        parent.addRightChild(null);
                    }
                } else if (current.getLeftChild() != null && current.getRightChild() != null) {
                    var minRight = findMin(current.getRightChild());
                    current.setElement(minRight.getElement());
                    current = minRight;
                } else {
                    var child = (current.getLeftChild() != null) ? current.getLeftChild() : current.getRightChild();
                    if (parent == null) {
                        setRoot(child);
                    } else if (parent.getLeftChild() == current) {
                        parent.addLeftChild(child);
                    } else {
                        parent.addRightChild(child);
                    }
                }
                return true;
            } else {
                parent = current;
                current = (compare < 0) ? current.getLeftChild() : current.getRightChild();
            }
        }

        return false;
    }

    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if (node.getLeftChild() == null) {
            return node;
        }
        return findMin(node.getLeftChild());
    }
    public T findMin() {
        if (getRoot() == null) {
            return null;
        }

        return findMin(getRoot()).getElement();
    }
    public T findMax(){
        if (getRoot() == null) return null;

        var current = getRoot();
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }

        return current.getElement();
    }

    public boolean contains(T element){
        var current = getRoot();

        while(current != null) {
            int compare = element.compareTo(current.element);

            if(compare == 0) return true;
            else if (compare < 0) current = current.getLeftChild();
            else current = current.getRightChild();
        }
        return false;
    }

    public void rebalance() {
        if (isEmpty()) throw new IllegalStateException("The tree is empty");
        if (size() == 1) return;
        ArrayList<T> elements = inOrder();
        this.setRoot(sortedArrayToBST(elements, 0, elements.size() - 1));
    }
    private BinaryTreeNode<T> sortedArrayToBST(ArrayList<T> list, int start, int end) {
        BinaryTreeNode<T> node = null;
        if (start < end) {
            //Get the middle element and make it root
            int mid = (start + end) / 2;
            node = new BinaryTreeNode<T>(list.get(mid));

        /* Recursively construct the left subtree and make
         it left child of root */
            node.addLeftChild(sortedArrayToBST(list, start, mid - 1));

        /* Recursively construct the right subtree and make
         it right child of root */
            node.addRightChild(sortedArrayToBST(list, mid + 1, end));
        }

        return node;
    }

}
