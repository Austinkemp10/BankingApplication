
/*Folder/Project Name	: Project8
 * Programmer Name		: 
 * Date					:
 * Class Name			: BankingApplication
 * Project Description	: 
  */


import java.awt.event.*;   	//for ActionListener
import javax.swing.*;		//for swing components
import java.awt.*;			//for Font
import java.text.*;			//for DecimalFormat class

public class BankingApplication extends JFrame 
	implements ActionListener
{
		
	//added components for first panel	
	//Array for the combo box
	String choiceString [] = {"Create Account","Withdraw or Deposit","Show all Accounts"};	
	JLabel companyLabel = new JLabel ("  Friendly Neighborhood Bank   ");
	JLabel selectLabel = new JLabel ("Please Select an Action: ");
	JComboBox selectComboBox = new JComboBox(choiceString);
	JButton goButton = new JButton("Go");
	JLabel programmerNameLabel = new JLabel ("programmed by Austin Kempker");
	
	//added components for second panel	
	JLabel companyLabel2 = new JLabel ("     Friendly Neighborhood Bank      ");
	JLabel firstNameLabel = new JLabel ("First name ");
	JTextField firstNameTextField = new JTextField(10);
	JLabel lastNameLabel = new JLabel ("Last name ");
	JTextField lastNameTextField = new JTextField(10);
	JLabel newPinLabel = new JLabel ("         PIN ");
	JTextField newPinTextField = new JTextField(10);
	String typeAccountString [] = {"Accounts", "Checking", "Savings"};
	JComboBox typeAccountComboBox = new JComboBox(typeAccountString);
	JButton processNewAccountButton = new JButton("Process");
	JButton backFromNewAccountButton = new JButton("Back");
	JTextArea accountOutputTextArea = new JTextArea(10,20);
	
	//added components for third panel	
	JLabel companyLabel3 = new JLabel ("       Friendly Neighborhood Bank        ");
	JRadioButton withdrawRadioButton = new JRadioButton("    Withdraw                                                          ");
	JRadioButton depositRadioButton = new JRadioButton("     Deposit                                       ");
	JRadioButton invisibleRadioButton = new JRadioButton("");
	ButtonGroup transactionButtonGroup = new ButtonGroup();
	JLabel confirmPinLabel = new JLabel("                     PIN:      ");
	JTextField confirmPinTextField = new JTextField(25);
	JLabel amountLabel = new JLabel("                  Enter amount:          ");
	JLabel fillLabel = new JLabel("                       ");
	JTextField amountTextField = new JTextField(25);
	JButton processTransactionButton = new JButton("Process");
	JButton backFromTransactionButton = new JButton("Back");
	JTextArea transactionOutputTextArea = new JTextArea(10,15);
	
	//Added JTextArea for displaying all accounts
	JTextArea displayAllTextArea = new JTextArea(10, 42);
		
	JPanel mainPanel = new JPanel();
	JPanel accountPanel = new JPanel();
	JPanel transactionPanel = new JPanel();
	Font taFont = new Font("Courier", Font.PLAIN, 12);
	Font companyFont = new Font ("Sans Serif", Font.BOLD, 20);
	Font programmerNameFont = new Font ("Sans Serif", Font.ITALIC, 10);
	
	// instance objects and variables
	Account [] myAccount = new Account[10];
	
	int lastAccountInteger = -1;
	final int MAX_ACCOUNTS_INTEGER = 9;
	
	String typeString;
	
	

	// the main method will create an object of itself and 
	//set the default close operation
	public static void main(String[] args)
	{		
		BankingApplication myApplication = new BankingApplication();
		myApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}		
	
	//constructor 
	//call the methods to add components to the multiple panels
	//also sets size and visibility	
	public BankingApplication()
	{		
		designMainPanel();
		designAccountPanel();
		designTransactionPanel();
		addListeners();		
		add(mainPanel);
		setSize(400,200);
		setVisible(true);		
	}	
		
	//this method will create the main panel
	public void designMainPanel()
	{
		//add components to the mainPanel
		companyLabel.setFont(companyFont);
		mainPanel.add(companyLabel);
		mainPanel.add(selectLabel);
		mainPanel.add(selectComboBox);
		mainPanel.add(goButton);
		programmerNameLabel.setFont(programmerNameFont);
		mainPanel.add(programmerNameLabel);		
	}
	
	
	//this method creates the account panel
	public void designAccountPanel()
	{
		//add components to the adminPanel
		accountPanel.setLayout(new FlowLayout(FlowLayout.CENTER,60,15));
		companyLabel2.setFont(companyFont);
		accountPanel.add(companyLabel2);
		accountPanel.add(firstNameLabel);
		accountPanel.add(firstNameTextField);
		accountPanel.add(lastNameLabel);
		accountPanel.add(lastNameTextField);
		accountPanel.add(newPinLabel);
		accountPanel.add(newPinTextField);
		accountPanel.add(new JLabel("Type of Account"));
		accountPanel.add(typeAccountComboBox);
		accountPanel.add(processNewAccountButton);
		accountPanel.add(backFromNewAccountButton);
		accountPanel.add(accountOutputTextArea);
		
		String formattedTitleString = String.format("%-15s%-6s%-15s%-12s%-10s%n",
				"Name","PIN","Account", "Trans Type","Balance");
		accountOutputTextArea.setFont(taFont);
		accountOutputTextArea.setText(formattedTitleString);
	}
	
	
	//this method creates the transaction panel
	public void designTransactionPanel()
	{
		//add the container group to the radio buttons
		transactionButtonGroup.add(depositRadioButton);
		transactionButtonGroup.add(withdrawRadioButton);
		transactionButtonGroup.add(invisibleRadioButton);
		companyLabel3.setFont(companyFont);
		transactionPanel.add(companyLabel3);
		transactionPanel.add(depositRadioButton);
		transactionPanel.add(withdrawRadioButton);
		transactionPanel.add(confirmPinLabel);
		transactionPanel.add(confirmPinTextField);
		transactionPanel.add(amountLabel);
		transactionPanel.add(amountTextField);
		transactionPanel.add(fillLabel);
		transactionPanel.add(processTransactionButton);
		transactionPanel.add(backFromTransactionButton);
		transactionPanel.add(transactionOutputTextArea);
		
		String formattedTitleString = String.format("%-6s%-15s%-15s%-12s%-10s%-10s%-10s%n",
				"PIN","Name","Account Type", "Trans Type", "Trans Amt","Charge","Balance" );
		transactionOutputTextArea.setFont(taFont);
		transactionOutputTextArea.setText(formattedTitleString);
		
	}
	
	//this method puts action listeners on all the desired buttons
	public void addListeners()
	{
		//add the listeners to the respective components 
		selectComboBox.addActionListener(this);
		goButton.addActionListener(this);
		processNewAccountButton.addActionListener(this);
		backFromNewAccountButton.addActionListener(this);
		processTransactionButton.addActionListener(this);
		backFromTransactionButton.addActionListener(this);
		
	}	
		
	//this method assigns the actions and methods to the correct button
	public void actionPerformed(ActionEvent evt)
	{
		//buttons fire this event
		Object sourceObject = evt.getSource();
		
		if (sourceObject == goButton)
		{
			if(selectComboBox.getSelectedIndex() == 0)  //Add an account option
			{
				remove(mainPanel);
				invisibleRadioButton.setSelected(true);
				remove(transactionPanel);
				add(accountPanel);
				setSize(425,600);
				setVisible(true);
			}
			else if (selectComboBox.getSelectedIndex() == 1) //Transaction option
			{
				remove(mainPanel);
				invisibleRadioButton.setSelected(true);
				remove(accountPanel);
				add(transactionPanel);
				setSize(580,400);
				setVisible(true);
			}
			else if(selectComboBox.getSelectedIndex() == 2)  //Display all transactions option
			{				
				displayAllAccountInfo();
			}
			else
				JOptionPane.showMessageDialog(null, "Please make a selection in the combo box before pressing Go.");
		}
		
		if(sourceObject == processNewAccountButton)
		{
			if(validationNewAccountFields())
				processNewAccount();
		}
		else if(sourceObject == processTransactionButton)
		{
			if(validationTransRadioButtons())
				processTransaction();
			else 
				JOptionPane.showMessageDialog(null, "Please select either withdraw or deposit");			
		}
		
		else if(sourceObject == backFromNewAccountButton)
		{
			remove(accountPanel);
			invisibleRadioButton.setSelected(true);
			remove(transactionPanel);
			selectComboBox.setSelectedIndex(-1);
			add(mainPanel);
			setSize(400,300);
			setVisible(true);
			
			//Set the field back to blank
			String formattedTitleString = String.format("%-15s%-6s%-15s%-12s%-10s%n",
					"Name","PIN","Account", "Trans Type","Balance");
			accountOutputTextArea.setFont(taFont);
			accountOutputTextArea.setText(formattedTitleString);
		}
		else if(sourceObject == backFromTransactionButton)
		{
			remove(transactionPanel);
			remove(accountPanel);
			selectComboBox.setSelectedIndex(-1);
			add(mainPanel);
			setSize(400,200);
			setVisible(true);
			//Set the text field back to blank
			String formattedTitleString = String.format("%-6s%-15s%-15s%-12s%-10s%-10s%-10s%n",
					"PIN","Name","Account Type", "Trans Type", "Trans Amt","Charge","Balance" );
			transactionOutputTextArea.setFont(taFont);
			transactionOutputTextArea.setText(formattedTitleString);
		}		
		
	}//end of actionPerformed method
	
	
	//validates if something has been entered into the three text fields 
	public boolean validationNewAccountFields()
	{
	    boolean validationBoolean = false;
	    
	    if(!(firstNameTextField.getText()).equals(""))
	    {
	    	if(!(lastNameTextField.getText()).equals(""))
	    	{
	    		if(!(newPinTextField.getText()).equals(""))
	    		{      		   
	    			validationBoolean = true; 
	    		}
    		   
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Please enter a PIN");
	    			newPinTextField.requestFocus();
	    			validationBoolean = false;
	    		}
	    	}
	    
	    	else
	    	{
	    		JOptionPane.showMessageDialog(null, "Please enter Last Name");
	    		lastNameTextField.requestFocus();
	    		validationBoolean = false;}
			}
	    else
	    {
	    	JOptionPane.showMessageDialog(null, "Please enter First name");
	    	firstNameTextField.requestFocus();
	    	validationBoolean = false;
	    }
	    
	    return validationBoolean;
	
	}
	
	//this method will validate if a radio button was selected
	public boolean validationTransRadioButtons()
	{
		boolean validationBoolean = false;
		
		if(depositRadioButton.isSelected() || withdrawRadioButton.isSelected())
			validationBoolean = true;
		else
			validationBoolean = false;
		return validationBoolean;
	}
	
	//Method that will validate if a pin is already in the list and return where it is in the list
	public int validatePin(String pinString)
	{
		int foundInteger = -1, accountPositionInteger = 0;
		while(foundInteger == -1 && accountPositionInteger <= lastAccountInteger)
		{
			if(pinString.equals(myAccount[accountPositionInteger].getPin()))
			{
				foundInteger = accountPositionInteger;
			}
			else
			{
				accountPositionInteger++;
			}
		}
		return foundInteger;
		
	}
	
	//Method that will clear the fields on the create new account page
	public void clearNewAccountFields()
	{
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		newPinTextField.setText("");
		typeAccountComboBox.setSelectedIndex(0);
		firstNameTextField.requestFocus();
	}
	
	//Method that will clear the fields on the transaction page
	public void clearProcessAccountFields()
	{
		invisibleRadioButton.setSelected(true);
		confirmPinTextField.setText("");
		amountTextField.setText("");
		confirmPinTextField.requestFocus();
	}
	
	//this method will make a new account based on the input the user gives
	public void processNewAccount()
	{
		//This method will take input from the user and create a new account based on that information
		
		//Create variables for all the user input
		String firstNameString = firstNameTextField.getText(), lastNameString = lastNameTextField.getText(), pinString = newPinTextField.getText();
		int accountTypeInteger = typeAccountComboBox.getSelectedIndex();
		
		final String transactionTypeString = "New";
		
		if(lastAccountInteger == MAX_ACCOUNTS_INTEGER)
		{
			JOptionPane.showMessageDialog(null, "No more accounts available at this time");
			clearNewAccountFields();			
		}
		else if(validatePin(pinString) == -1)
		{	
			lastAccountInteger++;
			if(accountTypeInteger == 1)
			{
				myAccount[lastAccountInteger] = new CheckingAccount(firstNameString, lastNameString, pinString, accountTypeInteger);
			}
			else if(accountTypeInteger == 2)
			{
				myAccount[lastAccountInteger] = new SavingsAccount(firstNameString, lastNameString, pinString, accountTypeInteger);
			}
			
			//Get what account type it is from the class
			if(myAccount[lastAccountInteger].getAccountType() == 1)
			{
				typeString = "Checking";
			}
			else if(myAccount[lastAccountInteger].getAccountType() == 2)
			{
				typeString = "Savings";
			}
			
			DecimalFormat currencyFormat = new DecimalFormat("$###0.00");
			String formattedOutputString = String.format("%-15s%-6s%-15s%-12s%-10s%n",
					myAccount[lastAccountInteger].getFirstName() + " " + myAccount[lastAccountInteger].getLastName(),
					myAccount[lastAccountInteger].getPin(), typeString , transactionTypeString ,currencyFormat.format(myAccount[lastAccountInteger].getBalance()));
			accountOutputTextArea.setFont(taFont);
			accountOutputTextArea.append(formattedOutputString);
			clearNewAccountFields();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please try another PIN, that one is taken.");
			newPinTextField.setText("");
			newPinTextField.requestFocus();
		}
		
	}//end of processNewAccount method
	
	//this method checks if the entered pin is correct and then withdraws or deposits depending on the radio button
	public void processTransaction()
	{
		//Create variables for the transaction
		float amountFloat, chargeFloat;
		String pinString = confirmPinTextField.getText(),  outputString, accountString;
		int resultInteger;
		
		if(withdrawRadioButton.isSelected())
		{
			typeString = "Withdraw";
		} else {
			typeString = "Deposit";
		}
		
		if(myAccount[validatePin(pinString)].getAccountType() == 1)
		{
			accountString = "Checking";
		}else{
			accountString = "Savings";
		}
		
		//Create an object for money formatting
		DecimalFormat currencyFormat = new DecimalFormat("$###0.00");
		
		//Check that a correct pin was entered
		if(validatePin(pinString) != -1)
		{
			//Create a try loop to attempt to parse the value entered for amount into a float
			try
			{
				//parse the value in amountTextField to amountFloat
				amountFloat = Float.parseFloat(amountTextField.getText());
				
				//get the transaction that wants to be completed
				if(withdrawRadioButton.isSelected())
				{
					//Check if the amount requested would cause a charge
					if(myAccount[validatePin(pinString)].isChargeValue())
					{
						chargeFloat = myAccount[validatePin(pinString)].getCharge();
						outputString = "This transaction will have a charge of:  " + currencyFormat.format(chargeFloat);
						resultInteger = JOptionPane.showConfirmDialog(null,outputString,
						"Confirmation",JOptionPane.YES_NO_OPTION);
						if(resultInteger == JOptionPane.YES_OPTION)
						{
							if(myAccount[validatePin(pinString)].isOverdrawn())
							{
								JOptionPane.showMessageDialog(null, "Insufficient funds in that account!");
								amountTextField.selectAll();
								amountTextField.requestFocus();
							}
							else
							{
								//call the setwithdraw method to calculate the withdraw
								myAccount[validatePin(pinString)].setWithDraw(amountFloat);
								
								//Format the output 
								
								String formattedTitleString = String.format("%-6s%-15s%-15s%-12s%-10s%-10s%-10s%n",
										myAccount[validatePin(pinString)].getPin(), myAccount[validatePin(pinString)].getFirstName() +
										" " + myAccount[validatePin(pinString)].getLastName(), accountString,
										typeString , currencyFormat.format(myAccount[validatePin(pinString)].getAmount()), currencyFormat.format(myAccount[validatePin(pinString)].getCharge()),
										currencyFormat.format(myAccount[validatePin(pinString)].getBalance()));
								transactionOutputTextArea.setFont(taFont);
								transactionOutputTextArea.append(formattedTitleString);
								clearProcessAccountFields();
							}
						}
						else
						{
							//Send message the to user that it was cancelled and display the transaction
							JOptionPane.showMessageDialog(null, "Your transaction has been cancelled");
							
							String formattedTitleString = String.format("%-6s%-15s%-15s%-12s%-10s%-10s%-10s%n",
									myAccount[validatePin(pinString)].getPin(), myAccount[validatePin(pinString)].getFirstName() +
									" " + myAccount[validatePin(pinString)].getLastName(), accountString,
									typeString , currencyFormat.format(myAccount[validatePin(pinString)].getAmount()), currencyFormat.format(myAccount[validatePin(pinString)].getCharge()),
									currencyFormat.format(myAccount[validatePin(pinString)].getBalance()));
							transactionOutputTextArea.setFont(taFont);
							transactionOutputTextArea.append(formattedTitleString);
							clearProcessAccountFields();
						}
					}
					else
					{
						if(myAccount[validatePin(pinString)].isOverdrawn())
						{
							JOptionPane.showMessageDialog(null, "Insufficient funds in that account!");
							amountTextField.selectAll();
							amountTextField.requestFocus();
						}
						else
						{
							//call the setwithdraw method to calculate the withdraw
							myAccount[validatePin(pinString)].setWithDraw(amountFloat);
							
							//Format the output 
							String formattedTitleString = String.format("%-6s%-15s%-15s%-12s%-10s%-10s%-10s%n",
									myAccount[validatePin(pinString)].getPin(), myAccount[validatePin(pinString)].getFirstName() +
									" " + myAccount[validatePin(pinString)].getLastName(), accountString,
									typeString , currencyFormat.format(myAccount[validatePin(pinString)].getAmount()), currencyFormat.format(myAccount[validatePin(pinString)].getCharge()),
									currencyFormat.format(myAccount[validatePin(pinString)].getBalance()));
							transactionOutputTextArea.setFont(taFont);
							transactionOutputTextArea.append(formattedTitleString);
							clearProcessAccountFields();
						}
					}
				}
				else if(depositRadioButton.isSelected())
				{
					//Deposit the amount into the account
					myAccount[validatePin(pinString)].setDeposit(amountFloat);
					
					//Set the output for the user to see
					String formattedTitleString = String.format("%-6s%-15s%-15s%-12s%-10s%-10s%-10s%n",
							myAccount[validatePin(pinString)].getPin(), myAccount[validatePin(pinString)].getFirstName() +
							" " + myAccount[validatePin(pinString)].getLastName(), accountString,
							typeString , currencyFormat.format(myAccount[validatePin(pinString)].getAmount()), currencyFormat.format(myAccount[validatePin(pinString)].getCharge()),
							currencyFormat.format(myAccount[validatePin(pinString)].getBalance()));
					transactionOutputTextArea.setFont(taFont);
					transactionOutputTextArea.append(formattedTitleString);
					
					//Clear the fields
					clearProcessAccountFields();
				}
				
			}
			catch(NumberFormatException err)
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid amount!");
				amountTextField.selectAll();
				amountTextField.requestFocus();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "That PIN is not for an account!");
			confirmPinTextField.selectAll();
			confirmPinTextField.requestFocus();
		}
	}//end of processTransaction method
	
	//this method shows the account information in a JOption pane using a for loop
	public void displayAllAccountInfo()
	{
		String formattedTitleString = String.format("%-20s%-6s%10s%n",
				"Name","PIN","Balance");
		displayAllTextArea.setFont(taFont);
		displayAllTextArea.setText(formattedTitleString);
		DecimalFormat currencyFormat = new DecimalFormat("$###0.00");
		
		//Create a for loop to iterate through all currently added items in the list and add them to be displayed
		for(int indexInteger = 0; indexInteger <= lastAccountInteger; indexInteger++)
		{
			String formattedOutputString = String.format("%-20s%-6s%10s%n", 
					myAccount[indexInteger].getFirstName() + " " + myAccount[indexInteger].getLastName(),
					myAccount[indexInteger].getPin(), currencyFormat.format(myAccount[indexInteger].getBalance()));
			displayAllTextArea.append(formattedOutputString);
		}
		
		JOptionPane.showMessageDialog(null, displayAllTextArea);
		
	}//end of displayAllAccountInfo method	
		
}//end of class
