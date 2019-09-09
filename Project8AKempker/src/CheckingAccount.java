/*Folder/Project Name	: Project8
 * Programmer Name		: Austin Kempker
 * Date					: 05/28/17
 * Class Name			: CheckingAccount
 * Project Description	: This class uses the Account abstract class as a template to create this class
 * 							which has more detailed functionality of the basic Account class. In this 
 * 							class I calculate the creation, depositing, and withdrawing of checking accounts.
  */
public class CheckingAccount extends Account
{
	//Here we initialize the constants needed for this sub-class
	protected final float DEFAULT_DEPOSIT_FLOAT = 100.00f, WITHDRAW_CHARGE_FLOAT = 2.00f, MAX_FREE_WITHDRAW_FLOAT = 750.00f;
	
	/***************************************************************************************************
	 * Here we will create the constructors that the presentation class will access to store information
	 * that is received through input.
	 ***************************************************************************************************/
	public CheckingAccount()
	{
		//This is the default constructor
	}
	public CheckingAccount(String firstNameNewString, String lastNameNewString, String pinNewString, int accountTypeNewInteger) 
	{
		//This constructor handles creating a new account 
		setFirstName(firstNameNewString);
		setLastName(lastNameNewString);
		setPin(pinNewString);
		setAccountType(accountTypeNewInteger);
		setInitialBalance();
	}
	
	//Create a setInitialBalance method to set the default balance for checking accounts by overriding the method in the abstract class
	@Override
	protected void setInitialBalance()
	{
		balanceFloat = DEFAULT_DEPOSIT_FLOAT;
	}
	
	//Create a setChargeValue method to set the
	@Override
	protected boolean withdrawAmountStatus() 
	{
		if(amountFloat >= MAX_FREE_WITHDRAW_FLOAT)
		{
			chargeFloat = WITHDRAW_CHARGE_FLOAT;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	protected boolean overdrawnStatus() 
	{
		//Check if an account has tried to withdraw more than is available and return this information
		if(amountFloat > balanceFloat)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	protected void setWithdrawCharge() 
	{
		//Adding the charge to the amount to deduct
		amountFloat += WITHDRAW_CHARGE_FLOAT;
	}
	
	//Create the public method to be called in the presentation class that will withdraw from the users funds
	@Override
	public void setDeposit(float amountNewFloat)
	{
		setAmount(amountNewFloat);
		balanceFloat += amountFloat;
	}
	
	//Create the public method to be called in the presentation class that will withdraw from the users funds
	@Override
	public void setWithDraw(float amountNewFloat)
	{
		setAmount(amountNewFloat);
		if(withdrawAmountStatus())
		{
			setWithdrawCharge();
			balanceFloat -= amountFloat;
		}
		else
		{
			balanceFloat -= amountFloat;
		}
	}

}
