package assignment04;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortHelpersTest {
    private QuickSortHelpers<Integer> integerQuickSort = new QuickSortHelpers<>();
    private QuickSortHelpers<String> stringQuickSort = new QuickSortHelpers<>();

    private ArrayList<Integer> integerList, sortedIntegerList, integerListEmpty;
    private ArrayList<String> stringList, sortedStringList, stringListEmpty;

    @Before
    public void setUp() throws Exception {

        //Integer Lists
        integerList = new ArrayList<>(Arrays.asList(90, 6, 2, 3, 9, 1, 7, 5, 16, 24));
        sortedIntegerList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 9, 16, 24, 90));

        integerListEmpty = null;

        //String Lists
        stringList = new ArrayList<>(Arrays.asList("Sebastian", "Mushu", "Pascal", "HeiHei", "Chip", "Meeko"));
        sortedStringList = new ArrayList<>(Arrays.asList("Chip", "HeiHei", "Meeko", "Mushu", "Pascal", "Sebastian"));

        stringListEmpty = null;


    }
    @Test
    public void QuickSortIntTest() throws Exception {
        setUp();
        integerQuickSort.quickSort(integerList, new SortUtil.NaturalComparator<>(), 0, integerList.size() - 1);
        assertEquals(sortedIntegerList, integerList);

    }

    @Test
    public void QuickSortStringTest() throws Exception{
        setUp();
    stringQuickSort.quickSort(stringList, new SortUtil.NaturalComparator<>(), 0, stringList.size() - 1);
    assertEquals(sortedStringList, stringList);
    }
}



