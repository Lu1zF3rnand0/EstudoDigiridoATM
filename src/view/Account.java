package view;

/**
 * Account.java
 * Represents a bank account
 */
public class Account
{
	/** The account number. */
	private final int accountNumber; // account number
	/** The pin. */
	private final int pin; // PIN for authentication
	/** The available balance. */
	private double availableBalance; // funds available for withdrawal
	/** The total balance. */
	private double totalBalance; // funds available + pending deposits

	/**
	 * Account constructor initializes attributes
	 * @param theAccountNumber the account number
	 * @param thePIN the PIN
	 * @param theAvailableBalance the available balance
	 * @param theTotalBalance total balance
	 */
	public Account( int theAccountNumber, int thePIN,
					double theAvailableBalance, double theTotalBalance )
	{
		accountNumber = theAccountNumber;
		pin = thePIN;
		availableBalance = theAvailableBalance;
		totalBalance = theTotalBalance;
	} // end Account constructor

	/**
	 * determines whether a user-specified PIN matches PIN in Account
	 * @param userPIN the user PIN
	 * @return true, if successful
	 */
	public boolean validatePIN( int userPIN )
	{
		return userPIN == pin;
	} // end method validatePIN

	/**
	 * Gets the available balance.
	 * @return the available balance
	 */
	public double getAvailableBalance()
	{
		return availableBalance;
	} // end getAvailableBalance

	/**
	 * Gets the total balance.
	 *
	 * @return the total balance
	 */
	public double getTotalBalance()
	{
		return totalBalance;
	} // end method getTotalBalance

	/**
	 *  credits an amount to the account
	 * @param amount the amount
	 */
	public void credit( double amount )
	{
		totalBalance += amount; // add to total balance
	} // end method credit

	/**
	 * debit an amount to the account
	 *
	 * @param amount the amount
	 */
	public void debit( double amount )
	{
		availableBalance -= amount; // subtract from available balance
		totalBalance -= amount; // subtract from total balance
	} // end method debit

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public int getAccountNumber()
	{
		return accountNumber;
	} // end method getAccountNumber
} // end class Account
