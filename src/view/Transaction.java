package view;

public abstract class Transaction {
	private int accountNumber; // indica conta envolvida
	private Screen screen; // Tela do ATM
	private BankDatabase bankDatabase; // banco de dados de informa��es sobre a conta

	// Construtor de Transaction invocado pelas subclasses utilizando super()
	public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankDatabase = atmBankDatabase;
	} // fim do construtor de Transaction

	// retorna o n�mero da conta
	public int getAccountNumber() {
		return accountNumber;
	} // fim do m�todo getAccountNumber

	// retorna a refer�ncia � tela
	public Screen getScreen() {
		return screen;
	} // fim do m�todo getScreen

	// retorno a refer�ncia ao banco de dados da institui��o financeira
	public BankDatabase getBankDatabase() {
		return bankDatabase;
	} // fim do m�todo getBankDatabase

	// realiza a transa��o (sobrescrita por cada subclasse)
	abstract public void execute();
} // fim da classe Transaction