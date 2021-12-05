package assignment04;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class SortUtilTest {

    private static ArrayList<Integer> ascendingArr = SortUtil.generateBestCase(1000);
    private static ArrayList<Integer> descendingArr = SortUtil.generateWorstCase(1000);
    private static ArrayList<Integer> permutedArr = SortUtil.generateWorstCase(1000);

    @Test
    public void testMergeSort() {

        // ascending array
        SortUtil.mergesort(ascendingArr, (lhs, rhs) -> lhs.compareTo(rhs));
        assertTrue(isAscending(ascendingArr, (lhs, rhs) -> lhs.compareTo(rhs)));
      // descending array
        SortUtil.mergesort(descendingArr, (lhs, rhs) -> lhs.compareTo(rhs));
        assertTrue(isAscending(descendingArr, (lhs, rhs) -> lhs.compareTo(rhs)));

        // permuted arrays
        SortUtil.mergesort(permutedArr, (lhs, rhs) -> lhs.compareTo(rhs));
        assertTrue(isAscending(permutedArr, (lhs, rhs) -> lhs.compareTo(rhs)));
        permutedArr = SortUtil.generateAverageCase(1000);
        SortUtil.mergesort(permutedArr, (lhs, rhs) -> lhs.compareTo(rhs));
        assertTrue(isAscending(permutedArr, (lhs, rhs) -> lhs.compareTo(rhs)));
        permutedArr = SortUtil.generateAverageCase(1000);
        SortUtil.mergesort(permutedArr, (lhs, rhs) -> lhs.compareTo(rhs));
        assertTrue(isAscending(permutedArr, (lhs, rhs) -> lhs.compareTo(rhs)));
    }
    /**
     * Determine if an array is ascending.
     *
     * @param arr
     *            -- array to determine the status of
     * @param comp
     *            -- comparator to determine the status of the array with
     * @return -- true if the array is ascending, false otherwise
     */
    private static <T> boolean isAscending(ArrayList<T> arr, Comparator<? super T> comp) {
        for (int index = 0; index < arr.size() - 1; index++) {
            if (comp.compare(arr.get(index), arr.get(index + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Determine if an array is descending.
     *
     * @param arr
     *            -- array to determine the status of
     * @param comp
     *            -- comparator to determine the status of the array with
     * @return -- true if the array is descending, false otherwise
     */
    private static <T> boolean isDescending(ArrayList<T> arr, Comparator<? super T> comp) {
        for (int index = 0; index < arr.size() - 1; index++) {
            if (comp.compare(arr.get(index), arr.get(index + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

}