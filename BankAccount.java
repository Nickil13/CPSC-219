import java.util.InputMismatchException;

/** This class works as a banking account with balances that can be checked, deposited
* into, and withdrawn from. This version is made by Dayan Jayasuriya, Nicki Lindstrom,
* and Riley Schaaf.
* Used for Assignment 3
* Last updated 23/FEB/2018 15:53 by Riley.
*/

public class BankAccount {
  private Customer customer;
  private double balance = 0;
  private double overdraftAmount = 100.0;


  /**
  * Adding constructors to and for no entry of new BankAccount as well as
  * a new customer and a new balance
  */
  public BankAccount() {
  }
  public BankAccount(Customer newCustomer, double newBalance) {
    balance = newBalance;
    customer = newCustomer;
  }

  /**
  * Adding constructors for new BankAccount with only a customer name.
  */
  public BankAccount(Customer newCustomer) {
    customer = newCustomer;
  }

  /**
  * Adding constructors for new BankAccount with only a balance.
  */
  public BankAccount(double newBalance) {
    balance = newBalance;
  }

  /**
  * Setter method for a customer
  */
  public void setCustomer(Customer newCustomer) {
      customer = newCustomer;
  }
  /**
  * Getter method for a customer
  */
  public Customer getCustomer(){

    return customer;
  }
  /**
  * Check the current balance of the bank account.
  */
  public double getBalance() {
    return balance;
  }

  /**
  * Setter method for setting the bank account balance when called from Banking app
  creating a new Bank Account.
  */
  public void setBalance(double newAccountBalance){
    balance = newAccountBalance;
  }

  /**
  * Setter method for the overdraft limit for the account.
  */
  public double setOverdraftAmount(double newOverdraftAmount) {
    //This try block catches an Exception caused by the user not entering an integer.
    try {
      /*This if statement restricts the user to entering a positive number to avoid causing
      a logic error in the withdraw method's if statement.*/
      if (newOverdraftAmount >= 0.0) {
        overdraftAmount=newOverdraftAmount;
      }

      else {
        System.out.println("Please enter the overdraft amount as a positive number.");
        System.out.println("The program will automatically convert it to a negative number once it is entered.");
      }
    }

    catch (InputMismatchException e) {
      System.out.println("You did not enter a number to set the overdraft amount at.");
    }

    return overdraftAmount;
  }

  /**
  * Make a deposit to the bank account.
  */
  public void deposit (double newDeposit) {
    //This try block catches an Exception caused by the user not entering an integer.
    try {
      //This if statement makes sure the user only deposits a positive amount of money.
      if (newDeposit >= 0.0) {
        balance += newDeposit;
      }

      else {
        System.out.println("You cannot deposit a negative number.");
      }
    }

    catch (InputMismatchException e) {
      System.out.println("You did not enter a number to deposit.");
    }
  }

  /**
  * Withraw from the bank account.
  */
  public void withdraw(double newWithdraw) {
    //This try block catches an Exception caused by the user not entering an integer.
    try {
      // if statement to check the withdrawl does not put the account into overdraft.
      if ((balance -newWithdraw) > (-(overdraftAmount))) {
        balance -= newWithdraw;
      }

      else {
        System.out.println("You have reached your overdraft limit.");
      }
    }

    catch (InputMismatchException e) {
      System.out.println("You did not enter a number to withdraw.");
    }
  }
}
