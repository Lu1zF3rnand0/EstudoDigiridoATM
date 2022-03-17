package view;

/**
 * Screen.java
 *Represents the screen of the ATM
 */
public class Screen
{
 /**
  * Displays a message without a carriage return
  * @param message the message
  */
 public void displayMessage( String message )
 {
  System.out.print( message );
 } // end method displayMessage

 /**
  * Display a message with a carriage return
  * @param message the message
  */
 public void displayMessageLine( String message )
 {
  System.out.println( message );
 } // end method displayMessageLine

 /**
  * Display a dollar amount
  * @param amount the amount
  */
 public void displayDollarAmount( double amount )
 {
  System.out.printf( "$%,.2f", amount );
 } // end method displayDollarAmount
} // end class Screen