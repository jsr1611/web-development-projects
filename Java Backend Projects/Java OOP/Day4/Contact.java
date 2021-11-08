/*
Author: Jumanazar Saidov
Date: 2021.11.03
Definition:
Accommodate user account properties such as name, emailAddress, password, country, phoneNumber, etc.

 */
package OOP.Day4;

public class Contact {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String country;
    private String phoneNumber;
    private String secretKey;
    private String secretKeyHint;
    public Contact(){}

    public Contact(String firstName, String lastName, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        country = "";
        phoneNumber = "";
        secretKey = "";
        secretKeyHint = "";
    }

    public Contact(String firstName, String lastName,String emailAddress, String password, String country, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    public String getSecretKey(){
        return secretKey;
    }
    @Override
    public String toString() {
        return "Contact details\n" +
                "First name:\t'" + firstName + '\'' +
                "\nLast name:\t'" + lastName + '\'' +
                "\nEmail address:\t'" + emailAddress + '\'' +
                "\nPassword:\t'" + password + '\'' +
                "\nSecret key:\t'" + secretKey + '\'' +
                "\nHint:\t'" + secretKeyHint + '\'' +
                "\nCountry:\t'" + country + '\'' +
                "\nPhone number:\t'" + phoneNumber + '\'' +
                "\n";
    }

    public void setSecretKeyHint(String secretKeyHint) {
        this.secretKeyHint = secretKeyHint;
    }
    public String getSecretKeyHint(){
        return secretKeyHint;
    }
}
