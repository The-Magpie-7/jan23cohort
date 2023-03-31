//package BankAccount;

public class TestBankAccount {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //create account (object)
        BankAccount MarySue = new BankAccount(500, 50);
        //print account totals
        MarySue.displayAccountTotals();
        
        //deposit to checking
        MarySue.depositToChecking(100);
        //deposit to savings
        MarySue.depositToSavings(100);

        //print account totals
        MarySue.displayAccountTotals();

        //attempt to withdraw too much money
        MarySue.withdraw(1000);

        //withdraw some money
        MarySue.withdraw(200);

        //print account totals
        MarySue.displayAccountTotals();

        //testing that private set fields cannot be accessed -- all not accessible
        // BankAccount.accountNumer;
        // BankAccount.checkingBalance;
        // BankAccount.savingsBalance;
        // BankAccount.getCheckingBalance;
        // BankAccount.getSavingsBalance;

        //create a new account object
        BankAccount FrankSinatra = new BankAccount(100000, 2000);
        FrankSinatra.displayAccountTotals();

        //get total in bank
        BankAccount adminAccess = new BankAccount(0, 0);
        System.out.println("Total in bank: " + String.format("$ %, .2f", adminAccess.getTotalMoneyStored()));

        System.out.println("Number of bank accounts: " + BankAccount.numberOfAccountsCreated);
    }
}
