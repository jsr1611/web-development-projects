package OOP.Day4;

import java.util.Arrays;

public class EmailSystem {
    Email[] emailAccounts;
    public EmailSystem(Email[] emailAccounts){
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
        Email emailAccount = null;
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
        if(countSuccess > 0){
            System.out.println(success);
        }
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

    public void displayMenu(){
        System.out.println("----------------MENU----------------\n");
        System.out.println("1 - Write new email (yangi xat yozish)");
        System.out.println("2 - Check Inbox (Kelgan barcha xatlarni ko'rish)");
        System.out.println("3 - Check Unread (Faqat yangi kelgan xatlarni ko'rish )");
        System.out.println("4 - Delete Email (Email xatni o'chirish)");
        System.out.println("5 - Check Spam (Spam xatlarni ko'rish)");
        System.out.println("0 - Logout (hisobdan chiqish)");
        System.out.println("-1 - Quit (dasturdan chiqish)");
        System.out.print("Please, enter the number of the operation you want: ");
    }

    //QUIT = -1, LOGOUT = 0, WRITE_EMAIL = 1, CHECK_INBOX = 2, CHECK_UNREAD = 3, DELETE_EMAIL = 4, CHECK_SPAM = 5;

}
