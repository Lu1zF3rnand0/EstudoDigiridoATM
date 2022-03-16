package view;

//BalanceInquiry.java
//Representa uma transa��o de consulta de saldos no ATM

public class BalanceInquiry extends Transaction {
	// Construtor de BalanceInquiry
	public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
	} // fim do construtor de BalanceInquiry

	// realiza a transa��o
	public void execute() {
		// obt�m as refer�ncias ao banco de dados e tela do banco
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();

		// obt�m o saldo dispon�vel da conta envolvida
		double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

		// obt�m o saldo total da conta envolvida
		double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

		// exibe as informa��es sobre o saldo na tela
		screen.displayMessageLine("\nBalance Information:");
		screen.displayMessage(" - Available balance: ");
		screen.displayDollarAmount(availableBalance);
		screen.displayMessage("\n - Total balance: ");
		screen.displayDollarAmount(totalBalance);
		screen.displayMessageLine("");
	} // fim do m�todo execute
} // fim da classe BalanceInquiry
