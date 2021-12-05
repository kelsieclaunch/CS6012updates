package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SortUtil{
    private static int limit_= 450;
    static class NaturalComparator<T extends Comparable<T>>  implements Comparator<T> {
        @Override
        public int compare(T a, T b){
            return a.compareTo(b);
        }
    }


    /////////////////TERRA'S MERGESORT/////////////////////////////

    public static <T> void mergesort(ArrayList<T> array, Comparator<? super T> comp) {
        if (array == null || comp == null || array.isEmpty()) {
            return;
        }

        mergeSort(array, comp, 0, array.size() - 1);
    }

    public static <T> void mergeSort(ArrayList<T> myArrayList, Comparator<? super T> comparator, int left, int right) {

        if(Math.abs(right - left) <= limit_) {
            insertionSort(myArrayList, comparator, left, right);
        }
        //recursive method
        int center = (left + right) / 2;
        mergeSort(myArrayList, comparator, left, center); //mergeSort left half

        mergeSort(myArrayList, comparator, center + 1, right); //mergeSort right half
        merge(myArrayList, comparator, left, center + 1, right);


    }

    public static <T> void merge(ArrayList<T> myArrayList, Comparator<? super T> comp, int left, int center, int right) {
        /// clone subarrays into separate arrays
        // left subarray goes from `left` (inclusive) to `mid` (exclusive)
        // right subarray goes from `mid` (inclusive) to `right` (inclusive)
        ArrayList<T> leftSubarr = new ArrayList<T>();
        ArrayList<T> rightSubarr = new ArrayList<T>();

        for (int curs = left; curs < center; curs++) {
            leftSubarr.add(myArrayList.get(curs));
        }
        for(int curs = center; curs <= right; curs++) {
            rightSubarr.add(myArrayList.get(curs));
        }

        // copy two subarray clones into the master array in sorted form
        // both subarrays are iterated on, the first element of each is compared and the lesser is copied to the master array
        int lIdx = 0; // index of left subarray
        int rIdx = 0; // index of right subarray
        int mIdx = left; // index of master array
        while (lIdx < leftSubarr.size() && rIdx < rightSubarr.size()) {
            int compRes = comp.compare(leftSubarr.get(lIdx), rightSubarr.get(rIdx));

            // if leftSubarr's element is 'less' than rightSubarr's...
            if (compRes < 0) {
                myArrayList.set(mIdx, leftSubarr.get(lIdx));
                lIdx++;
            }
            else {
                myArrayList.set(mIdx, rightSubarr.get(rIdx));
                rIdx++;
            }

            mIdx++;
        }

    }

    //Creating insertionSort method for when the list is small enough in size
    public static <T> void insertionSort(ArrayList<T>myArrayList,Comparator<? super T> comp, int start, int end) {
        // element at unsortedIdx is the element to be inserted into the sorted section
        for (int unsortedIdx = start; unsortedIdx <= end; unsortedIdx++) {
            T unsortedElem = myArrayList.get(unsortedIdx);

            // move every element that is 'greater' than unsortedElem up one index
            int idx = unsortedIdx - 1;
            while (idx >= 0 && comp.compare(myArrayList.get(idx), unsortedElem) > 0) {
                myArrayList.set(idx + 1, myArrayList.get(idx));
                idx--;
            }
            // insert unsortedElem in its sorted position
            myArrayList.set(idx + 1, unsortedElem);
        }
    }

    ///////KELSIE'S QUICKSORT///

    public static <T> void quicksort(ArrayList<T> arrayList, Comparator<? super T> comparator){ //what the user will call
        QuickSortHelpers myQuickSorter = new QuickSortHelpers<>();
        myQuickSorter.quickSort(arrayList, comparator, 0, arrayList.size() - 1); // bounds at the very beginning

    }


    public static ArrayList<Integer> generateBestCase(int size){
        ArrayList<Integer> bestCase = new ArrayList<>();
        for(int i = 0; i < size; i++){
            bestCase.add(i);
        }
        return bestCase;
    }

    public static ArrayList<Integer> generateAverageCase(int size){
        return new ArrayList<>();
    }

    public static ArrayList<Integer> generateWorstCase(int size){
        ArrayList<Integer> worstCase = new ArrayList<>();
        for(int i = size - 1; i >= 0; i--){
            worstCase.add(i);
        }
        return worstCase;
    }



}
