/**
 * Binary Search Implementation that uses {@Node.java} implementation and extends {@Comparable<T>}
 * By: Lydia Alem
 */


public class BinaryTree<T extends Comparable<T>>{

    //instance variable
    private Node<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(T data, Node<T> left, Node<T> right){
        this.root = new Node<T>(data, left, right);
    }

    public Node<T> getRoot(){
        return this.root;
    }

/**
 *  Three different transversal methods (in-order, post-order, pre-order)
 */

    //pre-order traversal

    public void preOrderTraversal(){
        preOrderTraversalHelper(this.root);
    }

    public void preOrderTraversalHelper(Node<T> node){
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " -> ");
        preOrderTraversalHelper(node.getLeft());
        preOrderTraversalHelper(node.getRight());
    }

    //post-order traversal

    public void postOrderTraversalHelper(Node<T> node){
        if(node == null){
            return;
        }
        postOrderTraversalHelper(node.getLeft());
        postOrderTraversalHelper(node.getRight());
        System.out.print(node.getData()+ " -> ");

    }

    public void postOrderTraversal(){
        postOrderTraversalHelper(this.root);
    }

    //in-order traversal

    public void inOrderTraversalHelper(Node<T> node){
        if(node == null){
            return;
        }
        inOrderTraversalHelper(node.getLeft());
        System.out.print(node.getData()+ " -> ");
        inOrderTraversalHelper(node.getRight());
    }
    
    public void inOrderTraversal(){
        inOrderTraversalHelper(this.root);
    }

    /**
     * Search function
     * @param node
     * @param data
     * @return calling the search() method
     */
    public Node<T> searchHelper(Node<T> node, T data){
        if(node == null){
            return null;
        }
        else if(node.getData() == data){
            return node;
        }
        else if(node.getData().compareTo(data) < 0){
            return searchHelper(node.getLeft(), data);
        }
        else if(node.getData().compareTo(data) > 0){
            return searchHelper(node.getRight(), data);
        }
        return node;
    }

    public Node<T> search(T data){
        return searchHelper(this.root, data);
    }



/**
 * Insert Helper Function + Insert Function
 * @param node
 * @param data
 * @return inserted Node
 */

    public Node<T> insertHelper(Node<T> node, T data){
        if(node == null){
            return new Node<>(data, null, null);
        }
        if(data.compareTo(node.getData()) < 0){
            node.setLeft(insertHelper(node.getLeft(), data));
        }
        else if(data.compareTo(node.getData()) > 0){
            node.setRight(insertHelper(node.getRight(), data));
        }
        else{
            return node;
        }
        return node;
    }

    public void insert(T data){
        this.root = insertHelper(this.root, data);
    }

    public Node<T> remove(Node<T> node, T data){
        if(node == null){
            return null;
        }

        int compare = data.compareTo(node.getData());
        if(compare < 0){
            node.setLeft(remove(node.getLeft(), data));
        }
        else if(compare > 0){
            node.setRight(remove(node.getRight(), data));
        }
        else{
            //case 1--> if the node you want to remove is found and its a LEAF NODE
            if(node.getLeft() == null && node.getRight() == null){
                return null;
            }
            else if(node.getLeft() == null){ //if child only has right node, replace with right
                return node.getRight();
            }
            else if(node.getRight() == null){ //if child only has left node, replace with left
                return node.getLeft();
            }
            else {
                //if they are two children, find the minimum value of right subtree
                T min = findMin(node.getRight());
                node.setData(min);
                node.setRight(remove(node.getRight(), min));
            }
        }
        return node;
    }
            

    /**
     * Helper function for remove which grabs the minimum value of the tree, also known as the most-left node data
     */

    public T findMin(Node<T> node){
        if(node.getLeft() == null){
            return node.getData();
        }
        return findMin(node.getLeft());
    }

    public boolean contains(T data){
        return containsHelper(this.root, data);
    }

    public boolean containsHelper(Node<T> node, T data){
        if(node == null){
            return false;
        }
        if(node.getData().equals(data)){
            return true;
        }
        
        if(node.getData().compareTo(data) < 0){
            return containsHelper(node.getLeft(), data);
        }
        else{
            return containsHelper(node.getRight(), data);
        }
    }
}
