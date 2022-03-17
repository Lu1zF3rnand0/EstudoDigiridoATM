package view;

/**
 *  CashDispenser.java
 *  Represents the cash dispenser of the ATM
 */
public class CashDispenser
{
	/**
	 * The default initial number of bills in the cash dispenser
	 */
	private final static int INITIAL_COUNT = 500;

	/** The count. */
	private int count; // number of $20 bills remaining

	/**
	 * No-argument CashDispenser constructor initializes count to default
	 */
	public CashDispenser()
	{
		count = INITIAL_COUNT; // set count attribute to default
	} // end CashDispenser constructor

	/**
	 * simulates dispensing of specified amount of cash
	 * @param amount the amount
	 */
	public void dispenseCash( int amount )
	{
		int billsRequired = amount / 20; // number of $20 bills required
		count -= billsRequired; // update the count of bills
	} // end method dispenseCash

	/**
	 * Indicates whether cash dispenser can dispense desired amount
	 * @param amount the amount
	 * @return true, if is sufficient cash available
	 */
	public boolean isSufficientCashAvailable( int amount )
	{
		int billsRequired = amount / 20; // number of $20 bills required
		return (count >= billsRequired);

	} // end method isSufficientCashAvailable
} // end class CashDispenser
