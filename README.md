# BankingApplication
Application written in Java to handle banking application 

In this application I use abstract classes in Java to implement a banking application with a GUI interface. 

The main jobs of this banking application are to maintain user accounts and balances, and track withdrawals and deposits.

Account.java
  This class is an abstract class that sets the necessary components that will be required to be built upon in subclasses CheckingAccount and SavingsAccount.
  

CheckingAccount.java
  This class uses the account abstract class as a template to create this class which has more detailed functionality of the basic Account class. In this class I calculate the creation, depositing, and withdrawing of checkings accounts.


SavingsAccount.java
  This class uses the Account abstract class as a template to create this class which has more detailed functionality of the basic Account class. In this class I calculate the creation, depositing, and withdrawing of savings accounts.
  
  
BankingApplication.java
  This class is the main driver of the project. It uses the classes outlined above and implements them in a GUI interface. The logic of the program is all handled in this driver. 
