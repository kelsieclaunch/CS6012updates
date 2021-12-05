package assignment04;

import assignment04.QuickSortCharter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class QuicksortTimingExperiments {

    private static final int ITER_COUNT = 100;


    public static void main(String[] args) {

        QuickSortHelpers<Integer> integerQuickSort = new QuickSortHelpers<>();

        ArrayList<Integer> integerListWorst = new ArrayList<>();
        ArrayList<Integer> integerListBest = new ArrayList<>();
        ArrayList<Integer> integerListAverage = new ArrayList<>();

        ArrayList<Integer> ascendingArr = SortUtil.generateBestCase(100000);
        ArrayList<Integer> descendingArr = SortUtil.generateWorstCase(100000);
        ArrayList<Integer> permutedArr = SortUtil.generateAverageCase(100000);


        // you spin me round baby, right round
        long startTime = System.nanoTime();
        while (System.nanoTime() - startTime < 1_000_000_000)
            ;

        try (FileWriter fw = new FileWriter(new File("QuickSortMiddleAverageCase.tsv"))) { // open up a file writer so we can write
            // to file.
        //try (FileWriter fw = new FileWriter(new File("mergesort.tsv"))){
            for (int exp = 8; exp <= 20; exp++) { // This is used as the exponent to calculate the size of the set.
                int size = (int) Math.pow(2, exp);

                //integerListWorst = SortUtil.generateWorstCase(size);
                integerListAverage = SortUtil.generateAverageCase(size);
                //integerListBest = SortUtil.generateBestCase(size);

                // Do the experiment multiple times, and average out the results
                long totalTime = 0;

                for (int iter = 0; iter < ITER_COUNT; iter++) {

                    // TIME IT!
                    long start = System.nanoTime();

                    //integerQuickSort.quickSort(integerListWorst, new SortUtil.NaturalComparator<>(), 0, integerListWorst.size() - 1);
                    integerQuickSort.quickSort(integerListAverage, new SortUtil.NaturalComparator<>(), 0, integerListAverage.size() - 1);
                    //integerQuickSort.quickSort(integerListBest, new SortUtil.NaturalComparator<>(), 0, integerListBest.size() - 1);

                    //SortUtil.mergesort(ascendingArr, (lhs, rhs) -> lhs.compareTo(rhs));
                    //SortUtil.mergesort(descendingArr, (lhs, rhs) -> lhs.compareTo(rhs));
                    //SortUtil.mergesort(permutedArr, (lhs, rhs) -> lhs.compareTo(rhs));

                    long stop = System.nanoTime();
                    totalTime += stop - start;
                }
                double averageTime = totalTime / (double) ITER_COUNT;
                System.out.println(size + "\t" + averageTime); // print to console
                fw.write(size + "\t" + averageTime + "\n"); // write to file.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuickSortCharter charter = new QuickSortCharter();
        charter.createChart("QuickSortMiddleAverageCase.tsv", "ChartMiddleAverageCase.png");
        //charter.createChart("mergesort.tsv", "mergesort.png");
    }
}

