package OOP.Day4;

import java.util.Scanner;

public class EmailApplicationDemo {
    public static void main(String[] args) {
        Contact contact0 = new Contact("Jumanazar", "Saidov", "jumanazarsaidov@gmail.com");
        Contact contact1 = new Contact("Hamza", "K.", "khamza@gmail.com");
        Contact contact2 = new Contact("Jamshiddin", "Babajonov", "jamshiddin@gmail.com");
        Contact contact3 = new Contact("Nur", "Saidov", "nursaid@gmail.com");
        Contact contact4 = new Contact("Solih", "Farhodov", "solihfarhod@gmail.com");
        Contact[] contacts = {contact0, contact1, contact2, contact3, contact4};
        Email email = new Email(contact0, "jumanazar123$$$", new String[50], new String[50], new Boolean[50]);
        Email email1 = new Email(contact1, "hamza123$$", new String[50], new String[50], new Boolean[50]);
        Email email2 = new Email(contact2, "jamshiddin123$$", new String[50], new String[50], new Boolean[50]);
        Email email3 = new Email(contact3, "nur123$$", new String[50], new String[50], new Boolean[50]);
        Email email4 = new Email(contact4, "solih123$$", new String[50], new String[50], new Boolean[50]);

        Email[] emails = {email, email1, email2, email3, email4};
        Scanner scanner = new Scanner(System.in);
        final int QUIT = -1, LOGOUT = 0, CHECK_INBOX = 1, WRITE_EMAIL = 2, DELETE_EMAIL = 3;
        while(true){

            String username = "", password = "";
            System.out.print("Please, enter your email address:");
            username = scanner.next();
            System.out.print("Please, enter your password:");
            password = scanner.next();

            if(scanner.nextInt() == QUIT){
                System.out.println("Bye");
                return;
            }

        }


    }
}
