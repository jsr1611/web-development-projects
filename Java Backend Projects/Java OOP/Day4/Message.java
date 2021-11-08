/*
Author: Jumanazar Saidov
Date: 2021.11.03
Definition:
Accommodate email message related properties such as subject, message itself, sender, receiver(s), readStatus, etc.

 */
package OOP.Day4;

import java.util.Arrays;

public class Message {
    private String subject;
    private String message;
    private Contact sender;
    private Contact[] receivers;
    private boolean receiptStatus;
    private boolean readStatus;
    private String dateTime;

    public Message(String subject, String message, Contact sender, Contact[] receivers, String dateTime) {
        this.subject = subject;
        this.message = message;
        this.sender = sender;
        this.receivers = receivers;
        this.dateTime = dateTime;
        this.readStatus = false;
        this.receiptStatus = false;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public Contact[] getReceivers() {
        return receivers;
    }
    public String[] getReceiverEmails(){
        String[] result = new String[receivers.length];
        int count=0;
        for(Contact receiver : receivers){
            result[count++] =  receiver.getEmailAddress();
        }
        return result;
    }

    public void setReceivers(Contact[] receivers) {
        this.receivers = receivers;
    }

    public boolean isReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(boolean receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;

    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Subject: " + subject + "\n" +
                "Message: " + message + "\n" +
                "Sender: " + sender.getEmailAddress() + "\n" +
                "Receivers: " + Arrays.toString(getReceiverEmails()) + "\n" +
                "ReceiptStatus: " + (receiptStatus ? "yes" : "not") + "\n" +
                "ReadStatus: " + (readStatus ? "read" : "unread") + "\n" +
                "Date: " + dateTime;
    }
}
