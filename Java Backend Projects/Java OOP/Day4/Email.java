package OOP.Day4;

public class Email {
    private Contact contact;
    private String password;
    private String[] outbox;
    private String[] inbox;
    private Boolean[] status;

    public Email(Contact contact, String password, String[] outbox, String[] inbox, Boolean[] status) {
        this.contact = contact;
        this.password = password;
        this.outbox = outbox;
        this.inbox = inbox;
        this.status = status;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getOutbox() {
        return outbox;
    }

    public void setOutbox(String[] outbox) {
        this.outbox = outbox;
    }

    public String[] getInbox() {
        return inbox;
    }

    public void setInbox(String[] inbox) {
        this.inbox = inbox;
    }

    public Boolean[] getStatus() {
        return status;
    }

    public void setStatus(Boolean[] status) {
        this.status = status;
    }
}
