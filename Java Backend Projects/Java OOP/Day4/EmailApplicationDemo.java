package OOP.Day4;

import java.util.Scanner;
import java.util.Stack;

public class EmailApplicationDemo {
    private Scanner scanner = null;
    private EmailService emailService = null;
    public static void main(String[] args) {
        EmailApplicationDemo email = new EmailApplicationDemo();

        Contact contact0 = new Contact("Jumanazar", "Saidov", "jsr1611@gmail.com", "j123$$");
        Contact contact1 = new Contact("Hamza", "K.", "khamza@gmail.com", "hamza123$$");
        Contact contact2 = new Contact("Jamshiddin", "Babajonov", "jamshiddin@gmail.com", "jamshiddin123$$");
        Contact contact3 = new Contact("Nur", "Saidov", "nursaid@gmail.com", "nur123$$");
        Contact contact4 = new Contact("Solih", "Farhodov", "solihfarhod@gmail.com", "solih123$$");
        Contact[] contacts = {contact0, contact1, contact2, contact3, contact4};
        Email emailAccount0 = new Email(contact0, new Stack<>(), new Stack<>(), new Stack<>());
        Email emailAccount1 = new Email(contact1,  new Stack<>(), new Stack<>(), new Stack<>());
        Email emailAccount2 = new Email(contact2,  new Stack<>(), new Stack<>(), new Stack<>());
        Email emailAccount3 = new Email(contact3,  new Stack<>(), new Stack<>(), new Stack<>());
        Email emailAccount4 = new Email(contact4,  new Stack<>(), new Stack<>(), new Stack<>());
        Email[] emails = {emailAccount0, emailAccount1, emailAccount2, emailAccount3, emailAccount4};
        email.emailService = new EmailService(emails);
        email.scanner = new Scanner(System.in);
        final int QUIT = -1, LOGOUT = 0, WRITE_EMAIL = 1, CHECK_INBOX = 2,CHECK_OUTBOX = 3, CHECK_BIN = 4, CHECK_SPAM = 5;
        while(true){
            System.out.println("Welcome to the Best Email System!");
            boolean logout_on = false;
            boolean exitCommand = false;
            Integer userMenuSelected = null;
            int passwordTryCountDown = 10;

            String username = "", password = "";
            Email emailAccount = null;

            while(userMenuSelected == null){
                System.out.println("1. Sign in");
                System.out.println("2. Create an account");
                System.out.println("3. Reset password");
                System.out.println("0. Quit");
                System.out.print("Please, select a menu option: ");
                userMenuSelected = email.scanner.nextInt();
                if(userMenuSelected < 0 || userMenuSelected > 3){
                    userMenuSelected = null;
                }
                else {
                    switch (userMenuSelected){
                        case 1:
                            emailAccount = email.signin();
                            break;
                        case 2:
                            createAccount();
                            emailAccount = email.signin();
                            break;
                        case 3:
                            resetPassword();
                            emailAccount = email.signin();
                            break;
                        case 0:
                            return;
                        default:
                            break;
                    }
                }
            }
            userMenuSelected = null;
            // main loop of email application
            while (!exitCommand){
                email.emailService.displayMenu();
                while (userMenuSelected == null) {
                    userMenuSelected = email.scanner.nextInt();
                    if (userMenuSelected < -1 || userMenuSelected > 5) {
                        System.out.println("Wrong menu selected.");
                        userMenuSelected = null;
                    }
                }

                switch (userMenuSelected){
                    case WRITE_EMAIL:
                        email.handleWriteEmail(emailAccount);
                        break;
                    case CHECK_INBOX:
                        email.handleCheckInbox(emailAccount);
                        break;
                    case CHECK_OUTBOX:
                        email.handleCheckOutbox(emailAccount);
                        break;
                    case CHECK_BIN:
                        email.handleCheckBin(emailAccount);
                        break;
                    case CHECK_SPAM:
                        email.handleCheckSpam(emailAccount);
                        break;
                    case LOGOUT:
                        exitCommand = true;
                        System.out.println("Bye!");
                        break;
                    case QUIT:
                        System.out.println("Thank you for using our service!");
                        return;
                }
                userMenuSelected = null;

            }

        }


    }

    private void handleCheckSpam(Email emailAccount) {
        System.out.println("Method yet to be implemented");
    }

    private void handleCheckBin(Email emailAccount) {
        System.out.println("Method yet to be implemented");
    }

    private void handleCheckOutbox(Email emailAccount) {
        System.out.println("Method yet to be implemented");
    }

    private void handleCheckInboxUnread(Email emailAccount) {
        System.out.println("Method yet to be implemented");
    }

    private static void createAccount() {
        System.out.println("Method yet to be implemented");

    }

    private static void resetPassword() {

        System.out.println("Method yet to be implemented.");
    }

    private Email signin() {
        String username, password;
        int wrongEmailCount = 0;
        int wrongPasswdCount = 0;
        while (true) {
            System.out.print("Please, enter your email address:");
            username = scanner.next();
            if (username.isEmpty()) {
                username = scanner.next();
            }
            System.out.print("Please, enter your password:");
            password = scanner.next();
            Email emailAccount = emailService.find(username);
            if (emailAccount == null) {
                System.out.println("ERROR 404");
                System.out.println("The email address you entered didn't match with the one in our database. Please, check your email address and try again.");
                wrongEmailCount++;
                if(wrongEmailCount >=3){
                    System.out.println("Forgot your username?");
                    //username = findUserName(scanner, emailSystem);
                }
                continue;
            }
            if (!emailAccount.getContact().getPassword().equals(password)) {
                System.out.println("Wrong password. Please, try again.");
                wrongPasswdCount++;
                if(wrongEmailCount >= 3){
                    System.out.printf("You have reached %d wrong password attemps. Returning to main menu...", wrongPasswdCount);
                    return null;
                }
                continue;
            }
            System.out.println("Welcome, " + emailAccount.getContact().getFirstName() + "!");
            return emailAccount;
        }


    }

