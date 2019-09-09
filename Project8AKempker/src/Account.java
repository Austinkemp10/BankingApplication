/*Folder/Project Name	: Project8
 * Programmer Name		: Austin Kempker
 * Date					: 05/28/17
 * Class Name			: Account
 * Project Description	: This class will be an abstract class that sets the necessary components that will
 * 							be required to be built upon in subclasses CheckingAccount and SavingsAccount.
  */
public abstract class Account 
{
	/************************************************************************************************
	 * Make the protected variables that will be inherited in the subclasses and further used there to
	 * make calculations and store in the object. 
	 ************************************************************************************************/
	protected String firstNameString, lastNameString, pinString;
	protected int accountTypeInteger;
	protected float balanceFloat, amountFloat, chargeFloat;
	protected boolean overchargeBoolean;
	
	//Create an abstract method that will need to be used in both sub-classes to deposit funds
	public abstract void setDeposit(float amountNewFloat);
	
	//Create an abstract method that will need to be used in both sub-classes to withdraw funds 
	public abstract void setWithDraw(float amountNewFloat);
	
	//Create an abstract method that will need to be used in both sub-classes to deposit default amount
	protected abstract void setInitialBalance();
	
	//Create an abstract method that will need to be used in both sub-classes to set the charge of a withdraw
	protected abstract void setWithdrawCharge();
	
	//Create an abstract method that will need to be used in both sub-classes to set the value of the charge
	protected abstract boolean withdrawAmountStatus();
	
	//Create an abstract method that will need to be used in both sub-classes to get if an account is overdrawn
	protected abstract boolean overdrawnStatus();
	
	/***************************************************************************************************
	 * Create set methods that will set the public variables coming in as input to protected variables
	 ***************************************************************************************************/
	protected void setFirstName(String firstNameNewString)
	{
		//This method sets the input for first name to protected
		firstNameString = firstNameNewString;
	}
	
	protected void setLastName(String lastNameNewString)
	{
		//This method sets the input for last name to protected
		lastNameString = lastNameNewString;
	}
	
	protected void setPin(String pinNewString)
	{
		//This method sets the input for pin to protected
		pinString = pinNewString;
	}
	
	protected void setAccountType(int accountTypeNewInteger)
	{
		//This method sets the input for account type to protected
		accountTypeInteger = accountTypeNewInteger;
	}
	
	protected void setAmount(float amountNewFloat)
	{
		amountFloat = amountNewFloat;
	}

	
	/***************************************************************************************************
	 * Here we will create get methods for the protected variables so that the public(presentation) class
	 * can have access to them after they have been stored or modified. 
	 ***************************************************************************************************/
	
	public String getFirstName()
	{
		//This method allows the presentation class to retrieve the value for first name
		return firstNameString;
	}
	
	public String getLastName()
	{
		//This method allows the presentation class to retrieve the value for last name
		return lastNameString;
	}
	
	public String getPin()
	{
		//This method allows the presentation class to retrieve the value for pin
		return pinString;
	}
	
	public int getAccountType()
	{
		//This method allows the presentation class to retrieve the value for account type
		return accountTypeInteger;
	}
	
	public float getBalance()
	{
		//This method allows the presentation class to retrieve the value for balance
		return balanceFloat;
	}
	
	public float getAmount()
	{
		//This method allows the presentation class to retrieve the value for amount
		return amountFloat;
	}
	
	public float getCharge()
	{
		//This method allows the presentation class to retrieve the value for a charge to the transaction
		return chargeFloat;
	}
	
	public boolean isChargeValue()
	{
		//This method allows the presentation class to retrieve the value for if a charge will be processed
		return withdrawAmountStatus();
	}
	
	public boolean isOverdrawn()
	{
		//This method allows the presentation class to retrieve the value for if an account is overdrawn
		return overdrawnStatus();
	}
}
