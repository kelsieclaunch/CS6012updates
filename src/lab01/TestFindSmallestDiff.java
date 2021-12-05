package lab01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFindSmallestDiff extends DiffUtil {
    private int[] arr1, arr2, arr3, arr4, arr5;

    @Before
    public void setUp() throws Exception {
        arr1 = new int[0];
        arr2 = new int[] { 3, 3, 3 };
        arr3 = new int[] { 52, 4, -8, 0, -17 };
        arr4 = new int[] {52, 4, 0, -8, -17 };
        arr5 = new int[] {-17, -8, 0, 4, 52};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void emptyArray() {
        assertEquals(-1, DiffUtil.findSmallestDiff(arr1));
    }


    @Test
    public void allArrayElementsEqual() {
        assertEquals(0, DiffUtil.findSmallestDiff(arr2));
    }


    @Test
    public void smallRandomArrayElements() {
        assertEquals(4, DiffUtil.findSmallestDiff(arr3));
    }

    @Test
    public void smallSortedHighToLowArrayEquals() {
        assertEquals(4, DiffUtil.findSmallestDiff(arr4));
    }

    @Test
    public void smallSortedLowToHighArrayEquals() {
        assertEquals(4, DiffUtil.findSmallestDiff(arr5));
    }
}