package view;


/**
 * DepositSlot.java
 * Represents the deposit slot of the ATM
 */
public class DepositSlot
{
	/**
	 * Indicates whether envelope was received (always returns true,
	 * because this is only a software simulation of a real deposit slot)
	 * @return true, if is envelope received
	 */
	public boolean isEnvelopeReceived() {
		return true; // deposit envelope was received
	} // end method isEnvelopeReceived
} // end class DepositSlot