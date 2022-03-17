package view;

import java.util.Objects;

/**
 * BankDatabase.java
 * Represents the bank account information database
 * @author Luiz
 */
public class BankDatabase
{
	private final Account[] accounts; // array of Accounts

	/**
	 * No-argument BankDatabase constructor initializes accounts
	 */
	public BankDatabase()
	{
		accounts = new Account[ 2 ]; // just 2 accounts for testing
		accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0 );
		accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0 );
	} // end no-argument BankDatabase constructor

	/**
	 * retrieve Account object containing specified account number
	 * @param accountNumber the account number
	 * @return the account
	 */
	private Account getAccount( int accountNumber )
	{
		// loop through accounts searching for matching account number
		for ( Account currentAccount : accounts )
		{
			// return current account if match found
			if ( currentAccount.getAccountNumber() == accountNumber )
				return currentAccount;
		} // end for

		return null; // if no matching account was found, return null
	} // end method getAccount

	/**
	 * Determine whether user-specified account number and PIN
	 * match those of an account in the database
	 * @param userAccountNumber the user account number
	 * @param userPIN the user PIN
	 * @return true, if successful
	 */
	public boolean authenticateUser( int userAccountNumber, int userPIN )
	{
		// attempt to retrieve the account with the account number
		Account userAccount = getAccount( userAccountNumber );

		// if account exists, return result of Account method validatePIN
		if ( userAccount != null )
			return userAccount.validatePIN( userPIN );
		else
			return false; // account number not found, so return false
	} // end method authenticateUser

	/**
	 * Return available balance of Account with specified account number
	 * @param userAccountNumber the user account number
	 * @return the available balance
	 */
	public double getAvailableBalance( int userAccountNumber )
	{
		return Objects.requireNonNull(getAccount(userAccountNumber)).getAvailableBalance();
	} // end method getAvailableBalance

	/**
	 * Gets the total balance.
	 * return total balance of Account with specified account number
	 * @param userAccountNumber the user account number
	 * @return the total balance
	 */
	public double getTotalBalance( int userAccountNumber )
	{
		return Objects.requireNonNull(getAccount(userAccountNumber)).getTotalBalance();
	} // end method getTotalBalance

	/**
	 * Credit an amount to Account with specified account number
	 * @param userAccountNumber the user account number
	 * @param amount amount the amount
	 */
	public void credit( int userAccountNumber, double amount )
	{
		Objects.requireNonNull(getAccount(userAccountNumber)).credit( amount );
	} // end method credit

	/**
	 * Debit an amount from Account with specified account number
	 * @param userAccountNumber the user account number
	 * @param amount the amount
	 */
	public void debit( int userAccountNumber, double amount )
	{
		Objects.requireNonNull(getAccount(userAccountNumber)).debit( amount );
	} // end method debit
} // end class BankDatabase