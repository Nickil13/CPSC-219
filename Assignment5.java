import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.text.*;

/**
* This Application allows the user to modify an existing Bank Account as
* well as create a new account.
* Created by Nicki
* Last Updated: 23.Feb.2018 2:42 pm
*/

public class Assignment5 extends Application{
  private Customer accountHolder;
  private BankAccount bankAccount = new BankAccount(accountHolder);
  private BankAccount currentBankAccount = new BankAccount();
  private double newDeposit = 0;
  private double newWithdrawl = 0;
  private double accountBalance = bankAccount.getBalance();
  private double amount;
  private final int hBoxWidth = 6;
  private final int vBoxWidth = 30;
  private final int groupHeight = 300;
  private final int groupWidth = 500;
  private final int textFieldWidth = 100;
  private final int mathSign = 1;


  public void userSetAccountHolder() {
    String name;
    int id;
    System.out.println("Enter a customer Name: ");
    Scanner keyName = new Scanner(System.in);
    name = keyName.next();

    System.out.println("Enter a customer ID number: ");
    Scanner keyID = new Scanner(System.in);
    id = keyID.nextInt();

    accountHolder = new Customer(name, id);
    setCurrentBankAccount(bankAccount);
  }

  //set the current bank account being used by app
  public void setCurrentBankAccount(BankAccount aBankAccount){
    currentBankAccount = aBankAccount;
  }

  //get the current bank account being used by the app.
  public BankAccount getCurrentBankAccount(){
    return currentBankAccount;
  }

  public void start(Stage primaryStage){
    // old code
    if (accountHolder == null) {
      userSetAccountHolder();
    }


    //Create a new group to hold the buttons and boxes. -- dont need StackPane
    Group root = new Group();

    //Vbox containing all hboxes
    VBox vBox = new VBox(vBoxWidth/2);

    //Hbox containing the balance and a label for it
    HBox balanceBox = new HBox(hBoxWidth);
    Label statBalance = new Label("Balance: " + accountBalance);
    balanceBox.getChildren().add(statBalance);

    //Vbox containing Customer info
    VBox accountHolderBox = new VBox(vBoxWidth/2);
    Label accountHolderName = new Label("Account Holder Name: " + accountHolder.getName());

    Label accountHolderID = new Label("Account ID: " + accountHolder.getID());
    accountHolderBox.getChildren().addAll(accountHolderName, accountHolderID);

    //HBox Containing Buttons for withdrawl and deposit
    HBox buttons = new HBox();
    Button withdrawal = new Button("Withdraw");
    Button deposit = new Button("Deposit");


    //Vbox Containing the user input area
    VBox changeInMoney = new VBox();
    TextField entry = new TextField("Enter Withdrawal or Deposit Amount");
    entry.setPrefWidth(textFieldWidth*2.5);
    changeInMoney.getChildren().add(entry);

    /*Create actions for buttons
    Deposit entry into current bank account's balance
    Source of technique was Chapter 8, Walter Savitch Java: An Introduction to Problem Solving and Programming (8th Edition)
    */
    deposit.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        //get value of deposit
        amount = (Double.parseDouble(entry.getText()));
        currentBankAccount.deposit(amount);
        accountBalance = currentBankAccount.getBalance();
        statBalance.setText("Balance: " + Double.toString(accountBalance));
      }
    });

    //withdraw entry from current bank account's balance
    withdrawal.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        //get value of deposit
        amount = (Double.parseDouble(entry.getText()));
        currentBankAccount.withdraw(amount);
        accountBalance = currentBankAccount.getBalance();
        statBalance.setText("Balance: " + Double.toString(accountBalance));
      }
    });

    //combine all boxes into scene
    buttons.getChildren().addAll(withdrawal, deposit);
    vBox.getChildren().addAll(accountHolderBox, balanceBox, buttons, changeInMoney);


  // create a border pane for the first scene
    BorderPane borderPane1 = new BorderPane();
    borderPane1.setCenter(vBox);


  // first hbox for Customer ID and corresponding textField
    HBox customerHBox = new HBox(hBoxWidth);
    Label customerLabel = new Label("Customer ID: ");
    TextField customerField = new TextField("Enter the customer ID.");
    customerHBox.getChildren().addAll(customerLabel, customerField);
    customerField.setPrefWidth(textFieldWidth*2);

  // second hbox for Customer name and corresponding textField
    HBox custNameHBox = new HBox(hBoxWidth);
    Label customerNameLabel = new Label("Customer name: ");
    TextField customerNameField = new TextField("Enter the name of the customer.");
    custNameHBox.getChildren().addAll(customerNameLabel, customerNameField);
    customerNameField.setPrefWidth(textFieldWidth*2);

  // third hbox for start Balance and corresponding textField
    HBox startBalanceHBox = new HBox(hBoxWidth);
    Label startBalanceLabel = new Label("Start balance: ");
    TextField startBalanceField = new TextField("Enter the starting balance.");
    startBalanceHBox.getChildren().addAll(startBalanceLabel, startBalanceField);
    startBalanceField.setPrefWidth(textFieldWidth*2);

  // Create a Vbox and add the hboxes to the Vbox
    VBox vBoxS2 = new VBox(vBoxWidth);

  // create a label for the new scene
    Label titleLabel = new Label("Create a New Bank Account");
    titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

    titleLabel.setAlignment(Pos.CENTER);

  // create button
    Button createButton = new Button("Create");

  // add the boxes and the buttons to the vBox
    vBoxS2.getChildren().addAll(titleLabel, customerHBox, custNameHBox,
    startBalanceHBox, createButton);


  // add another root
    Group root2 = new Group();
    BorderPane borderPane2 = new BorderPane();

  // align the boxes in scene 2
    customerHBox.setAlignment(Pos.CENTER);
    custNameHBox.setAlignment(Pos.CENTER);
    startBalanceHBox.setAlignment(Pos.CENTER);
    vBoxS2.setAlignment(Pos.CENTER);
    borderPane2.setCenter(vBoxS2);


  // make the button to create an account
    Button createAccount = new Button("Create New Bank Account");
    vBox.getChildren().add(createAccount);

    root.getChildren().add(borderPane1);
    Scene scene = new Scene(root, groupWidth, groupHeight);

    // create the second scene
    Scene scene2 = new Scene(borderPane2, groupWidth, groupHeight);

    // handle when the create account button is clicked
    createAccount.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent event){
        primaryStage.setScene(scene2);
      }
    });

    // handle when the create button is clicked. (go back to first scene)
    createButton.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent event){
        Double newAccBalance = Double.parseDouble(startBalanceField.getText());

        // create a new bank account and set its balance
        BankAccount newBankAccount = new BankAccount();
        newBankAccount.setBalance(newAccBalance);



        // create a corresponding customer
        Customer newAH =
          new Customer(customerNameField.getText(),
            Integer.parseInt(customerField.getText()));
        accountHolderName.setText("Account Holder Name: " + newAH.getName());
        accountHolderID.setText("Account ID: " + newAH.getID());
        statBalance.setText("Balance: " + newAccBalance);

        //set the newly created bank account as the current bank account
        setCurrentBankAccount(newBankAccount);

        // return to scene1
        primaryStage.setScene(scene);
      }
    });


  // set the scene
    primaryStage.setTitle("Bank App");
    primaryStage.setScene(scene);
    primaryStage.show();
    }
}
