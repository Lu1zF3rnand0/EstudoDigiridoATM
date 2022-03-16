package view;

public class Screen
 {
 // exibe uma mensagem sem retorno de carro
public void displayMessage( String message )
 {
 System.out.print( message );
 } // fim do m�todo displayMessage

 // exibe uma mensagem com um retorno de carro
 public void displayMessageLine( String message )
 {
 System.out.println( message );
 } // fim do m�todo displayMessageLine

 // exibe um valor em d�lares
 public void displayDollarAmount( double amount )
 {
 System.out.printf( "$%,.2f", amount );
 } // fim do m�todo displayDollarAmount
 } // fim da classe Screen