    private String findUserName() {
        String userName = "";
        String firstName, lastName, countryName, phoneNumber;
        scanner = new Scanner(System.in);
        while (userName.isEmpty()){
            System.out.print("Please, enter your first name: ");
            firstName = scanner.next();
            System.out.print("Please, enter your last name: ");
            lastName = scanner.next();
            System.out.print("Please, enter your country name: ");
            countryName = scanner.next();
            System.out.print("Please, enter your phone number: ");
            phoneNumber = scanner.next();

            userName = emailService.find(firstName, lastName, countryName, phoneNumber);
            if(!userName.isEmpty()){
                System.out.println("Your userName is '" + userName + "'");
            }
            else {
                System.out.println("There is no");
            }

        }

        return null;
    }

    private void handleCheckInbox(Email emailAccount) {
        final int READ=1, DELETE=2, RETURN=0, EXIT=-1;
        this.scanner = new Scanner(System.in);
        Integer selectMenu = null;
        Integer secondOption = null;
        boolean returnCommand = false;

        while (selectMenu == null && !returnCommand){
            System.out.println("----------------MENU----------------");
            System.out.println("1. READ\n2. DELETE\n0. RETURN\n-1.EXIT");

            System.out.print("Please, choose what you want to do:");
            selectMenu = scanner.nextInt();
            if(selectMenu<-1 || selectMenu > 2){
                selectMenu = null;
                System.out.println("Wrong menu selected.");
                continue;
            }

            System.out.printf("You have %d messages at your inbox!\n", emailAccount.getInbox().size());
            switch (selectMenu){
                case READ:
                    while (secondOption == null){
                        int indexOfMsg = 0;
                        if(emailAccount.getInbox().size()==0){
                            selectMenu = 0;
                            break;
                        }
                        for(Message message : emailAccount.getInbox()){
                            System.out.println("Index: " + indexOfMsg++ + ", subject: " + message.getSubject() + ", from: " + message.getSender().getEmailAddress());
                        }

                        System.out.print("Please, choose the index of message:");
                        secondOption = scanner.nextInt();
                        if(secondOption < 0 || secondOption >= emailAccount.getInbox().size()){
                            System.out.println("Wrong index. Please, try again!");
                            continue;
                        }
                        Message message = emailAccount.getInbox().get(secondOption);
                        System.out.println(message.toString());
                        emailAccount.getInbox().get(secondOption).setReadStatus(true);
                        Contact[] receivers = emailAccount.getInbox().get(secondOption).getReceivers();
                        for(Contact contact : receivers) {
                            Email senderEmail = emailService.find(contact.getEmailAddress());
                            Stack<Message> receiverMsgs = senderEmail.getInbox();
                            for(Message rcvMsg : receiverMsgs){
                                if(rcvMsg.equals(message)){
                                    rcvMsg.setReadStatus(true);
                                    System.out.println("Read receipt notifition was sent to the sender.");
                                    break;
                                }
                            }
                        }
                            /*while(true){
                            - reply
                            - return back options
                        }*/

                    }
                    if(selectMenu == 0){
                        break;
                    }
                    selectMenu = null;
                    secondOption = null;
                    break;
                case DELETE:
                    while (secondOption == null) {
                        int indexOfMsg = 0;
                        for (Message message : emailAccount.getInbox()) {
                            System.out.println("Index: " + indexOfMsg++);
                        }
                        System.out.print("Please, choose the index of message:");
                        secondOption = scanner.nextInt();
                        if (secondOption < 0 || secondOption >= emailAccount.getInbox().size()) {
                            System.out.println("Wrong index. Please, try again!");
                            secondOption = null;
                        }
                    }
                    boolean removed = emailAccount.getInbox().remove(secondOption);
                    if(removed){
                        System.out.print("SUCCESS: The message was successfully deleted. ");
                    }
                    else {
                        System.out.print("FAILURE: The message deletion failed. ");
                    }
                    System.out.printf("You have %d message(s) at your inbox", emailAccount.getInbox().size());


                    selectMenu = null;
                    secondOption = null;
                    break;
                case RETURN:
                    returnCommand = true;
                    break;
                case EXIT:
                    return;

            }

        }
    }

    private void handleWriteEmail(Email emailAccount) {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your message: ");
            String msgContent = scanner.nextLine();
            if (msgContent.length() < 3)
                msgContent = scanner.nextLine();
            if (msgContent.isEmpty()) {
                System.out.println("Message content cannot be empty!");
                continue;
            }
            String msgSubject = "";
            while (true) {
                System.out.println("Subject:");
                msgSubject = scanner.nextLine();
                if (msgSubject.isEmpty()) {
                    System.out.println("Message title cannot be empty.");
                    continue;
                }
                String receiverEmail = "";
                while (true) {
                    System.out.println("To: ");
                    receiverEmail = scanner.nextLine();
                    if (!receiverEmail.matches("^(.+)@(\\S+)$"))//(!receiverEmail.contains("@") || !receiverEmail.contains("."))
                    {
                        System.out.println("Please, check the correctness of the email address!");
                        continue;
                    }
                    Contact receiverCon = emailService.find(receiverEmail).getContact();
                    if (receiverCon != null) {
                        boolean success = emailService.sendEmail(new Message(msgSubject,
                                msgContent,
                                emailAccount.getContact(),
                                new Contact[]{receiverCon},
                                "2021.11.04 00:13"));
                        if (!success) {
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
            break;
        }

    }

}
