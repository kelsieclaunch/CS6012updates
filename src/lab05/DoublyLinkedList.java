package lab05;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements Iterable, List<E>{
    myNodes head;

    class myNodes{
        E data;
        myNodes previous;
        myNodes next;

        public myNodes(E data){
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public DoublyLinkedList() //default constructor
    {
        this.head = null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void addFirst(E element) {
       myNodes n = new myNodes(element);
        // n becomes the head
        if (head != null) {
            n.next = head; // these have to not be null to complete inserting it into the list
            head.previous = n;
        }
        head = n; //if head already doesn't exist, you don't have to change things around it before making n the head
    }

    @Override
    public void addLast(E o) {
        myNodes n = new myNodes(o);
        if (head == null){
            head = n;
        } // if head is null, we can set the head equal to n to add the node
        // if there are nodes already:
        else {
            myNodes temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n;
            n.previous = temp;
        }

    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        myNodes n = new myNodes(element);
        myNodes temp = head;
        while(index != 1){
            temp = head.next;
            index--;
        }
        myNodes temp2 = temp.next;
        n.next = temp2;
        n.previous = temp;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        return (E) head;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        return (E) head.previous;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        myNodes temp = head;
        int count = 0;
        while(temp!= null) {
            if (count == index) {
                return temp.data;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        myNodes toRemove = head;
        if(head == null || head.next == null){ //check if there is anything to remove
            head = null;
            return (E) toRemove;
        }
        head = head.next; // make it so the element is no longer connected to anything in the list
        head.previous = null;
        return (E) toRemove;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        myNodes toRemove = head;
        if (head == null || head.next == null){ // check if there's anything to remove
            head = null;
            return (E) toRemove;
        }
        while(toRemove.next != null){
            toRemove = toRemove.next; // go through the list
        }
        toRemove.previous.next = null;
        return (E) toRemove;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
         // set it at the head to start, then index through to the correct index
        myNodes temp = head;
        while(index != 1){
            temp = head.next;
            index--;
        }
        myNodes temp2 = temp.next;
        temp.next = null;
        temp.previous = null;
        return null;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        myNodes temp = head;
        while( temp.data != element){ // index through elements starting at 0
            temp = temp.next;
            index++;
        }
        if(temp.data == element) {
            return index;
        }
        return -1; // element not found
    }

    @Override
    public int lastIndexOf(E element) { //inverse of indexOf
        int index = size() - 1;
        myNodes temp = head.previous;
        while( temp.data != element){
            temp = temp.previous;
            index--;
        }
        if(temp.data == element){
            return index;
        }
        return -1; //element not found
    }

    @Override
    public int size() {
        int size = 0;
        myNodes temp = head;
        while( temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Object[] toArray() {
        myNodes toPrint = head;
        while (toPrint != null) { //while there's still stuff in the array
            System.out.println(toPrint);
            toPrint = toPrint.next;
        }
        return null;
    }

    public E next(){
        myNodes temp = head.next;
        return (E) temp;
    }

    public boolean hasNext(){
        while (head.next != null){
            return true;
        }
        return false;
    }

}
