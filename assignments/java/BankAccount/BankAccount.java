//package BankAccount;
import java.util.Random;


public class BankAccount {
    //attributes
    private long accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    //class members
    //track number of accounts
    public static int numberOfAccountsCreated = 0;
    //track total money stored in every account created
    public static double totalMoneyStored;

    //constructor
    public BankAccount(double checkBal, double savBal){
        //int accountNumber
        this.accountNumber = generateRandomAcctNumber();
        this.checkingBalance = checkBal;
        this.savingsBalance = savBal;
        //keep track of how much is in bank
        totalMoneyStored += checkingBalance + savingsBalance;

        //auto increment account count
        numberOfAccountsCreated++;

        //call random account number generator
        generateRandomAcctNumber();
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void depositToChecking(double amount){
        checkingBalance += amount;
        //keeping track off all money in bank
        totalMoneyStored += amount;
    }

    public void depositToSavings(double amount){
        savingsBalance += amount;
        //keeping track of all money in bank
        totalMoneyStored += amount;
    }

    //get the total in the bank
    public double getTotalMoneyStored(){
        return totalMoneyStored;
    }

    //withdrawal money from checking
    public void withdraw(double amount){
        if(checkingBalance >= amount){
            checkingBalance -= amount;
            //keeping track of all money in bank
            totalMoneyStored -= amount;
        }
        else if((checkingBalance + savingsBalance) >= amount){
            double remainingAmount = amount - checkingBalance;
            checkingBalance = 0;
            savingsBalance -= remainingAmount;
            //keeping track of all money in bank
            totalMoneyStored -= amount;
        }
        //not enough in account to make withdrawal
        else{
            System.out.println("Insufficient funds");
        }
    }

    public void displayAccountTotals(){
        System.out.println("Account number: " + accountNumber);
        System.out.println("Checking balance: " + checkingBalance);
        System.out.println("Savings balance: " + savingsBalance);
        System.out.println("Total funds: " + (checkingBalance + savingsBalance));
    }

    private long generateRandomAcctNumber(){
        Random random = new Random();
        //10000000000L limits to 10 digits
        long randomAccountNumber = random.nextLong() % 10000000000L;
        return Math.abs(randomAccountNumber);

    } 
}
