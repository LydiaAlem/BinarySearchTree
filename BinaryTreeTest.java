/**
 * I created JUnit test cases to test {@BinaryTree.java} 
 * By: Lydia Alem
 */


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
public class BinaryTreeTest {
  
    @Test
    public void insert(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        assertEquals("Insert method is incorrect", Integer.valueOf(5), tree.getRoot().getData());
    }

    @Test
    public void searchingEmptyTree(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertNull(tree.search(5)); // Test searching for an element in an empty tree -> null
    }

    @Test
    public void searchingElement(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        assertNull(tree.search(1)); // Test searching for an absent element -> null
    }

    @Test
    public void removeElement(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.remove(tree.getRoot(), 3);
        assertFalse(tree.contains(3));
    }

    @Test 
    public void searchforRemoveElement(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.remove(tree.getRoot(), 3);
        assertFalse(tree.contains(3));
    } 
}
