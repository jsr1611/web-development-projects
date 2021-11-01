package OOP.Day4;

import java.util.ArrayList;

public class OnlineBanking {
    private final Account[] accounts;
    private String lastOperation;
    public OnlineBanking(Account[] accounts){
        this.accounts = accounts;
    }
    // methods

    /**
     * View all information about the account
     */
    public void view(Account account){
        System.out.println("Account owner: " + account.getOwner());
        System.out.println("Account number: " + account.getNumber());
        System.out.println("Bank name: " + account.getBankName());
        System.out.println("Balance: " + account.getBalance() + " UZS");
        System.out.println("Status: " + (account.getStatus() ? "active" : "inactive(or blocked)"));
/*
        System.out.printf("Account was not found in the database based on given information. \n" +
                "Account number: %d\n" +
                "Account holder's name: %s\n" +
                "Bank name: %s", accountNumber, owner, bankName);
*/
    }

    /**
     * Deposit money into account
     * @param accountNumber my account number
     * @param amountToDeposit amount to be deposited
     */
    public void deposit(int accountNumber, int amountToDeposit){
        Account account = find(accountNumber);
        if(account != null){
            account.setBalance(account.getBalance() + amountToDeposit);
            System.out.printf("Deposit was successful (%d UZS). Current balance: %.3f UZS\n", amountToDeposit, account.getBalance());
            account.setLastOperation("Successful deposit of money (" + amountToDeposit + " UZS)");
            lastOperation = "Successful deposit of money (" + amountToDeposit + " UZS) for account number: " + accountNumber;
        }
    }

    /**
     * Withdraw money from account
     * @param accountNumber my account number
     * @param amountToWithdraw amount to withdraw
     */
    public void withdraw(int accountNumber, int amountToWithdraw){
        Account account = find(accountNumber);
        if(account != null) {
            if (account.getBalance() < amountToWithdraw) {
                System.out.println("Not enough money to withdraw. Current balance: " + account.getBalance() + " UZS");
            }
            else {
                account.setBalance(account.getBalance() - amountToWithdraw);
                System.out.printf("Withdrawal was successful (%d UZS). Current balance: %.3f UZS\n",
                        amountToWithdraw, account.getBalance());
                account.setLastOperation("Successful withdrawal of money (" + amountToWithdraw + " UZS)");
                lastOperation = "Successful withdrawal of money (" + amountToWithdraw +
                        " UZS) for account number: " + accountNumber;
            }
        }

    }

    /**
     * Transfer money into another account
     * @param numberOfSender my account number
     * @param numberOfReceiver account number of the beneficiary
     * @param amountToTransfer amount to transfer
     */
    public void transfer(int numberOfSender, int numberOfReceiver, int amountToTransfer){
        Account sender = find(numberOfSender);
        Account receiver = find(numberOfReceiver);
        if(sender != null && receiver != null) {
            if (sender.getBalance() < amountToTransfer) {
                System.out.println("Not enough money to transfer. Current balance: " + sender.getBalance() + " UZS");
            }
            else {
                sender.setBalance(sender.getBalance() - amountToTransfer);
                receiver.setBalance(receiver.getBalance() + amountToTransfer);
                System.out.printf("Transfer transaction of %d UZS into account %d was successful. " +
                        "Current balance: %.3f\n", amountToTransfer, numberOfReceiver, sender.getBalance());
                sender.setLastOperation(String.format("Transfer transaction of %d UZS into account %d was successful.",
                        amountToTransfer, numberOfReceiver));
                lastOperation = String.format("Successful transfer transaction of %d UZS from account %d into account %d.",
                        amountToTransfer, numberOfSender, numberOfReceiver);
            }
        }

    }



    public Account[] filter(Account[] accounts, String bankName){
        ArrayList<Account> newList = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getBankName().equals(bankName)) {
                newList.add(account);
            }
        }
        return newList.toArray(accounts);
    }

    public Account find(int number, String owner, String bankName){
        Account res = null;
        for (Account account : accounts){
            if(account.getBankName().equals(bankName) && account.getNumber() == number && account.getOwner().equals(owner)){
                res = account;
                break;
            }
        }
        return res;
    }

    public Account find(int number, String bankName){
        Account res = null;
        for (Account account : accounts){
            if(account.getBankName().equals(bankName) && account.getNumber() == number){
                res = account;
                break;
            }
        }
        return res;
    }

    public Account find(int number){
        Account res = null;
        for (Account account : accounts){
            if(account.getNumber() == number){
                res = account;
                break;
            }
        }
        return res;
    }

    public boolean exists(int number){
        for (Account account : accounts){
            if(account.getNumber() == number){
                return true;
            }
        }
        return false;
    }

    public void displayMenu(){
        System.out.println("----------------MENU----------------\n");
        System.out.println("1 - View (hisob haqida ma`lumot)");
        System.out.println("2 - Deposit (hisobga pul qo`yish)");
        System.out.println("3 - Withdraw (hisobdan pul yechish)");
        System.out.println("4 - Transfer (boshqa hisobga pul o'tkazish)");
        System.out.println("5 - Change Password (parol almashtirish)");
        System.out.println("0 - Logout (hisobdan chiqish)");
        System.out.println("-1 - Quit (dasturdan chiqish)");
        System.out.print("Please, enter the number of the operation you want: ");
    }



}
