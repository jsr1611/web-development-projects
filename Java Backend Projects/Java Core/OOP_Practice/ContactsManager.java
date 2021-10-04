package variables.OOP_Practice;

public class ContactsManager {
    Contact[] myFriends;
    int friendsCount;
    ContactsManager(){
        myFriends = new Contact[500];
        friendsCount = 0;
    }

    /*
    Add a contact to the Contact List
     */
    void addContacts(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount += 1;
    }

    /*
    Search a contact by Name
     */
    Contact searchContact(String searchName){
        for(int i=0; i < friendsCount; i++){
            if(myFriends[i].name.equals(searchName)){
                return myFriends[i];
            }
        }
        return null;
    }

}
