package variables.OOP_Practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ContactsManager myContactsManager = new ContactsManager();
        Contact friend1 = new Contact();
        friend1.name = "Jamshiddin";
        friend1.email = "jbm050690@gmail.com";
        friend1.phoneNumber = "+79016823053";

        Contact friend2 = new Contact();
        friend2.name = "Ali";
        friend2.email = "alihamid@cbnu.ac.kr";
        friend2.phoneNumber = "+821096134550";

        myContactsManager.addContacts(friend1);
        myContactsManager.addContacts(friend2);

        System.out.print("Enter the name of contact: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Contact result = myContactsManager.searchContact(name);
        if(result != null){
            System.out.printf(String.format("Contact details:\n Name: %s\n Email: %s\n Phone Number: %s", result.name, result.email, result.phoneNumber));
        }
        else {
            System.out.printf("Oops. Contact couldn't be found with the given name.");
        }
    }
}
