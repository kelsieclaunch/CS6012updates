package assignment05;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

        BinarySearchTree<Integer> newTree1 = new BinarySearchTree<>();
        BSTNode root = null;

        BinarySearchTree<Integer> newTree2 = new BinarySearchTree<>();





    @Test
    public void addInt() {
        newTree2.add(root, 5);
        newTree2.add(root, 1);
        newTree2.add(root, 3);
        newTree2.add(root, 2);
        assertTrue(newTree2.contains(5));
        assertTrue(newTree2.last().equals(5)); // also tests last
    }

    @Test
    public void first() {
        assertTrue(newTree2.first().equals(1));
    }


    @Test
    public void isEmptyInt() {
        assertTrue(newTree1.isEmpty());
    }


        @Test
        public void removeInt () {
            newTree2.remove(5);
            assertFalse(newTree2.contains(5));
        }

        @Test
        public void sizeInt () {
            assertTrue(newTree2.size() == 3);
        }

        @Test
        public void clearInt () {
            newTree2.clear();
            assertTrue(newTree2.isEmpty());
        }
}