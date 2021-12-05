package assignment04;

///This is the rate of change calculator that Anna sent in students help students to prove which pivot is the best

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AnnasRateOfChange {


    public static void main(String[]args)  throws IOException  {

        //System.out.println(new File(".").getAbsoluteFile());
        //shows where files are being read from^

        /**
         * Data to read in, make sure it's in the parent directory of your src directory
         * If it cannot find your file, use the commented out sout code above to find where your files are being read from
         */
        FileReader myFileReader = new FileReader("QuickSortMiddleAverageCase.tsv");

        /**
         * For separating the x and y values into .tsv files
         */
//        FileWriter xValues = new FileWriter("BinarySearchSetContainsX.tsv");
//        FileWriter yValues = new FileWriter("BinarySearchSetContainsY.tsv");


        /**
         * For writing out the rate of change to a .tsv
         */
        FileWriter rateOfChangeFW = new FileWriter("RateOfChangeMIDAVG.tsv");
        BufferedReader myBF = new BufferedReader(myFileReader);
        String line;
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        double xChange = 0.0;
        double yChange = 0.0;
        double rateOfChange = 0.0;
        double overallRateOfChange = 0.0;

        /**
         * Check what regex you used to parse your file you read data in from
         * If you're using the skeleton of Varun's contains timing experiment, your regex should be identical to this default value
         */
        while((line = myBF.readLine()) != null){
            String[] containsSplit = line.split("\t", 2);
            x.add(Double.parseDouble(containsSplit[0]));
            y.add(Double.parseDouble(containsSplit[1]));
        }

        /**
         * Writes out x values, y values. Can comment out if not needed
         * Calculates the change in x and y, then the rate of change from those calculations
         * Writes out the rate of change to the file given as a parameter to rateOfChangeFW
         */
        for(int i = 6; i < x.size() - 1; i++){
            //System.out.println("X value is: " + x.get(i));
            //System.out.println("Y value is: " + y.get(i));
//            xValues.write(x.get(i) + "\n");
//            yValues.write(y.get(i) + "\n");
            xChange = x.get(i+1) - x.get(i);
            yChange = y.get(i+1) - y.get(i);
            rateOfChange = yChange/xChange;
            rateOfChangeFW.write(rateOfChange + "\n");
            if( i > 1) {
                overallRateOfChange += rateOfChange;
            }
        }

        rateOfChangeFW.write( "The overall Rate of Change is: " + (overallRateOfChange/(x.size() - 1)));

        /**
         * If you don't close your FileWriter(s), you may become the joker
         * earlier, I became the joker
         */
//        xValues.close();
//        yValues.close();
        rateOfChangeFW.close();

        /**
         * I would literally spend 20 minutes writing a class to splice up my data and calculate rate of change than manually copying and pasting my data to make calculations by hand that would probably amount to 2 or 3 minutes tops.
         * Love, Me
         * (Anna....sussy baka)
         */


    }

}
