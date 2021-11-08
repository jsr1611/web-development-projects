/*
Author: Jumanazar Saidov
Date: 2021.11.03
Definition:
Accommodate Email account properties such as message, contact, stack of inbox, outbox, spam, etc.

 */

package OOP.Day4;

import java.util.Stack;

public class Email {
    private Contact contact;
    private Message message;
    private Stack<Message> outbox;
    private Stack<Message> inbox;
    private Stack<Message> spam;
    private Stack<Message> bin;
    public Email(Contact contact){
        this.contact = contact;
        this.outbox = new Stack<>();
        this.inbox = new Stack<>();
        this.spam = new Stack<>();
        this.bin = new Stack<>();
    }

    public Email(Contact contact, Stack<Message> outbox, Stack<Message> inbox, Stack<Message> spam) {
        this.contact = contact;
        this.outbox = outbox;
        this.inbox = inbox;
        this.spam = spam;
        this.bin = new Stack<>();
    }
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Stack<Message> getOutbox() {
        return outbox;
    }

    public void pushOutbox(Message outbox) {
        this.outbox.push(outbox);
    }

    public Stack<Message> getInbox() {
        return inbox;
    }

    public Stack<Message> getInboxUnread(){
        Stack<Message> unread = new Stack<>();
        for(Message message : inbox){
            if(!message.isReadStatus()){
                unread.push(message);
            }
        }
        return unread;
    }

    public void pushInbox(Message inboxMsg) {
        this.inbox.push(inboxMsg);
    }


    public Stack<Message> getSpam() {
        return spam;
    }

    public void setSpam(Stack<Message> spam) {
        this.spam = spam;
    }

    public void setOutbox(Stack<Message> outbox) {
        this.outbox = outbox;
    }

    public void setInbox(Stack<Message> inbox) {
        this.inbox = inbox;
    }

    public Stack<Message> getBin() {
        return bin;
    }

    public void setBin(Stack<Message> bin) {
        this.bin = bin;
    }
}
