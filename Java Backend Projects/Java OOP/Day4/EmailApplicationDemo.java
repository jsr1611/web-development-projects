package OOP.Day4;

import java.util.Scanner;
import java.util.Stack;

public class EmailApplicationDemo {
    public static void main(String[] args) {
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
        EmailSystem emailSystem = new EmailSystem(emails);
        Scanner scanner = new Scanner(System.in);
        final int QUIT = -1, LOGOUT = 0, WRITE_EMAIL = 1, CHECK_INBOX = 2, CHECK_UNREAD = 3, DELETE_EMAIL = 4, CHECK_SPAM = 5;
        while(true){
            System.out.println("Welcome to the Best Email System!");
            boolean logout_on = false;
            boolean exitCommand = false;
            Integer userMenuSelected = null;
            int passwordTryCountDown = 10;

            String username = "", password = "";
            System.out.print("Please, enter your email address:");
            username = scanner.next();
            if(username.isEmpty()){
                username = scanner.next();
            }
            System.out.print("Please, enter your password:");
            password = scanner.next();
            Email emailAccount = emailSystem.find(username);
            if(emailAccount == null){
                System.out.println("ERROR 404");
                System.out.println("The email address you entered didn't match with the one in our database. Please, check your email address and try again.");
                continue;
            }
            if(!emailAccount.getContact().getPassword().equals(password)){
                System.out.println("Wrong password. Please, try again.");
                continue;
            }
            System.out.println("Welcome, " + emailAccount.getContact().getFirstName() + "!");
            while (!exitCommand){
                emailSystem.displayMenu();
                while (userMenuSelected == null) {
                    userMenuSelected = scanner.nextInt();
                    if (userMenuSelected < -1 || userMenuSelected > 5) {
                        System.out.println("Wrong menu selected.");
                        userMenuSelected = null;
                        break;
                    }
                }

                switch (userMenuSelected){
                    case WRITE_EMAIL:
                        handleWriteEmail(scanner, emailSystem, emailAccount);
                        break;
                    case CHECK_INBOX:
                        handleCheckInbox(scanner, emailSystem, emailAccount);
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

    private static void handleCheckInbox(Scanner scanner, EmailSystem emailSystem, Email emailAccount) {
        final int READ=1, DELETE=2, RETURN=0, EXIT=-1;

        Integer selectMenu = null;
        Integer secondOption = null;
        boolean returnCommand = false;

        while (selectMenu == null && !returnCommand){
            System.out.println("----------------MENU----------------");
            System.out.println("1. READ\n2. DELETE\n0. RETURN\n-1.EXIT");

            System.out.print("Please, choose what you want to do:");
            selectMenu = scanner.nextInt();
            if(selectMenu == null){
                selectMenu = scanner.nextInt();
            }
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
                        for(Message message : emailAccount.getInbox()){
                            System.out.println("Index: " + indexOfMsg++);
                        }
                        if(emailAccount.getInbox().size()==0){
                            selectMenu = 0;
                            break;
                        }
                        System.out.print("Please, choose the index of message:");
                        secondOption = scanner.nextInt();
                        if(secondOption < 0 || secondOption >= emailAccount.getInbox().size()){
                            System.out.println("Wrong index. Please, try again!");
                            continue;
                        }
                        Message message = emailAccount.getInbox().get(secondOption);
                        System.out.println(message.toString());
                        //emailAccount.getInbox().get(secondOption).setReadStatus(true);
                        Contact[] receivers = emailAccount.getInbox().get(secondOption).getReceivers();
                        for(Contact contact : receivers) {
                            Email senderEmail = emailSystem.find(contact.getEmailAddress());
                            Stack<Message> receiverMsgs = senderEmail.getInbox();
                            for(Message rsvMsg : receiverMsgs){
                                if(rsvMsg.equals(message)){
                                    rsvMsg.setReadStatus(true);
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
                        boolean remove = emailAccount.getInbox().remove(secondOption);
                        System.out.printf("You have successfully deleted the message. Now you have %d message(s) at your inbox", emailAccount.getInbox().size());

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

    private static void handleWriteEmail(Scanner scanner, EmailSystem emailSystem, Email emailAccount) {
        while (true) {
            System.out.println("Your message: ");
            String msgContent = scanner.nextLine();
            if(msgContent.isEmpty())
                msgContent = scanner.nextLine();
            if(msgContent.isEmpty()){
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
                    if (!receiverEmail.contains("@") || !receiverEmail.contains(".")) {
                        System.out.println("Please, check the correctness of the email address!");
                        continue;
                    }
                    Contact receiverCon = emailSystem.find(receiverEmail).getContact();
                    if(receiverCon != null) {
                        boolean success = emailSystem.sendEmail(new Message(msgSubject,
                                                        msgContent,
                                                        emailAccount.getContact(),
                                                        new Contact[]{receiverCon},
                                                "2021.11.04 00:13"));
                        if(!success){
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
