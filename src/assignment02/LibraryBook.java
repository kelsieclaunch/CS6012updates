package assignment02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryBook extends Book {
    private String holder;
    private GregorianCalendar dueDate;
    private boolean checkedIn;

    public boolean isItCheckedIn() { //boolean to return the status of the book (whether or not it's checked in) for the checkout and checkin functions in the library class
        return checkedIn;
    }

    public LibraryBook(long isbn, String author, String title) {
        super(isbn, author, title); //references the book class
        holder = null; //when the constructor is first called, there is no holder or due date and the book is not checked out
        checkedIn = true;
        dueDate = null;

    }

    public String getHolder(){
        return holder; //returns the holder
    }

    public GregorianCalendar getDueDate(){
        return dueDate; // returns the dueDate

    }

    public void checkout (String newHolder, int day, int month, int year){
        if (checkedIn == false){ //if the book is already out, don't let them check it out
            System.out.println("This book is already checked out");
        }
        else {
            holder = newHolder; // assign the holder
            checkedIn = false; //book is no longer checkedIn
            dueDate = new GregorianCalendar(year, month, day); //assign the dueDate from the parameter
        }

    }

    public void checkIn(){
        if(checkedIn){ // if the book is already checked in, there's no reason to check it out again
            System.out.println("This item is not currently checked out");
        }
        else { // if it isn't already checked in, check it in by setting the holder and due date to null and setting checkedIn to true
            holder = null;
            checkedIn = true;
            dueDate = null;
        }
    }

}
