/*
Author: Jumanazar Saidov
Date: 2021.11.03
Definition:
Main email service related methods collection
 */

package OOP.Day4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class EmailService {
    ArrayList<Email> emailAccounts;
    Scanner scanner;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");


    public EmailService(ArrayList<Email> emailAccounts){
        this.emailAccounts = emailAccounts;
    }

    /**
     * A method for finding user email account
     * @param emailAddress user email address
     * @return user email account
     */
    public Email find(String emailAddress){
        for(Email emailAccount : emailAccounts){
            if(emailAccount.getContact().getEmailAddress().equals(emailAddress)){
                return emailAccount;
            }
        }
        System.out.println("We couldn't find the email address in our database. \nPlease, check the correctness of the email address provided.");
        return null;
    }

    /**
     * Check whether user email account exists in the database
     * @param emailAddress user email address
     * @return true if user email account exists, otherwise false
     */
    public boolean exists(String emailAddress){
        for(Email emailAccount : emailAccounts){
            if(emailAccount.getContact().getEmailAddress().equals(emailAddress)){
                return true;
            }
        }
        return false;
    }

    /**
     * Handler method for sending email messages
     * @param messageToSend message being sent
     * @return true if message is received by the receiver successfully, otherwise false
     */
    public boolean sendEmail(Message messageToSend){
        if(messageToSend != null){
            Email emailAccount = find(messageToSend.getSender().getEmailAddress());
            if(receiveEmail(messageToSend)){
                emailAccount.pushOutbox(messageToSend);
                System.out.println("Email was sent successfully to : " + String.join(",", messageToSend.getReceiverEmails()) );
                return true;
            }
            else {
                return false;
            }
         }
        System.out.println("Null message object reference was received.");
        return false;
    }

    /**
     * Handler method for receiving email messages
     * @param messageReceived message being received
     * @return true if receiver(s) email account exists in the database, otherwise false.
     */
    public boolean receiveEmail(Message messageReceived){
        Email emailAccount;
        String success = "Email sending was successful for: ", unsuccess = "Email sending was unsuccessful for: ";
        int countSuccess = 0, countUnSuccess = 0;
        boolean result = false;
        for(int i=0; i < messageReceived.getReceivers().length; i++){
            emailAccount = find(messageReceived.getReceiverEmails()[i]);
            if(emailAccount != null){
                emailAccount.pushInbox(messageReceived);
                messageReceived.setReceiptStatus(true);
                result = true;
                countSuccess++;
                success = success.concat(emailAccount.getContact().getEmailAddress() + " ");
            }
            else {
                countUnSuccess++;
                unsuccess = unsuccess.concat(messageReceived.getReceivers()[i].getEmailAddress() + " ");
            }
        }
        /*
        if(countSuccess > 0){
            System.out.println(success);
        }
         */
        if(countUnSuccess > 0){
            System.out.println(unsuccess);
        }
        return result;
    }

    /**
     * Handler method for deleting email message from one of the boxes (inbox, outbox, spam, bin)
     * @param myAccount user email account
     * @param messageToDelete email message to delete
     * @param boxName email box name such as inbox, outbox, spam, bin.
     */
    public void deleteEmail(Email myAccount, Message messageToDelete, String boxName){
        switch (boxName){
            case "inbox":
                myAccount.getInbox().removeIf(message -> message.equals(messageToDelete));
                break;
            case "outbox":
                myAccount.getOutbox().removeIf(message -> message.equals(messageToDelete));
                break;
            case "spam":
                myAccount.getSpam().removeIf(message -> message.equals(messageToDelete));
                break;
            case "bin":
                myAccount.getBin().removeIf(message -> message.equals(messageToDelete));
                break;
            default:
                //do nothing for now
        }
        System.out.println("Message was successfully deleted.");
    }

    /**
     * Display menu after sign-in process
     */
    public void displayMenu(){
        System.out.println("----------------MENU----------------\n");
        System.out.println("1 - Write new email (yangi xat yozish)");
        System.out.println("2 - Check Inbox (Kelgan barcha xatlarni ko'rish)");
        System.out.println("3 - Check Outbox (Jo'natilgan xatlarni ko'rish)");
        System.out.println("4 - Check Bin (O'chirilgan xatlar savatchasini ko`rish)");
        System.out.println("5 - Check Spam (Spam xatlarni ko'rish)");
        System.out.println("0 - Logout (hisobdan chiqish)");
        System.out.println("-1 - Quit (dasturdan chiqish)");
        System.out.print("Please, enter the number of the operation you want: ");
    }

    /**
     * Handler method for finding user email address based on multiple user inputs
     * @param firstName user's first name
     * @param lastName user's last name
     * @param countryName user's country
     * @param phoneNumber user's phone number
     * @return user email address
     */
    public String find(String firstName, String lastName, String countryName, String phoneNumber) {
        for(Email account : emailAccounts){
            if(account.getContact().getFirstName().equals(firstName) &&
                    account.getContact().getLastName().equals(lastName) &&
                    account.getContact().getCountry().equals(countryName) &&
                    account.getContact().getPhoneNumber().equals(phoneNumber)){
                return account.getContact().getEmailAddress();

            }
        }

        return null;
    }

    //QUIT = -1, LOGOUT = 0, WRITE_EMAIL = 1, CHECK_INBOX = 2, CHECK_UNREAD = 3, DELETE_EMAIL = 4, CHECK_SPAM = 5;


    /**
     * Handler method for viewing email boxes such as inbox, outbox, spam, bin, etc.
     * @param emailAccount user email account
     * @param messages relevant email messages
     * @param boxName boxname such as inbox, outbox, spam, bin
     */
    public void handleBoxes(Email emailAccount, Stack<Message> messages, String boxName) {
        final int READ=1, DELETE=2, RETURN=0, EXIT=-1;
        scanner = new Scanner(System.in);
        Integer selectMenu = null;
        Integer secondOption = null;
        boolean returnCommand = false;
        while (selectMenu == null && !returnCommand){
            int numMsg = messages.size();
            System.out.printf("You have %d message%s in your %s folder!\n", numMsg, numMsg > 1 ? "s" : "", boxName);
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
                        if(messages.size()==0){
                            selectMenu = 0;
                            break;
                        }
                        for(Message message : messages){
                            System.out.println("Index: " + indexOfMsg++ + ", subject: " + message.getSubject() + ", from: " + message.getSender().getEmailAddress() + ", status: " + (message.isReadStatus() ? "read" : "unread"));
                        }

                        System.out.print("Please, choose the index of message:");
                        secondOption = scanner.nextInt();
                        if(secondOption < 0 || secondOption >= messages.size()){
                            System.out.println("Wrong index. Please, try again!");
                            continue;
                        }
                        Message message = messages.get(secondOption);

                        System.out.println("-------EMAIL CONTENT------\n");
                        System.out.println(message.toString());

                        if(boxName.equals("inbox")) {
                            messages.get(secondOption).setReadStatus(true);
                            Contact sender = message.getSender();
                            Stack<Message> receivedMsgs = find(sender.getEmailAddress()).getInbox();
                            for (Message rcvMsg : receivedMsgs) {
                                if (rcvMsg.equals(message)) {
                                    rcvMsg.setReadStatus(true);
                                    System.out.println("Read receipt notifition was sent to the sender.");
                                    break;
                                }
                            }

                            Integer replyBack = null;
                            Contact[] receiverers;
                            while (replyBack == null) {
                                System.out.println("----------------MENU----------------\n");
                                System.out.println("1. Reply\n2. Reply to all.\n0. Return to Inbox");
                                System.out.print("Select a menu option: ");
                                replyBack = scanner.nextInt();
                                if (replyBack == 0) {
                                    break;
                                } else if (replyBack == 1) {
                                    receiverers = new Contact[]{sender};
                                    handleWriteEmail(emailAccount, receiverers);
                                    break;
                                } else if (replyBack == 2) {
                                    receiverers = new Contact[message.getReceivers().length];
                                    receiverers[0] = sender;
                                    if (receiverers.length > 1) {
                                        for (int i = 1; i < receiverers.length; i++) {
                                            if (!message.getReceivers()[i].equals(emailAccount.getContact())) {
                                                receiverers[i] = message.getReceivers()[i];
                                            }
                                        }
                                    }
                                    handleWriteEmail(emailAccount, receiverers);
                                    break;
                                } else {
                                    replyBack = null;
                                }
                            }
                        }
                        else if(boxName.equals("outbox"))
                        {
                            // method for forwarding email...
                            System.out.println("forwarding method is yet to be impl...");
                        }
                        else if(boxName.equals("spam")){
                            // method for move or remove compeletely...
                            System.out.println("forwarding method is yet to be impl...");
                        }
                        else if(boxName.equals("bin")){
                            // method for bin folder restore or remove completely...
                            System.out.println("forwarding method is yet to be impl...");
                        }
                        else {
                            // method for new folders...
                            System.out.println("forwarding method is yet to be impl...");
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
                        for (Message msg : messages) {
                            System.out.println("Index: " + indexOfMsg++);
                        }
                        System.out.print("Please, choose the index of message:");
                        secondOption = scanner.nextInt();
                        if (secondOption < 0 || secondOption >= numMsg) {
                            System.out.println("Wrong index. Please, try again!");
                            secondOption = null;
                        }
                    }
                    int index = secondOption;
                    messages.remove(index);
                    System.out.print("SUCCESS: The message was successfully deleted. ");
                    //System.out.printf("You have %d message(s) at your inbox", emailAccount.getInbox().size());

                    selectMenu = null;
                    secondOption = null;
                    break;
                case RETURN:
                    returnCommand = true;
                    break;
                case EXIT:
                    System.out.println("Thank you for using our service!");
                    System.exit(0);

            }
            if(returnCommand){
                break;
            }
        }

    }

    /**
     * Handler method for writing an email message to multiple recipients
     * @param emailAccount user email account
     * @param receiverers receiverer(s)
     */
    public void handleWriteEmail(Email emailAccount, Contact[] receiverers) {
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

                boolean success = sendEmail(new Message(msgSubject,
                        msgContent,
                        emailAccount.getContact(),
                        receiverers,
                        format.format(new Date())));
                if (!success) {
                    continue;
                }
                break;
            }
            break;
        }
    }

    /**
     * Handler method for writing an email message a single recipient
     * @param emailAccount user email account
     */
    public void handleWriteEmail(Email emailAccount) {
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
                    Email receiverAccount = find(receiverEmail);
                    Contact receiverCon = null;
                    if(receiverAccount != null){
                        receiverCon = receiverAccount.getContact();
                    }
                    if (receiverCon != null) {
                        boolean success = sendEmail(new Message(msgSubject,
                                msgContent,
                                emailAccount.getContact(),
                                new Contact[]{receiverCon},
                                format.format(new Date())));
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


    /**
     * creates a user account and adds it to the database
     */
    public void createAccount() {
        //System.out.println("Method yet to be implemented");
        System.out.println();
        System.out.println("\tCREATE A NEW ACCOUNT");
        System.out.println();
        scanner = new Scanner(System.in);
        System.out.print("Enter your preferred email address: ");
        String emailAddress = scanner.nextLine();
        while (exists(emailAddress)){
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

    /**
     * handles user sign-in process
     * @return signed-in email account
     */
    public Email signIn() {
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("\tSIGN IN YOUR ACCOUNT");
        System.out.println();
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

            emailAccount = find(username);
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
                    emailAccount = find(username);
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
//        assert emailAccount != null;
        if(emailAccount != null && emailAccount.getContact() != null){
            Contact contact = emailAccount.getContact();
            System.out.println("Welcome, " + contact.getFirstName() + "!");
        }
        return emailAccount;
    }


    /**
     * handles user password reset process by taking in user input and setting new password
     */
    public void resetPassword() {
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("\tRESET YOUR PASSWORD");
        System.out.println();
        String emailAddress = getUserInputForEmailAddress();
        Email user = find(emailAddress);
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


    /**
     * helps with user input for validated email address
     * @return email address
     */
    public String getUserInputForEmailAddress() {
        System.out.print("Please, enter your email address: ");
        String emailAddress = scanner.nextLine();
        int counter = 0;
        while(!exists(emailAddress)){
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


    /**
     * Handler method for finding the user
     * @return
     */
    public String findUserName() {
        String emailAddress = "";
        String firstName, lastName, countryName, phoneNumber;
        System.out.println();
        scanner = new Scanner(System.in);
        int counter = 0;
        while (emailAddress == null || emailAddress.isEmpty()){
            System.out.print("Please, enter your first name: ");
            firstName = scanner.next();
            System.out.print("Please, enter your last name: ");
            lastName = scanner.next();
            System.out.print("Please, enter your country name: ");
            countryName = scanner.next();
            System.out.print("Please, enter your phone number: ");
            phoneNumber = scanner.next();

            emailAddress = find(firstName, lastName, countryName, phoneNumber);
            if(emailAddress != null && !emailAddress.isEmpty()){
                System.out.println("Your emailAddress is '" + emailAddress + "'");
                return emailAddress;
            }
            else {
                System.out.println("There is no username registered for the given information.");
                counter++;
                if(counter>5){
                    System.out.println("It seems like you are trying to hack someone else's account?! We will close the session for some time.");
                    break;
                }
            }
        }
        return null;
    }
}
