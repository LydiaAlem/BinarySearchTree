/**
 * This class extends {@BinaryTree.java} to ask the user for inputs from the BST
 * By: Lydia Alem
 */

import java.util.*;

public class Main<T extends Comparable<T>>{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("How many nodes do you want in the BST: ");
        int numNodes = scan.nextInt();

        BinaryTree<Integer> tree = new BinaryTree<>();
        for(int i = 0; i < numNodes; i++){
            System.out.print("Enter the value of node " + (i+1) + ": ");
            int value = scan.nextInt();
            tree.insert(value);
        }
        System.out.println("In-Order Transversal:");
        tree.inOrderTraversal();
        System.out.println("\n\nPre-Order Transversal:");
        tree.preOrderTraversal();
        System.out.println("\n\nPost-Order Transversal:");
        tree.postOrderTraversal();
        scan.close();
    }
}
