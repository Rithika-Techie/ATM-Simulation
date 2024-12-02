package rithika;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {
   
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

 
    public ATMSimulation(double initialBalance, int initialPin) {
        balance = initialBalance;
        pin = initialPin;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: $" + balance);
    }

    
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

  
    public void withdrawCash(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            transactionHistory.add("Withdrew: $" + amount + ", New balance: $" + balance);
        }
    }

   
    public void depositCash(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited: $" + amount);
        transactionHistory.add("Deposited: $" + amount + ", New balance: $" + balance);
    }

    
    public void changePin(int oldPin, int newPin) {
        if (oldPin == pin) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
            transactionHistory.add("PIN changed.");
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }

    
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    depositCash(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    int oldPin = scanner.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    changePin(oldPin, newPin);
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting ATM. Thank you for using our services!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    
    public static void main(String[] args) {
        
        ATMSimulation atm = new ATMSimulation(1000.0, 1234);
        atm.showMenu();
    }
}
