/**
 * Generic Node implementation for BinaryTree class
 * By: Lydia Alem
 */

public class Node<T extends Comparable<T>>{
    //instance variables
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Constructor for when adding nodes to tree
    public Node(T data, Node<T> left, Node<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    //getters
    public T getData(){
        return this.data;
    }

    public Node<T> getLeft(){
        return this.left;
    }

    public Node<T> getRight(){
        return this.right;
    }

    //setters

    public void setData(T data){
        this.data = data;
    }

    public void setLeft(Node<T> left){
        this.left = left;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }

}
