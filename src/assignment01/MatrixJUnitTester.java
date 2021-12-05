/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package assignment01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixJUnitTester {

  Matrix threeByTwo, twoByThree, twoByTwoResult, threeByFour;
  /* Initialize some matrices we can play with for every test! */

  @Before
  public void setup() {
    threeByTwo = new Matrix(new int[][] { { 1, 2, 3 }, { 2, 5, 6 } });
    twoByThree = new Matrix(new int[][] { { 4, 5 }, { 3, 2 }, { 1, 1 } });
    // this is the known correct result of multiplying M1 by M2
    twoByTwoResult = new Matrix(new int[][] { { 13, 12 }, { 29, 26 } });
    threeByFour = new Matrix(new int[][] { {1, 2, 3, 4}, {5, 6, 7, 8}, {2, 4, 6, 8}});
  }

  @Test
  public void timesWithBalancedDimensions() {
    Matrix matrixProduct = threeByTwo.times(twoByThree);
    Assert.assertTrue(twoByTwoResult.equals(matrixProduct));
  }

  @Test
  public void timesWithUnbalancedDimensions() {
    Matrix matrixProduct = twoByTwoResult.times(threeByFour);
    Assert.assertEquals(matrixProduct, null);
  }

  @Test
  public void plusWithUnmatchingDimensions(){
    Matrix matrixSum = threeByFour.plus(twoByThree);
    Assert.assertEquals(matrixSum, null);
  }

  @Test
  public void twoByTwoToString() {
    String resultString = "what should it equal?";
    Assert.assertEquals(resultString, twoByTwoResult.toString());
  }

}
