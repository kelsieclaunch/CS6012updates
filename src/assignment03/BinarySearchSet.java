package assignment03;
import java.util.*;

public class BinarySearchSet<E> implements Iterable, SortedSet {
    E[] array;
    E elem;
    int leftPos;
    int rightPos;

    private Comparator<E> myComparator;

    public BinarySearchSet() {
        elem = null;
        myComparator = new NaturalComparator();
    } // assumes elements are ordered using their natural order

    public BinarySearchSet(Comparator<? super E> comparator) {
        elem = null;
        myComparator = (Comparator<E>) comparator;
    } //assumes elements are ordered using the provided comparator



    class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
        @Override
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }

    private int BinarySearchIndex(E elem) {
        int leftPos = 0;
        int rightPos = array.length - 1;
        while (leftPos <= rightPos) {
            int midPos = (leftPos + rightPos) / 2;
            if (array[midPos] == elem) {
                return midPos;
            } else if (compare(array[midPos], elem) < 0 ) { // I do not at all understand why E types can't use < or > and what Im supposed to do instead
                leftPos = midPos + 1;
            } else if (compare(array[midPos], elem) > 0)
                rightPos = midPos = 1;
        }
        return -1; // index not found
    }


// here's my attempt at writing it recursively so I could use it for my contains method, but that didn't work
    public boolean BinarySearch(E[] array, (E) elem, leftPos, rightPos){
      if(leftPos > rightPos){
            return false; // something would already be wrong
        }
        int midPos = (leftPos + rightPos) / 2;
        if ( array[midPos] == elem){
            return true;
        }
        else if(array[midPos] > elem){ //narrowing it down to the correct half of what we are currently looking at
            return BinarySearch(array, elem, leftPos, midPos - 1);
        } else{
            return BinarySearch(array, elem, midPos + 1, rightPos);
        }
    }


    @Override
    public Comparator comparator() {
        return null;
    }

    @Override
    public Object first() throws NoSuchElementException {
        E first = array[0];
        return first; // returns the object at the 0 index of the array
    }

    @Override
    public Object last() throws NoSuchElementException {
        E last = array[array.length - 1];
        return last; // returns the object at the very end of the array
    }

    @Override
    public boolean add(Object element) { //locate what index should contain the element and insert it there
        return false;
    }

    @Override
    public boolean addAll(Collection elements) { // check if the array is an appropriate size. Double if needed. add a series of elements at their appropriate indices
        return false;
    }

    @Override
    public void clear() { //remove all items in the array
        array = null;
    }

    @Override
    public boolean contains(Object element) { // use the binarysearch function written above to return true if the element can be found in the array
        return false;
    }

    @Override
    public boolean isEmpty() {
        if( array.length == 0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object element) { //find the element's index and set that index to null?

        return false;
    }

    @Override
    public int size() {
        int size = array.length;
        return size;
    }

    @Override
    public Object[] toArray() { //return all elements, sorted in ascending order
        return new Object[0];
    }

    @Override
    public boolean removeAll(Collection elements) { // remove all elements
    }

    @Override
    public boolean containsAll(Collection elements) { // see if the Array contains a series of elements
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


}
