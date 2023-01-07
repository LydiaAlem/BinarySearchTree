/**
 * This class extends {@BinaryTree.java} to ask the user for inputs from the BST
 */

import java.util.*;

public class Main<T extends Comparable<T>>{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        BinaryTree<Integer> tree = new BinaryTree<>();

        while(true){
            try{
                System.out.println("\nMenu:");
                System.out.println("1. Insert a node");
                System.out.println("2. Remove a node");
                System.out.println("3. Search for a node");
                System.out.println("4. Traverse the tree");
                System.out.println("5. Quit");
                System.out.print("> ");

                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        // Insert a node
                        System.out.print("Enter the value of the node to insert: ");
                        int value = scan.nextInt();
                        tree.insert(value);
                        break;
                    case 2:
                        // Remove a node
                        System.out.print("Enter the value of the node to remove: ");
                        value = scan.nextInt();
                        tree.remove(tree.getRoot(), value);
                        break;
                    case 3:
                        // Search for a node
                        System.out.print("Enter the value of the node to search for: ");
                        value = scan.nextInt();
                        if (tree.contains(value)) {
                            System.out.println("Node found");
                        } else {
                            System.out.println("Node not found");
                        }
                        break;
                    case 4:
                        // Traverse the tree
                        System.out.println("In-Order Transversal:");
                        tree.inOrderTraversal();
                        System.out.println("\n\nPre-Order Transversal:");
                        tree.preOrderTraversal();
                        System.out.println("\n\nPost-Order Transversal:");
                        tree.postOrderTraversal();
                        break;
                    case 5:
                        // Quit
                        scan.close();
                        return;
                    default:
                        // Invalid choice
                        System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please try again.");
            scan.nextLine(); // Discard invalid input
        }
        }
    }   
}
