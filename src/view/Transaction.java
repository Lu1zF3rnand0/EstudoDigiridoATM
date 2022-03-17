package view;

/**
 * Transaction.java
 * Abstract superclass Transaction represents an ATM transaction
 */
public abstract class Transaction
{
	private final int accountNumber; // indicates account involved
	private final Screen screen; // ATM's screen
	private final BankDatabase bankDatabase; // account info database

	/**
	 * Transaction constructor invoked by subclasses using super()
	 * @param userAccountNumber the user account number
	 * @param atmScreen atm screen
	 * @param atmBankDatabase the atm bank database
	 */
	public Transaction( int userAccountNumber, Screen atmScreen,
						BankDatabase atmBankDatabase )
	{
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankDatabase = atmBankDatabase;
	} // end Transaction constructor

	/**
	 * return account number
	 * @return account number
	 */
	public int getAccountNumber(){
		return accountNumber;
	} // end method getAccountNumber


	/**
	 * Return reference to screen
	 * @return the screen
	 */
	public Screen getScreen() {
		return screen;
	} // end method getScreen

	/**
	 * Return reference to bank database
	 * @return the bank database
	 */
	public BankDatabase getBankDatabase()
	{
		return bankDatabase;
	} // end method getBankDatabase

	/**
	 * Perform the transaction (overridden by each subclass)
	 */
	abstract public void execute();
} // end class Transaction
