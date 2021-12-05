package assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 *
 */
public class Library {

  private ArrayList<LibraryBook> library;

  public Library() {
    library = new ArrayList<LibraryBook>();
  }


  /**
   * Add the specified book to the library, assume no duplicates.
   *
   * @param isbn   -- ISBN of the book to be added
   * @param author -- author of the book to be added
   * @param title  -- title of the book to be added
   */
  public void add(long isbn, String author, String title) {
    library.add(new LibraryBook(isbn, author, title));
  }

  /**
   * Add the list of library books to the library, assume no duplicates.
   *
   * @param list -- list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook> list) {
    library.addAll(list);
  }

  /**
   * Add books specified by the input file. One book per line with ISBN, author,
   * and title separated by tabs.
   * <p>
   * If file does not exist or format is violated, do nothing.
   *
   * @param filename
   */
  public void addAll(String filename) {
    ArrayList<LibraryBook> toBeAdded = new ArrayList<LibraryBook>();

    try (Scanner fileIn = new Scanner(new File(filename))) {

      int lineNum = 1;

      while (fileIn.hasNextLine()) {
        String line = fileIn.nextLine();

        try (Scanner lineIn = new Scanner(line)) {
          lineIn.useDelimiter("\\t");

          if (!lineIn.hasNextLong()) {
            throw new ParseException("ISBN", lineNum);
          }
          long isbn = lineIn.nextLong();

          if (!lineIn.hasNext()) {
            throw new ParseException("Author", lineNum);
          }
          String author = lineIn.next();

          if (!lineIn.hasNext()) {
            throw new ParseException("Title", lineNum);
          }
          String title = lineIn.next();
          toBeAdded.add(new LibraryBook(isbn, author, title));
        }
        lineNum++;
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage() + " Nothing added to the library.");
      return;
    } catch (ParseException e) {
      System.err.println(e.getLocalizedMessage() + " formatted incorrectly at line " + e.getErrorOffset()
              + ". Nothing added to the library.");
      return;
    }

    library.addAll(toBeAdded);
  }

  /**
   * Returns the holder of the library book with the specified ISBN.
   * <p>
   * If no book with the specified ISBN is in the library, returns null.
   *
   * @param isbn -- ISBN of the book to be looked up
   */
  public String lookup(long isbn) {
    //index through the books in the library for a specific isbn
    for (int i = 0; i < library.size(); i++) {
      if (library.get(i).getIsbn() == isbn) {
        //when you find the matching isbn, return the associated holder
        return library.get(i).getHolder();
      }

    }
    return null; // if the ISBN can't be found
  }

  /**
   * Returns the list of library books checked out to the specified holder.
   * <p>
   * If the specified holder has no books checked out, returns an empty list.
   *
   * @param holder -- holder whose checked out books are returned
   */
  public ArrayList<LibraryBook> lookup(String holder) {
    //Create an empty arraylist of books checked out
    ArrayList<LibraryBook> booksOut = new ArrayList<>();
    //index through the books in the library to see what holder is assigned to each of them
    for (int i = 0; i < library.size(); i++) {
      if (library.get(i).getHolder() == holder) {
        //if the holder matches the one we are looking for, add it to our array list of books checked out
        booksOut.add(library.get(i));
      }

    }
    return booksOut; //return the list we made
  }

  /**
   * Sets the holder and due date of the library book with the specified ISBN.
   * <p>
   * If no book with the specified ISBN is in the library, returns false.
   * <p>
   * If the book with the specified ISBN is already checked out, returns false.
   * <p>
   * Otherwise, returns true.
   *
   * @param isbn   -- ISBN of the library book to be checked out
   * @param holder -- new holder of the library book
   * @param month  -- month of the new due date of the library book
   * @param day    -- day of the new due date of the library book
   * @param year   -- year of the new due date of the library book
   */
  public boolean checkout(long isbn, String holder, int month, int day, int year) {
    //index through the list of books in the library looking for a matching isbn, then make sure the book doesn't already have an assigned holder
    for (int i = 0; i < library.size(); i++) {
      if (library.get(i).getIsbn() == isbn) {
        library.get(i).checkout(holder, day, month, year);
        return true;

      }
    }
    return false;
  }

    /**
     * Unsets the holder and due date of the library book.
     *
     * If no book with the specified ISBN is in the library, returns false.
     *
     * If the book with the specified ISBN is already checked in, returns false.
     *
     * Otherwise, returns true.
     *
     * @param isbn
     *          -- ISBN of the library book to be checked in
     */
    public boolean checkin ( long isbn){
      //index through the library's list of books checking for a matching isbn. If it matched, check for the holder
      for (int i = 0; i < library.size(); i++) {
        if (library.get(i).getIsbn() == isbn) {
          library.get(i).checkIn();
            return true;

        }
      }
      return false;
    }

    /**
     * Unsets the holder and due date for all library books checked out be the
     * specified holder.
     *
     * If no books with the specified holder are in the library, returns false;
     *
     * Otherwise, returns true.
     *
     * @param holder
     *          -- holder of the library books to be checked in
     */
    public boolean checkin (String holder){
      int numCheckedIn = 0;
      // index through the list of books in the library, check all their holders to see if any find the one we're looking for
      for (int i = 0; i < library.size(); i++) {
        if (library.get(i).isItCheckedIn() == false && library.get(i).getHolder() == holder) { // if it matches, set holder to null and dueDate to null (private member variables from the library book class)
          library.get(i).checkIn();
          numCheckedIn++;

        }
      }
      if( numCheckedIn > 0){
        return true;
      }
      return false;
    }
  }

