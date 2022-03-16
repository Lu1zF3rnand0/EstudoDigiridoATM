package view;

import java.util.Scanner;

public class Keypad
 {
 private Scanner input; // l� os dados na linha de comando

 // o construtor sem argumento inicializa a classe Scanner
 public Keypad()
 {
 input = new Scanner( System.in );
 } // fim do construtor Keypad sem argumentos

 // retorna um valor inteiro inserido pelo usu�rio
 public int getInput()
 {
 return input.nextInt(); // supomos que o usu�rio insira um inteiro
 } // fim do m�todo getInput
 } // fim da classe Keypad