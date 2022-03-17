package view;

/**
 * The Class ATM.
 */
public class ATM {

	/** The user authenticated. */
	private boolean userAuthenticated; // se usuário foi autenticado

	/** The current account number. */
	private int currentAccountNumber; // número atual da conta de usuário

	/** The screen. */
	private final Screen screen; // Tela do ATM

	/** The keypad. */
	private final Keypad keypad; // Teclado do ATM

	/** The cash dispenser. */
	private final CashDispenser cashDispenser; // dispensador de cédulas do ATM

	/** The deposit slot. */
	private final DepositSlot depositSlot; // Abertura para depósito do ATM

	/** The bank database. */
	private final BankDatabase bankDatabase; // banco de dados de informações de contas

	/** The Constant BALANCE_INQUIRY. */
	// constantes que correspondem às principais opções de menu
	private static final int BALANCE_INQUIRY = 1;

	/** The Constant WITHDRAWAL. */
	private static final int WITHDRAWAL = 2;

	/** The Constant DEPOSIT. */
	private static final int DEPOSIT = 3;

	/** The Constant EXIT. */
	private static final int EXIT = 4;

	/**
	 * Instantiates a new atm.
	 */
	public ATM() {
		userAuthenticated = false; // usuário não foi autenticado para iniciar
		currentAccountNumber = 0; // nenhum número atual de conta para iniciar
		screen = new Screen(); // cria a tela
		keypad = new Keypad(); // cria o teclado numérico
		cashDispenser = new CashDispenser(); // cria o dispensador de cédulas
		depositSlot = new DepositSlot(); // cria a abertura para depósito
		bankDatabase = new BankDatabase(); // cria o banco de dados de informações de contas
	} // fim do construtor ATM sem argumento

	/**
	 * Run.
	 */
	public void run() {
		// dá boas-vindas e autentica o usuário; realiza transações
		while (true) {
			// faz um loop enquanto o usuário ainda não está autenticado
			while (!userAuthenticated) {
				screen.displayMessageLine("\nWelcome!");
				authenticateUser(); // autentica o usuário
			} // fim do while

			performTransactions(); // o usuário agora está autenticado
			userAuthenticated = false; // reinicializa antes da próxima sessão do ATM
			currentAccountNumber = 0; // reinicializa antes da próxima sessão do ATM
			screen.displayMessageLine("\nThank you! Goodbye!");
		} // fim do while
	} // fim do método run

	/**
	 * Authenticate user.
	 */
	private void authenticateUser() {
		screen.displayMessage("\nPlease enter your account number: ");
		int accountNumber = keypad.getInput(); // insere o número de conta
		screen.displayMessage("\nEnter your PIN: "); // solicita o PIN
		int pin = keypad.getInput(); // insere o PIN

		// configura userAuthenticated como um valor booleano retornado pelo banco de
		// dados
		userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

		// verifica se a autenticação foi bem-sucedida
		if (userAuthenticated) {
			currentAccountNumber = accountNumber; // salva a conta do usuário #
		} // fim do if
		else
			screen.displayMessageLine("Invalid account number or PIN. Please try again.");
	} // fim do método authenticateUser

	/**
	 * Perform transactions.
	 */
	private void performTransactions() {
		// variável local para armazenar a transação atualmente processada
		Transaction currentTransaction;

		boolean userExited = false; // usuário optou por não sair

		// faz um loop enquanto o usuário não escolher a opção para sair do sistema
		while (!userExited) {
		// mostra o menu principal e obtém a seleção de usuário
			int mainMenuSelection = displayMainMenu();

			// decide como prosseguir com base na seleção de menu feita pelo usuário
			switch (mainMenuSelection) {
				// o usuário optou por realizar um entre três tipos de transações
				case BALANCE_INQUIRY:
				case WITHDRAWAL:
				case DEPOSIT:

					// inicializa como o novo objeto do tipo escolhido
					currentTransaction = createTransaction(mainMenuSelection);

					currentTransaction.execute(); // executa a transação
					break;
				case EXIT: // usuário optou por terminar a sessão
					screen.displayMessageLine("\nExiting the system...");
					userExited = true; // essa sessão de ATM deve terminar
					break;
				default: // usuário não inseriu um inteiro de1a4
					screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
					break;
			} // fim de switch
		} // fim do while
	} // fim do método performTransactions

	/**
	 * Display main menu.
	 * @return the int
	 */
	private int displayMainMenu() {
		screen.displayMessageLine("\nMain menu:");
		screen.displayMessageLine("1 - View my balance");
		screen.displayMessageLine("2 - Withdraw cash");
		screen.displayMessageLine("3 - Deposit funds");
		screen.displayMessageLine("4 - Exit\n");
		screen.displayMessage("Enter a choice: ");
		return keypad.getInput(); // retorna a seleção do usuário
	} // fim do método displayMainMenu

	/**
	 * Creates the transaction.
	 * @param type the type
	 * @return the transaction
	 */
	private Transaction createTransaction(int type) {
		Transaction temp = null; // variável Transaction temporária

		// determina qual tipo de Transaction criar
		switch (type) {
			case BALANCE_INQUIRY: // cria uma nova transação BalanceInquiry
				temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
				break;
			case WITHDRAWAL: // cria uma nova transação Withdrawal
				temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
				break;
			case DEPOSIT: // cria uma nova transação Deposit
				temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
				break;
		} // fim de switch

		return temp; // retorna o objeto recém-criado
	} // fim do método createTransaction
} // fim da classe ATM


