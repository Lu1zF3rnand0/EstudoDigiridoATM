package view;

public class Screen
 {
 // exibe uma mensagem sem retorno de carro
public void displayMessage( String message )
 {
 System.out.print( message );
 } // fim do método displayMessage

 // exibe uma mensagem com um retorno de carro
 public void displayMessageLine( String message )
 {
 System.out.println( message );
 } // fim do método displayMessageLine

 // exibe um valor em dólares
 public void displayDollarAmount( double amount )
 {
 System.out.printf( "$%,.2f", amount );
 } // fim do método displayDollarAmount
 } // fim da classe Screen