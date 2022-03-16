package view;

//CashDispenser.java
// Representa o dispensador de c�dulas do ATM

public class CashDispenser {
	// o n�mero inicial padr�o de c�dulas no dispensador de c�dulas
	private final static int INITIAL_COUNT = 500;
	private int count; // n�mero de c�dulas de US$ 20 remanescente

	// construtor sem argumento CashDispenser inicializa a count para o padr�o
	public CashDispenser() {
		count = INITIAL_COUNT; // configura atributo count como o padr�o
	} // fim do construtor CashDispenser

	// simula a entrega da quantia especificada de c�dulas
	public void dispenseCash(int amount) {
		int billsRequired = amount / 20; // n�mero de c�dulas de US$ 20 requerido
		count -= billsRequired; // atualiza a contagem das c�dulas
	} // fim do m�todo dispenseCash

	// indica se o dispensador de c�dulas pode entregar a quantia desejada
	public boolean isSufficientCashAvailable(int amount) {
		int billsRequired = amount / 20; // n�mero de c�dulas de US$ 20 requerido

		if (count >= billsRequired)
			return true; // h� c�dulas suficientes dispon�veis
		else
			return false; // n�o h� c�dulas suficientes dispon�veis
	} // fim do m�todo isSufficientCashAvailable
} // fim da classe CashDispenser
