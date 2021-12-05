package assignment03;

import lab01.DiffUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchSetTest extends DiffUtil {
    BinarySearchSet<String> arr1 = new BinarySearchSet<>();
    arr1.add("me");
    arr1.add("of");
    arr1.add("death");
    arr1.add("the");
    arr1.add("be");
    arr1.add("will");
    arr1.add("assignment");
    arr1.add("This");

    BinarySearchSet<Integer> arr2 = new BinarySearchSet<>();
    arr2.add(1);
    arr2.add(2);
    arr2.add(4);

    BinarySearchSet<Integer> arr3 = new BinarySearchSet<>();
    arr3.add(3);
    arr3.add(5);
    arr3.add(6);
    arr3.add(7);
    arr3.add(8);



    @Test
    public void firstInt() {
        Assert.assertTrue(arr2.first().equals(1));
    }

    @Test
    public void lastInt() {
        Assert.assertTrue(arr2.last().equals(4));
    }

    @Test
    public void addInt() {
        arr2.add(5);
        Assert.assertTrue(arr2.contains(5));
        Assert.assertTrue(arr2.last().equals(5));
    }


    @Test
    public void isEmptyInt() {
        Assert.assertFalse(arr3.isEmpty());
    }

    @Test
    public void removeInt() {
        arr2.remove(5);
        Assert.assertFalse(arr2.contains(5));
    }

    @Test
    public void sizeInt() {
        Assert.assertTrue(arr2.size() == 3);
    }

    @Test
    public void clearInt() {
        arr2.clear();
        Assert.assertTrue(arr2.isEmpty());
    }

    @Test
    public void firstString() {
        Assert.assertTrue(arr1.first() == "This");
    }

    @Test
    public void lastString() {
        Assert.assertTrue(arr1.last() == "me");
    }

    @Test
    public void addString() {
        arr1.add("us all");
        Assert.assertTrue(arr1.last() == "us all");
    }

    @Test
    public void containsString() {
        Assert.assertTrue(arr1.contains("death"));
    }

    @Test
    public void isEmptyString() {
        Assert.assertFalse(arr1.isEmpty());
    }

    @Test
    public void removeString() {
        arr1.remove("me");
        Assert.assertFalse(arr1.contains("me"));
    }

    @Test
    public void sizeString() {
        Assert.assertTrue(arr1.size() == 8);
    }

    @Test
    public void clearString() {
        arr1.clear();
        Assert.assertTrue(arr1.isEmpty());
    }
}