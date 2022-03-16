package view;

//Withdrawal.java
// Representa uma transa��o de saque no ATM

public class Withdrawal extends Transaction {
	private int amount; // quantia a sacar
	private Keypad keypad; // refer�ncia ao teclado num�rico
	private CashDispenser cashDispenser; // refer�ncia ao dispensador de c�dulas

	// constante que corresponde � op��o cancelar no menu
	private final static int CANCELED = 6;

	// Construtor de Withdrawal
	public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad,
			CashDispenser atmCashDispenser) {
		// inicializa as vari�veis da superclasse
		super(userAccountNumber, atmScreen, atmBankDatabase);

		// inicializa as refer�ncias ao teclado num�rico e ao dispensador de c�dulas
		keypad = atmKeypad;
		cashDispenser = atmCashDispenser;
	} // fim do construtor de Withdrawal

	// realiza a transa��o
	public void execute() {
		boolean cashDispensed = false; // c�dulas ainda n�o foram entregues
		double availableBalance; // quantia dispon�vel para saque

		// obt�m as refer�ncias ao banco de dados e tela do banco
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();

		// faz um loop at� as c�dulas serem entregues ou o usu�rio cancelar
		do {
			// obt�m a quantia de um saque escolhida pelo usu�rio
			amount = displayMenuOfAmounts();

			// verifica se o usu�rio escolheu uma quantia de saque ou cancelou
			if (amount != CANCELED) {
				// obt�m o saldo dispon�vel na conta envolvida
				availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

				// verifica se o usu�rio tem dinheiro suficiente na conta
				if (amount <= availableBalance) {
					// verifica se o dispensador de c�dulas tem c�dulas suficientes
					if (cashDispenser.isSufficientCashAvailable(amount)) {
						// atualiza a conta envolvida para refletir a retirada/saque
						bankDatabase.debit(getAccountNumber(), amount);

						cashDispenser.dispenseCash(amount); // entrega c�dulas
						cashDispensed = true; // c�dulas foram entregues

						// instrui o usu�rio a pegar as c�dulas
						screen.displayMessageLine("\nYour cash has been" + " dispensed. Please take your cash now.");
					} // fim do if
					else // o dispensador de c�dulas n�o tem c�dulas suficientes
						screen.displayMessageLine(
								"\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller amount.");
				} // fim do if
				else // n�o h� dinheiro suficiente dispon�vel na conta do usu�rio
				{
					screen.displayMessageLine(
							"\nInsufficient funds in your account." + "\n\nPlease choose a smaller amount.");
				} // fim de else
			} // fim do if
			else // o usu�rio escolheu a op��o cancelar no menu
			{
				screen.displayMessageLine("\nCanceling transaction...");
				return; // retorna ao menu principal porque o usu�rio cancelou
			} // fim de else
		} while (!cashDispensed);

	} // fim do m�todo execute

	// exibe um menu de quantias de saques e a op��o para cancelar;
	// retorna a quantia escolhida ou 0 se o usu�rio escolher cancelar
	private int displayMenuOfAmounts() {
		int userChoice = 0; // vari�vel local para armazenar o valor de retorno

		Screen screen = getScreen(); // obt�m refer�ncia de tela

		// array de quantias que correspondem aos n�meros no menu
		int amounts[] = { 0, 20, 40, 60, 100, 200 };

		// faz um loop enquanto nenhuma escolha v�lida for feita
		while (userChoice == 0) {
			// exibe o menu
			screen.displayMessageLine("\nWithdrawal Menu:");
			screen.displayMessageLine("1 - $20");
			screen.displayMessageLine("2 - $40");
			screen.displayMessageLine("3 - $60");
			screen.displayMessageLine("4 - $100");
			screen.displayMessageLine("5 - $200");
			screen.displayMessageLine("6 - Cancel transaction");
			screen.displayMessage("\nChoose a withdrawal amount: ");

			int input = keypad.getInput(); // obt�m a entrada do usu�rio pelo teclado

			// determina como prosseguir com base no valor de entrada
			switch (input) {
			case 1: // se o usu�rio escolheu uma quantia de saque
			case 2: // (isto �, escolheu a op��o 1, 2, 3, 4 ou 5), retorna a
			case 3: // quantia correspondente do array de quantias
			case 4:
			case 5:
				userChoice = amounts[input]; // salva a escolha do usu�rio
				break;
			case CANCELED: // o usu�rio escolheu cancelar
				userChoice = CANCELED; // salva a escolha do usu�rio
				break;
			default: // o usu�rio n�o inseriu um valor ente1e6
				screen.displayMessageLine("\nInvalid selection. Try again.");
			} // fim de switch
		} // fim do while

		return userChoice; // retorna a quantia de saque ou CANCELADA
	} // fim do m�todo displayMenuOfAmounts
} // fim da classe Withdrawal
