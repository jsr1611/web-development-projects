package OOP.Day4;

import java.util.Scanner;

public class OnlineBankingDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account0 = new Account(100_000, "Jamshiddin Siddiqov", "Xalq banki", 100_000, "jams000$$");
        Account account1 = new Account(100_001, "Umar Odilov", "Milliy bank", 500_000, "umar001$$");
        Account account2 = new Account(100_002, "Akbar Kamolov", "Milly bank", 300_000, "akba002$$");
        Account account3 = new Account(100_003, "Ali Sherxonov", "Xalq banki", 250_000, "ali003$$");
        Account account4 = new Account(100_004, "Mansur Hokimov", "Buyuk Ipak Yo`li banki", 200_000, "mans004$$");
        Account[] accounts = {account0, account1, account2, account3, account4};
        OnlineBanking banking = new OnlineBanking(accounts);
        /*for(Account account : accounts){
            banking.view(account);
            System.out.println("--------------------------------------");
        }*/
        Scanner scanner = new Scanner(System.in);
         final int QUIT = -1, LOGOUT = 0, VIEW = 1, DEPOSIT = 2, WITHDRAW = 3, TRANSFER = 4, CHANGE_PASSWORD = 5;
        while (true) {
            boolean logout_on = false;
            boolean exitCommand = false;
            Integer userMenuSelected = null;
            Account userAccount = null;
            Integer userAccNumber = null;
            String userPassword = "";
            int passwordTryCountDown = 3;
            System.out.println("Welcome to the Online Banking System!");
            while (!exitCommand) {
                System.out.print("Please, ");
                while (userAccNumber == null) {
                    System.out.print("enter your account number: ");
                    userAccNumber = scanner.nextInt();
                    if (!banking.exists(userAccNumber)) {
                        userAccNumber = null;
                        System.out.println("Unfortunately, we couldn't find your account details in our database.\n" +
                                "Please, check your account number and try again.");
                    }
                }
                userAccount = banking.find(userAccNumber);
                if (!userAccount.getStatus()) {
                    System.out.println("We are sorry but your account is in inactive status. Please, visit the nearest to you branch of the bank to activate your account.\n Thank you!");
                    Thread.sleep(5000);     // wait for 5 seconds and return to the main "Welcome ..." while loop.
                    continue;
                }
                System.out.print("Please, ");
                while (userPassword.length() < 4) {
                    System.out.print("enter your password:");
                    if (scanner.hasNext()) {
                        userPassword = scanner.next();
                        if (!userAccount.getPassword().equals(userPassword)) {
                            System.out.printf("Incorrect password. After 3 unsuccessful trials, " +
                                    "your account will be blocked automatically [%d tries left]", --passwordTryCountDown);
                            userPassword = "";
                            if (passwordTryCountDown == 0) {
                                userAccount.setStatus(false);
                                System.out.println("You have reached the password entry limits and now your account has been blocked.");
                            }
                        }
                    }
                }

                //---------------select menu
                while (true) {
                    banking.displayMenu();
                    while (userMenuSelected == null) {
                        userMenuSelected = scanner.nextInt();
                        if (userMenuSelected < -1 || userMenuSelected > 5) {
                            System.out.println("Wrong menu select number!");
                            banking.displayMenu();
                            userMenuSelected = null;
                        }
                    }
                    System.out.println("------------------------------------");
                    switch (userMenuSelected) {
                        case QUIT:
                            System.out.println("Thank you for using our service!");
                            return;
                        case LOGOUT:
                            logout_on = true;
                            System.out.println("Logging out... Thank you for using our service!");
                            System.out.println("------------------------------------");
                            break;
                        case VIEW:
                            System.out.println("View menu was chosen.");
                            System.out.println("------------------------------------");
                            banking.view(userAccount);
                            break;
                        case DEPOSIT:
                            System.out.println("Deposit menu was chosen.");
                            System.out.println("------------------------------------");
                            handleDeposit(banking, userAccNumber, scanner);
                            break;
                        case WITHDRAW:
                            System.out.println("Withdraw menu was chosen.");
                            System.out.println("------------------------------------");
                            handleWithdrawal(banking, userAccNumber, scanner);
                            break;
                        case TRANSFER:
                            System.out.println("Transfer menu was chosen.");
                            System.out.println("------------------------------------");
                            handleTransfer(banking, userAccNumber, scanner);
                            break;
                        case CHANGE_PASSWORD:
                            System.out.println("Password Change menu was chosen.");
                            System.out.println("------------------------------------");
                            handleChangePassword(banking, userAccNumber, scanner);
                            break;
                    }
                    userMenuSelected = null;
                    if (logout_on) {
                        exitCommand = true;
                        break;
                    }

                }
            }
        }
    }

    private static void handleChangePassword(OnlineBanking banking, Integer userAccNumber, Scanner scanner) {
        String password = "";
        System.out.print("Please, ");
        while (password.length() < 8 || password.length() > 16){
            System.out.println("enter your new password:");
            if(scanner.hasNext()){
                password = scanner.next();
            }
            if(banking.find(userAccNumber).getPassword().equals(password)){
                System.out.println("Same password! Please, try again.");
            }
            else {
                banking.find(userAccNumber).setPassword(password);
                break;
            }
        }

    }

    private static void handleTransfer(OnlineBanking banking, Integer userAccNumber, Scanner scanner) {
        int numberOfReceiver = -1;
        System.out.print("Please, ");
        while (numberOfReceiver == -1){
            System.out.print("enter the receiver's account number:");
            numberOfReceiver = scanner.nextInt();
            if(!banking.exists(numberOfReceiver)){
                System.out.println("Wrong receiver account number!");
                numberOfReceiver = -1;
            }
        }
        System.out.print("Please, enter the amount you want to transfer: ");
        banking.transfer(userAccNumber, numberOfReceiver, scanner.nextInt());
    }

    private static void handleWithdrawal(OnlineBanking banking, Integer userAccNumber, Scanner scanner) {
        System.out.print("Please, enter the amount you want to withdraw: ");
        banking.withdraw(userAccNumber, scanner.nextInt());
    }

    private static void handleDeposit(OnlineBanking banking, int accountNum, Scanner scanner) {
        System.out.print("Please, enter the amount you want to deposit: ");
        banking.deposit(accountNum, scanner.nextInt());
    }
}
