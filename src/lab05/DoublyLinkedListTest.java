package lab05;

import lab01.DiffUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest extends DiffUtil {
    DoublyLinkedList<Integer> IntTest = new DoublyLinkedList<>();
    DoublyLinkedList<String> StringTest = new DoublyLinkedList<>();

    @Test
    public void addFirstInteger() {
        IntTest.addFirst(1);
        Assert.assertTrue(IntTest.head.equals(1));
    }

    @Test
    public void addLastInteger() {
        IntTest.addLast(5);
        Assert.assertTrue(IntTest.head.previous.equals(5));
    }

    @Test
    public void addInteger() {
        IntTest.add(1, 2);
        IntTest.add(2, 3);
        IntTest.add(3, 4);
        Assert.assertTrue(IntTest.get(1) == 2);
    }

    @Test
    public void getFirstInteger() {
        Assert.assertTrue(IntTest.getFirst() == 1);
    }

    @Test
    public void getLastInteger() {
        Assert.assertTrue(IntTest.getLast() == 5);
    }


    @Test
    public void removeFirstInteger() {
        IntTest.removeFirst();
        Assert.assertTrue(IntTest.get(0) == 2);
    }

    @Test
    public void removeLastInteger() {
        IntTest.removeLast();
        Assert.assertTrue(IntTest.get(5) == null);
    }

    @Test
    public void removeInteger() {
        IntTest.remove(0);
        Assert.assertTrue(IntTest.get(0) == 3);
    }

    @Test
    public void indexOfInteger() {
        Assert.assertTrue(IntTest.indexOf(3) == 0);
    }

    @Test
    public void lastIndexOfInteger() {
        Assert.assertTrue(IntTest.lastIndexOf(3) == 0);
    }

    @Test
    public void sizeInteger() {
        Assert.assertTrue(IntTest.size() == 2);
    }

    @Test
    public void isEmptyInteger() {
        Assert.assertFalse(IntTest.isEmpty());

    }

    @Test
    public void clearInteger() {
        IntTest.clear();
        Assert.assertTrue(IntTest.isEmpty());
    }

    @Test
    public void addFirstString() {
        StringTest.addFirst("Fleury");
        Assert.assertTrue(StringTest.head.equals("Fleury"));
    }

    @Test
    public void addLastString() {
        StringTest.addLast("Kane");
        Assert.assertTrue(StringTest.head.previous.equals("Kane"));
    }

    @Test
    public void addString() {
        StringTest.add(1, "Tanev" );
        StringTest.add(2, "Eberle");
        StringTest.add( 3, "Teravainen");
        Assert.assertTrue(StringTest.get(1).equals("Tanev")); // also tests my get method
    }

    @Test
    public void getFirstString() {
        Assert.assertTrue(StringTest.getFirst() == "Fleury");
    }

    @Test
    public void getLastString() {
        Assert.assertTrue(StringTest.getLast() == "Kane");
    }


    @Test
    public void removeFirstString() {
        StringTest.removeFirst();
        Assert.assertTrue(StringTest.get(0) == "Tanev");
    }

    @Test
    public void removeLastString() {
        StringTest.removeLast();
        Assert.assertFalse(StringTest.getLast() == "Kane");
    }

    @Test
    public void removeString() {
        StringTest.remove(4);
        Assert.assertTrue(StringTest.get(4).equals(null));
    }

    @Test
    public void indexOfString() {
        Assert.assertTrue(StringTest.indexOf("Tanev") == 0);
    }

    @Test
    public void lastIndexOfString() {
        Assert.assertTrue(StringTest.lastIndexOf("Tanev") == 0);
    }

    @Test
    public void sizeString() {
        Assert.assertTrue(StringTest.size() == 2);
    }

    @Test
    public void isEmptyString() {
        Assert.assertFalse(StringTest.isEmpty());
    }

    @Test
    public void clearString() {
        StringTest.clear();
        Assert.assertTrue(StringTest.isEmpty());
    }

}