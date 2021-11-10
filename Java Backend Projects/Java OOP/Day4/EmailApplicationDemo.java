
/*
Author: Jumanazar Saidov
Date: 2021.11.09
Definition:
Implementation class of the Email Application.
 */

package OOP.Day4;

import java.text.SimpleDateFormat;
import java.util.*;

public class EmailApplicationDemo {

    private Scanner scanner = null;
    private EmailService emailService = null;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private ArrayList<Email> emailAccounts = new ArrayList<>();
    public static void main(String[] args) {
        EmailApplicationDemo email = new EmailApplicationDemo();
        email.emailAccounts.add(new Email(new Contact("Jumanazar", "Saidov", "jsr1611@gmail.com", "j123$$")));
        email.emailAccounts.add(new Email(new Contact("Hamza", "K.", "khamza@gmail.com", "hamza123$$")));
        email.emailAccounts.add(new Email(new Contact("Jamshiddin", "Babajonov", "jamshiddin@gmail.com", "jamshiddin123$$")));
        email.emailAccounts.add(new Email(new Contact("Nur", "Saidov", "nursaid@gmail.com", "nur123$$")));
        email.emailAccounts.add(new Email(new Contact("Solih", "Farhodov", "solihfarhod@gmail.com", "solih123$$")));
        email.emailService = new EmailService(email.emailAccounts);
        email.scanner = new Scanner(System.in);
        boolean systemOn = true;

        // loop after starting the email system
        while(systemOn){
            System.out.println("Welcome to the Best Email System!");
            HashMap<Boolean, Email> emailSignIn = email.userMenuBeforeSignIn();
            Email emailAccount = emailSignIn.get(true);
            boolean signedIn = emailAccount != null;

            // loop after sign in the email account
            while (signedIn){
                int numOfUnread = emailAccount.getInboxUnread().size();
                if(numOfUnread > 0){
                    System.out.printf("You have %d unread email%s!\n", numOfUnread, numOfUnread == 1 ? "" : "s");
                }
                email.emailService.displayMenu();

                // <valName, value> -> valName: systemOn, signedIn.
                HashMap<String, Boolean> userMenu = email.userMenuAfterSignIn(emailAccount);
                if(!userMenu.get("systemOn")){
                    systemOn = false;
                    signedIn = false;
                }
                else {
                    signedIn = userMenu.get("signedIn");
                }
            }

        }

    }


    /**
     * User menu selection method before signing in the email account
     * @return status of systemOn and if signIn successful, the email account of the user
     */
    private HashMap<Boolean, Email> userMenuBeforeSignIn() {
        Email emailAccount = null;
        Integer userMenuSelected = null;
        boolean signedIn = false;
        HashMap<Boolean, Email> result = new HashMap<>();
        while(userMenuSelected == null){
            System.out.println("1. Sign in");
            System.out.println("2. Create an account");
            System.out.println("3. Reset password");
            System.out.println("0. Quit");
            System.out.print("Please, select a menu option: ");
            userMenuSelected = scanner.nextInt();
            if(userMenuSelected < 0 || userMenuSelected > 3){
                userMenuSelected = null;
            }
            else {
                switch (userMenuSelected) {
                    case 1:
                        emailAccount = emailService.signIn();
                        signedIn = true;
                        break;
                    case 2:
                        emailService.createAccount();
                        emailAccount = emailService.signIn();
                        signedIn = true;
                        break;
                    case 3:
                        emailService.resetPassword();
                        emailAccount = emailService.signIn();
                        signedIn = true;
                }
                result.put(signedIn, emailAccount);
            }
        }
    return result;
    }

    /**
     * User menu selection method after signing in the email account
     * @param emailAccount user account
     * @return statuses of signIn, systemOn variables.
     */
    private HashMap<String, Boolean> userMenuAfterSignIn(Email emailAccount) {
        final int QUIT = -1, SIGNOUT = 0, WRITE_EMAIL = 1, CHECK_INBOX = 2,CHECK_OUTBOX = 3, CHECK_BIN = 4, CHECK_SPAM = 5;
        // <valName, value> -> valName: systemOn, signedIn.
        HashMap<String, Boolean> result = new HashMap<>();
        boolean systemOn = true;
        boolean signedIn = true;
        Integer userMenuSelected = null;
        while (userMenuSelected == null) {
            userMenuSelected = scanner.nextInt();
            if (userMenuSelected < -1 || userMenuSelected > 5) {
                System.out.println("Wrong menu selected.");
                userMenuSelected = null;
            }
        }

        switch (userMenuSelected){
            case WRITE_EMAIL:
                emailService.handleWriteEmail(emailAccount);
                break;
            case CHECK_INBOX:
                handleCheckInbox(emailAccount);
                break;
            case CHECK_OUTBOX:
                handleCheckOutbox(emailAccount);
                break;
            case CHECK_BIN:
                handleCheckBin(emailAccount);
                break;
            case CHECK_SPAM:
                handleCheckSpam(emailAccount);
                break;
            case SIGNOUT:
                signedIn = false;
                System.out.println("Bye!");
                break;
            case QUIT:
                System.out.println("Thank you for using our service!");
                //System.exit(0);
                signedIn = false;
                systemOn = false;
        }
        result.put("systemOn", systemOn);
        result.put("signedIn", signedIn);
        return result;
    }

    /**
     * Handler method for viewing what is inside the inbox
     * @param emailAccount user email account
     */
    private void handleCheckInbox(Email emailAccount) {
        emailService.handleBoxes(emailAccount,
                emailAccount.getInbox(),
                "inbox");
    }

    /**
     * Handler method for viewing what is inside the spam folder
     * @param emailAccount user email account
     */
    private void handleCheckSpam(Email emailAccount) {
        emailService.handleBoxes(emailAccount, emailAccount.getSpam(), "spam");
    }

    /**
     * Handler method for viewing what is inside the trash bin folder
     * @param emailAccount user email account
     */
    private void handleCheckBin(Email emailAccount) {
        emailService.handleBoxes(emailAccount,
                emailAccount.getBin(),
                "bin");
    }

    /**
     * Handler method for viewing what is inside the outbox folder
     * @param emailAccount user email account
     */
    private void handleCheckOutbox(Email emailAccount) {
        emailService.handleBoxes(emailAccount,
                emailAccount.getOutbox(),
                "outbox");
    }

}
