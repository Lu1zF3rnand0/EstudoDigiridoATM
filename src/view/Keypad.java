package view;

import java.util.Scanner; // program uses Scanner to obtain user input
import java.util.InputMismatchException;


/**
 * Keypad.java
 * Represents the keypad of the ATM
 */

public class Keypad
{
 /** The input. */
 private final Scanner input; // reads data from the command line

 /**
  * No-argument constructor initializes the Scanner
  */
 public Keypad()
 {
  input = new Scanner( System.in );
 } // end no-argument Keypad constructor

 /**
  * Return an integer value entered by user
  * @return the input
  */
 public int getInput() throws InputMismatchException
 {
  try{
   return input.nextInt(); // we assume that user enters an integer
  }
  catch (InputMismatchException inputMismatchException){
   //System.err.printf("\nException: %s\n", inputMismatchException);
   input.nextLine();// descarta a entrada para o usu?rio poder entrar novamente.
   System.out.println("Voc? deve digitar apenas n?meros!\n Por favor, tente novamente.\n");
  }

  return 0;

 } // end method getInput
} // end class Keypad

