package OOP.Day4;

import java.util.Arrays;

public class EmailService {
    Email[] emailAccounts;
    public EmailService(Email[] emailAccounts){
        this.emailAccounts = emailAccounts;
    }

    public Email find(String emailAddress){
        for(Email emailAccount : emailAccounts){
            if(emailAccount.getContact().getEmailAddress().equals(emailAddress)){
                return emailAccount;
            }
        }
        return null;
    }
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

    public void deleteEmail(Email myAccount, Message messageToDelete, String boxName){
        switch (boxName){
            case "inbox":
                myAccount.getInbox().removeIf(message -> message.equals(messageToDelete));
                break;
            case "outbox":
                myAccount.getInbox().removeIf(message -> message.equals(messageToDelete));
                break;
            case "spam":
                myAccount.getInbox().removeIf(message -> message.equals(messageToDelete));
                break;
            default:
                //do nothing for now
        }
        System.out.println("Message was successfully deleted.");
    }
    /*
    final int QUIT = -1,
    LOGOUT = 0,
    WRITE_EMAIL = 1,
    CHECK_INBOX = 2,
    CHECK_OUTBOX = 3,
    CHECK_BIN = 4,
    CHECK_SPAM = 5;
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

    public String find(String firstName, String lastName, String countryName, String phoneNumber) {
        for(Email account : emailAccounts){
            if(account.getContact().getFirstName().equals(firstName) &&
                    account.getContact().getLastName().equals(lastName) &&
                    account.getContact().getCountry().equals(countryName) &&
                    account.getContact().getPhoneNumber() == Integer.parseInt(phoneNumber)){
                return account.getContact().getEmailAddress();

            }
        }

        return null;
    }

    //QUIT = -1, LOGOUT = 0, WRITE_EMAIL = 1, CHECK_INBOX = 2, CHECK_UNREAD = 3, DELETE_EMAIL = 4, CHECK_SPAM = 5;

}
