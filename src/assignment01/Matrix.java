package assignment01;

public class Matrix {
  int numRows;
  int numColumns;
  int data[][];

  // Constructor with data for new matrix (automatically determines dimensions)
  public Matrix(int data[][]) {
    numRows = data.length; // d.length is the number of 1D arrays in the 2D array
    if (numRows == 0) {
      numColumns = 0;
    } else {
      numColumns = data[0].length; // d[0] is the first 1D array
    }
    this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
    // copy the data over
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        this.data[i][j] = data[i][j];
      }
    }
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
  // the superclass' (Object) version
  public boolean equals(Object other) {
    if (!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
      return false;
    }
    Matrix matrix = (Matrix) other;
    // if the above was not true, we know it's safe to treat 'o' as a Matrix
    // FIRST: check if the dimensions are the same.
    // same number of rows?
    // same number of columns?
    // SECOND
    //index through Matrix matrix and Matrix object
    // compare the values
    if (matrix.numRows == ((Matrix) other).numRows && matrix.numColumns == ((Matrix) other).numColumns) {
      if (matrix.data == ((Matrix) other).data) {
        return true;
      }
    }
    return false;
  }

  @Override // instruct the compiler that we do indeed intend for this method to override
  // the superclass' (Object) version
  public String toString() {
    String myString;
    String resultString;
    //String string = data[0][0] + " " + data[0][numColumns - 1] + " " + "\n" + data[1][0] + " " + data[1][numColumns - 1] + " " + "\n" + data[numRows - 1][0] + " " + data[numRows - 1][numColumns - 1] + " " + "\n";
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        Integer myInt = data[i][j];
        myString = (myInt.toString() + " ");
      }
     // resultString = (myString + "\n");
    }
    //return resultString;
    return null;
  }


  public Matrix times(Matrix matrix) {

    if (this.numColumns == matrix.numRows) {
      Matrix newSize = new Matrix(new int[][]{});
      newSize.numRows = this.numRows;
      newSize.numColumns = matrix.numColumns;
      int sum = 0;
      for (int i = 0; i < newSize.numRows; i++) {
        for (int j = 0; j < newSize.numColumns; j++) {
          for (int k = 0; k < matrix.numColumns; k++) {
            sum += this.data[i][k] * matrix.data[k][j];

          }
          newSize.data[i][j] = sum;
          sum = 0;
        }
      }
      return newSize;
    } else if (this.numRows == matrix.numColumns) {
      Matrix newSize = new Matrix(new int[][]{});
      newSize.numRows = matrix.numRows;
      newSize.numColumns = this.numColumns;
      int sum = 0;
      for (int i = 0; i < newSize.numRows; i++) {
        for (int j = 0; j < newSize.numColumns; j++) {
          for (int k = 0; k < matrix.numColumns; k++) {
            sum += this.data[i][k] * matrix.data[k][j];

          }
          newSize.data[i][j] = sum;
          sum = 0;

        }
      }
      return newSize;
    } else if (!(this.numColumns == matrix.numRows) && !(this.numRows == matrix.numColumns)) {
      //FIRST: is numRows of one equal to numColumns of another?
      // IF NO: return null
    }
    return null;
  }

  public Matrix plus(Matrix matrix) {
    if (this.numColumns == matrix.numRows && this.numRows == matrix.numColumns) {
      Matrix result = new Matrix(new int[this.numRows][this.numColumns]);
      for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numColumns; j++) {
          result.data[i][j] = this.data[i][j] + matrix.data[i][j];
        }
      }
      return result;
    }
    return null;
  }
}

