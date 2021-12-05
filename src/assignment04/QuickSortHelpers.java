package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class QuickSortHelpers<T>{

    public void quickSort(ArrayList<T> arrayList, Comparator<? super T> comparator, int low, int high){
        //T pivot = arrayList.get(randPivotIndex(low, high));
        int pivotIndex = middlePivot(low, high);
        if (arrayList.size() == 0 || low >= high) {
            //do nothing
        } else {
            partition(arrayList, comparator, low, high, pivotIndex); //partition is what does the work in splitting up our array
        }
    }

    public void swap( ArrayList<T> arrayList, int index1, int index2) { // to swap an element less than the pivot with an element greater than the pivot
        T temp = arrayList.get(index1);
        arrayList.set(index1, arrayList.get(index2));
        arrayList.set(index2,temp);
    }

    public int medianOfThreePivot( ArrayList<T> arrayList){
        int low = 0;
        int high = arrayList.size() - 1;
        int middle = (low + high)/2;

        T lowValue = arrayList.get(0);
        T highValue = arrayList.get(high);
        T middleValue = arrayList.get(middle);

        ArrayList<Integer> findMedian = new ArrayList<>();
        findMedian.add(low);
        findMedian.add(middle);
        findMedian.add(high);
        findMedian.sort(new SortUtil.NaturalComparator<>());

        if(findMedian.get(1) == lowValue){
            return low;
        }else if(findMedian.get(1) == highValue){
            return high;
        }else if(findMedian.get(1) == middleValue){
            return middle;
        }
        return 0;
    }

    public int middlePivot(int low, int high){ // use the middle index as the pivot
        return (low + high)/2;
    }


//    public int randPivotIndex(int low, int high){ //randomly select a pivot
//        Random rand = new Random();
//        int pivot = rand.nextInt(Math.abs((high - low) + low));
//        return pivot;
//    }

    public int randPivotIndex(int low, int high){ //randomly select a pivot
        Random rand = new Random();
        int pivot = (rand.nextInt(Math.abs(high - low) + 1) + low);
        return pivot;
    }

    public void partition(ArrayList<T> arrayList, Comparator<? super T> comparator, int low, int high, int pivotIndex) {


        int L = low;
        int R = high - 1;

        swap(arrayList, pivotIndex, high);
        T pivot = arrayList.get(high);

        while (L <= R) {
            if (comparator.compare(arrayList.get(L), pivot) <= 0) {
                L++;
                continue;
            }
            if (comparator.compare(arrayList.get(R), pivot) >= 0) {
                R--;
                continue;
            }
            swap(arrayList, L, R);
            L++;
            R--;
        }
        swap(arrayList, L, high);
        quickSort(arrayList, comparator, low, L - 1); //sort small elements
        quickSort(arrayList, comparator, L + 1, high); //sort large elements
    }
}
