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

    public Email(Contact contact, Stack<Message> outbox, Stack<Message> inbox, Stack<Message> spam) {
        this.contact = contact;
        this.outbox = outbox;
        this.inbox = inbox;
        this.spam = spam;
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
}