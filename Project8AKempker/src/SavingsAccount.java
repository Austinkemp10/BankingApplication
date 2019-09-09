/*Folder/Project Name	: Project8
 * Programmer Name		: Austin Kempker
 * Date					: 05/28/17
 * Class Name			: SavingsAccount
 * Project Description	: This class uses the Account abstract class as a template to create this class
 * 							which has more detailed functionality of the basic Account class. In this 
 * 							class I calculate the creation, depositing, and withdrawing of savings accounts.
  */
public class SavingsAccount extends Account
{
	//Here we initialize the constants needed for this sub-class
	protected final float DEFAULT_DEPOSIT_FLOAT = 500.00f, WITHDRAW_CHARGE_FLOAT = 2.50f, MAX_FREE_WITHDRAW_FLOAT = 2000.00f;
	
	/***************************************************************************************************
	 * Here we will create the constructors that allow the presentation class to access this class to create
	 * an object that will  be stored as a SavingsAccount in the account list.
	 ***************************************************************************************************/
	public SavingsAccount()
	{
		//This is the default Constructor
	}
	public SavingsAccount(String firstNameNewString, String lastNameNewString, String pinNewString, int accountTypeNewInteger)
	{
		//This constructor handles creating a new account
		setFirstName(firstNameNewString);
		setLastName(lastNameNewString);
		setPin(pinNewString);
		setAccountType(accountTypeNewInteger);
		setInitialBalance();
	}
	
	//Create a setInitialBalance method to set the default balance for savings accounts by overriding the method in the abstract class
	@Override
	protected void setInitialBalance()
	{
		balanceFloat = DEFAULT_DEPOSIT_FLOAT;
	}
	
	//Create a setChargeValue method to set the value that will cause a charge
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
