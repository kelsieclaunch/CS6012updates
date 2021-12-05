package assignment05;


import java.lang.reflect.Array;
import java.util.*;


//left child is always less than, right child is always more
//BST assumes no duplicates
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T>{
    // class to handle the nodes on the Binary Search Tree
    //there is no requirement that the nodes be balanced
    //write a function to handle duplicates? duplicates are handled in add
    private T[] array;
    private List<T> list = new ArrayList<>();
   private BSTNode root;


    public BSTNode createNew( T data){
        BSTNode newNode = new BSTNode(data);
        newNode.dataValue = data; //handle the 3 member variables assoc with BSTNode: the node's data, and what nodes are to the left and right
        newNode.left = null;
        newNode.right = null;
        return newNode;

    }

    public BSTNode add(BSTNode node, T value){ //recursive function for finding the correct place for the node on the tree
        if( node == null){
            return createNew(value);
        }
        if( value.compareTo((T)node.dataValue) < 0){ // replace with .compareTo for generics. for ints value < node.dataValue
            node.left = add(node.left, value);
        }
        else if ( value.compareTo((T)node.dataValue) > 0){ // replace with .compareTo for generics. for ints value > node.dataValue
            node.right = add(node.right, value);
        }
       return node;
    }

    public BSTNode delete(BSTNode node, T value){ //recursive function for removing a node from the BST
        if( node == null){
            return null;
        }
        //finds the node with the correct value
        if( value.compareTo((T)node.dataValue) < 0){ // .compareTo for generics, for ints value < node.dataValue
            node.left = delete(node.left, value);
        }
         else if( value.compareTo((T)node.dataValue) > 0){ // .compareTo for generics, for ints value > node.dataValue
            node.right = delete(node.right, value);
        }
         else {
            if (node.left == null || node.right == null) {
                BSTNode temp = null;
                if (node.left == null) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }
                if (temp == null) { // if both elements are null
                    return null;
                }
                else{
                    return temp;
                }
            }
            else {
                BSTNode successor = getSuccessor(node);
                node.dataValue = successor.dataValue;
                node.right = delete(node.right, (T)successor.dataValue);
                return node;
            }
        }
         return node;
    }

    public BSTNode getSuccessor(BSTNode node){
        if( node == null){
            return null;
        }
        BSTNode temp = node.right;

        while(temp.left != null){
            temp = temp.left;
        }
         return temp;
    }

    @Override
    public boolean add(T item) {
        BSTNode node = null;
        add(node, item);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> items) {
        //creates an arraylist from the collection, calls add on each element in the arraylist

        ArrayList<T> arraylist = new ArrayList<>();
        for(T i : items){
            arraylist.add(i);
            BSTNode newElement = null;
            newElement.dataValue = arraylist.indexOf(i);
        }
        for( int i = 0; i < arraylist.size(); i ++){
            BSTNode newElement = null;
            T data = arraylist.get(i);
            add(newElement, data);
        }
        return false;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(T item) {
        if(root != null) {

            if (root == item) {
                return true;
            }
            if (root.left == item) {
                return true;
            }
            if (root.right == item) {
                return true;
            } else {
                while (root.left != null) {
                    root = root.left;
                    contains(item);
                }
                while (root.right != null) {
                    root = root.right;
                    contains(item);
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends T> items) {
        //creates an arraylist from the collection, searches for those items in the BST
        ArrayList<T> arraylist = new ArrayList<>();
        for(T i : items){
            arraylist.add(i);
            BSTNode newElement = null;
            newElement.dataValue = arraylist.indexOf(i);
        }
        for( int i = 0; i < arraylist.size(); i ++){
            T data = arraylist.get(i);
            if(!contains(data)){ //if there are any elements in the arraylist that aren't found in the BST, return false
                return false;
            }
        }
        return true;
    }

    @Override
    public T first() throws NoSuchElementException {
        BSTNode firstNode = null;
        BSTNode temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        if(temp == null){
            firstNode = temp.right;
        }
       return ((T) firstNode.dataValue); // returns the object at the 0 index of the array
    }

    @Override
    public boolean isEmpty() {
        if( root == null ){
            return true;
        }
        return false;
    }

    @Override
    public T last() throws NoSuchElementException {
        BSTNode lastNode = null;
        BSTNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        if(temp == null){
            lastNode = temp.left;
        }
        return ((T) lastNode.dataValue); // returns the object at the very end of the array
    }

    @Override
    public boolean remove(T item) {
        BSTNode node = null;
        delete(node, item);
        return true;
    }

    @Override
    public boolean removeAll(Collection<? extends T> items) {
        //creates an arraylist from the collection, calls delete on each element in the arraylist
        ArrayList<T> arraylist = new ArrayList<>();
        for(T i : items){
            arraylist.add(i);
            BSTNode newElement = null;
            newElement.dataValue = arraylist.indexOf(i);
        }
        for( int i = 0; i < arraylist.size(); i ++){
            BSTNode newElement = null;
            T data = arraylist.get(i);
            delete(newElement, data);
        }
        return false;
    }

    @Override
    public int size() {
        int size = 1;
        while(root.left != null){
            size++;
            root = root.left;
        }
        while(root.right != null){
            size++;
            root = root.right;
        }

        return size;
    }

    @Override
    public ArrayList<T> toArrayList() {
        ArrayList<T> array = new ArrayList<>();
        inOrderTraversal(root, array);
        return array;
    }

    public void inOrderTraversal(BSTNode node, ArrayList<T> arr) {
        if (node != null) {
            inOrderTraversal(node.left, arr);
            arr.add((T)node.dataValue);
            inOrderTraversal(node.right, arr);
        }
    }

}
