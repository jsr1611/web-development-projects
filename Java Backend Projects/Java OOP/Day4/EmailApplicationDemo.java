package OOP.Day4;

import java.text.SimpleDateFormat;
import java.util.*;

public class EmailApplicationDemo {
    private Scanner scanner = null;
    private EmailService emailService = null;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private Date now = new Date();
    private ArrayList<Email> emailAccounts = new ArrayList<>();
    public static void main(String[] args) {
        EmailApplicationDemo email = new EmailApplicationDemo();

        Contact contact0 = new Contact("Jumanazar", "Saidov", "jsr1611@gmail.com", "j123$$");
        Contact contact1 = new Contact("Hamza", "K.", "khamza@gmail.com", "hamza123$$");
        Contact contact2 = new Contact("Jamshiddin", "Babajonov", "jamshiddin@gmail.com", "jamshiddin123$$");
        Contact contact3 = new Contact("Nur", "Saidov", "nursaid@gmail.com", "nur123$$");
        Contact contact4 = new Contact("Solih", "Farhodov", "solihfarhod@gmail.com", "solih123$$");

        email.emailAccounts.add(new Email(contact0));
        email.emailAccounts.add(new Email(contact1));
        email.emailAccounts.add(new Email(contact2));
        email.emailAccounts.add(new Email(contact3));
        email.emailAccounts.add(new Email(contact4));

        email.emailService = new EmailService(email.emailAccounts);
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
                            email.createAccount();
                            emailAccount = email.signin();
                            break;
                        case 3:
                            email.resetPassword();
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
                assert emailAccount != null;
                int numOfUnread = emailAccount.getInboxUnread().size();
                if(numOfUnread > 0){

                    System.out.printf("You have %d unread email%s!\n", numOfUnread, numOfUnread == 1 ? "" : "s");
                }
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

    private void createAccount() {
        //System.out.println("Method yet to be implemented");
        System.out.println();
        System.out.println("Create a new email account");
        System.out.println();
        scanner = new Scanner(System.in);
        System.out.print("Enter your preferred email address: ");
        String emailAddress = scanner.nextLine();
        while (emailService.exists(emailAddress)){
            System.out.println("This email has already been registered. Please, use a different email address.");
            System.out.print("Enter your preferred email address: ");
            emailAddress = scanner.nextLine();
        }
        System.out.print("Enter your preferred password: ");
        String password = scanner.nextLine();
        System.out.print("Enter the secret key: ");
        String secretKey = scanner.nextLine();
        System.out.print("Enter a hint for your secret key: ");
        String secretKeyHint = scanner.nextLine();
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your country name: ");
        String countryName = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println();
        Contact contact = new Contact(firstName, lastName, emailAddress, password);
        contact.setCountry(countryName);
        contact.setPhoneNumber(phoneNumber);
        contact.setSecretKey(secretKey);
        contact.setSecretKeyHint(secretKeyHint);
        System.out.println(contact);

        System.out.println("Your account has been successfully created!");
        System.out.println();
        emailAccounts.add(new Email(contact));
    }

    private void resetPassword() {
        scanner = new Scanner(System.in);
        System.out.println("Method yet to be implemented.");
        System.out.println("\t\tRESET YOUR PASSWORD\t\t");
        System.out.println();
        String emailAddress = getUserInputForEmailAddress();
        Email user = emailService.find(emailAddress);
        int counter;
        System.out.print("Please, enter your secret key you used during the email registration: ");
        String secretKey = scanner.nextLine();
        String password = "";
        counter = 0;
        while (!user.getContact().getSecretKey().equals(secretKey)){
            System.out.println("Hint: " + user.getContact().getSecretKeyHint());
            System.out.print("Please, enter your secret key you used during the email registration: ");
            secretKey = scanner.nextLine();
            counter++;
            if(counter>=5){
                System.out.println("You have reached five attempts in typing your secret key unsuccessfully.");
                System.out.println("It seems that you are attempting to hack someone else's email account.");
                break;
            }
        }
        if(user.getContact().getSecretKey().equals(secretKey)){
            System.out.print("Enter your new password:");
            password = scanner.nextLine();
            System.out.print("Confirm your password:");
            String confirmedPwd = scanner.nextLine();
            while (!confirmedPwd.equals(password)){
                System.out.print("Please, enter your password correctly once again: ");
                confirmedPwd = scanner.nextLine();
            }
            user.getContact().setPassword(password);
            System.out.println("Your password was reset successfully");
        }
    }

    private String getUserInputForEmailAddress() {
        System.out.print("Please, enter your email address: ");
        String emailAddress = scanner.nextLine();
        int counter = 0;
        while(!emailService.exists(emailAddress)){
            System.out.print("Please, enter your email address correctly: ");
            emailAddress = scanner.nextLine();
            counter++;
            if(counter >= 5){
                System.out.println();
                System.out.println("You have reached " + counter + " unsuccessful attempts. Please, find your username using the below survey.");
                System.out.println();
                emailAddress = findUserName();
            }
        }
        return emailAddress;
    }

    private Email signin() {
        scanner = new Scanner(System.in);
        String username = null, password = null;
        int wrongEmailCount = 0;
        int wrongPasswdCount = 0;
        Email emailAccount = null;

        while (emailAccount == null) {
            if(username == null){
                System.out.print("Please, enter your email address:");
                username = scanner.next();
                if(!username.matches("^(.+)@(\\S+)$")){
                    System.out.println("Please, check the correctness of your email address and try again.");
                    continue;
                }
            }
            if(password == null){
                System.out.print("Please, enter your password:");
                password = scanner.next();
            }

            emailAccount = emailService.find(username);
            if (emailAccount == null) {
                System.out.println("ERROR 404");
                System.out.println("The email address you entered didn't match with the one in our database. Please, check your email address and try again.");
                wrongEmailCount++;
                if(wrongEmailCount > 5){
                    break;
                }
                else if(wrongEmailCount >=3){
                    System.out.println("Forgot your username?");
                    username = findUserName();
                    emailAccount = emailService.find(username);
                }
                else
                {
                    username = null;
                    continue;
                }
            }
            if (!emailAccount.getContact().getPassword().equals(password)) {
                System.out.println("Wrong password. Please, try again.");
                wrongPasswdCount++;
                if(wrongPasswdCount >= 5){
                    System.out.printf("You have reached %d wrong password attemps. Returning to main menu...", wrongPasswdCount);
                }
                else if(wrongPasswdCount >= 3){
                    System.out.println("Forgot your passowrd?");
                    resetPassword();
                    password = null;
                    emailAccount = null;
                }
                else {
                    password = null;
                    emailAccount = null;
                }
            }
        }
        System.out.println("Welcome, " + emailAccount.getContact().getFirstName() + "!");
        return emailAccount;
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
                return userName;
            }
            else {
                System.out.println("There is no username registered for the given information.");
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
            int numMsg = emailAccount.getInbox().size();
            System.out.printf("You have %d message%s at your inbox!\n", numMsg, numMsg > 1 ? "s" : "");
            System.out.println("----------------MENU----------------");
            System.out.println("1. READ\n2. DELETE\n0. RETURN\n-1.EXIT");

            System.out.print("Please, choose what you want to do:");
            selectMenu = scanner.nextInt();
            if(selectMenu < -1 || selectMenu > 2){
                selectMenu = null;
                System.out.println("Wrong menu selected.");
                continue;
            }


            switch (selectMenu){
                case READ:
                    while (secondOption == null){
                        int indexOfMsg = 0;
                        if(emailAccount.getInbox().size()==0){
                            selectMenu = 0;
                            break;
                        }
                        for(Message message : emailAccount.getInbox()){
                            System.out.println("Index: " + indexOfMsg++ + ", subject: " + message.getSubject() + ", from: " + message.getSender().getEmailAddress() + ", status: " + (message.isReadStatus() ? "read" : "unread"));
                        }

                        System.out.print("Please, choose the index of message:");
                        secondOption = scanner.nextInt();
                        if(secondOption < 0 || secondOption >= emailAccount.getInbox().size()){
                            System.out.println("Wrong index. Please, try again!");
                            continue;
                        }
                        Message message = emailAccount.getInbox().get(secondOption);

                        System.out.println("-------EMAIL CONTENT------\n");
                        System.out.println(message.toString());
                        emailAccount.getInbox().get(secondOption).setReadStatus(true);
                        Contact sender = message.getSender();
                        Stack<Message> receivedMsgs = emailService.find(sender.getEmailAddress()).getInbox();
                        for(Message rcvMsg : receivedMsgs){
                            if(rcvMsg.equals(message)){
                                rcvMsg.setReadStatus(true);
                                System.out.println("Read receipt notifition was sent to the sender.");
                                break;
                            }
                        }

                        Integer replyBack = null;
                        Contact[] receiverers;
                        while (replyBack == null){
                            System.out.println("----------------MENU----------------\n");
                            System.out.println("1. Reply\n2. Reply to all.\n0. Return to Inbox");
                            System.out.print("Select a menu option: ");
                            replyBack = scanner.nextInt();
                            if(replyBack == 0){
                                break;
                            }
                            else if(replyBack == 1){
                                receiverers = new Contact[]{sender};
                                handleWriteEmail(emailAccount, receiverers);
                                break;
                            }
                            else if(replyBack == 2){
                                receiverers = new Contact[message.getReceivers().length];
                                receiverers[0] = sender;
                                if(receiverers.length > 1) {
                                    for (int i = 1; i < receiverers.length; i++) {
                                        if (!message.getReceivers()[i].equals(emailAccount.getContact())) {
                                            receiverers[i] = message.getReceivers()[i];
                                        }
                                    }
                                }
                                handleWriteEmail(emailAccount, receiverers);
                                break;
                            }
                            else {
                                replyBack = null;
                            }
                        }

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
            if(returnCommand){
                break;
            }
        }
    }

    private void handleWriteEmail(Email emailAccount, Contact[] receiverers) {
        scanner = new Scanner(System.in);
        while (true) {
            if(receiverers.length == 1){
                System.out.println("To: " + receiverers[0].getEmailAddress());
            }
            else {
                System.out.print("To: ");
                int counter = 0;
                for(Contact contact : receiverers){
                    System.out.print(contact.getEmailAddress());
                    counter++;
                    if(counter < receiverers.length){
                        System.out.print(", ");
                    }
                }
            }

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
                now = new Date();
                boolean success = emailService.sendEmail(new Message(msgSubject,
                        msgContent,
                        emailAccount.getContact(),
                        receiverers,
                        format.format(now)));
                if (!success) {
                    continue;
                }
                break;
            }
            break;
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
                    Email receiverAccount = emailService.find(receiverEmail);
                    Contact receiverCon = null;
                    if(receiverAccount != null){
                        receiverCon = receiverAccount.getContact();
                    }
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
