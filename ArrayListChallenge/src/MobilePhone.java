import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts =  new ArrayList<Contact>();
    }

    /** find contact **/
    private int findContact(Contact contact){
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i = 0; i < this.contacts.size(); i++){
            Contact contact = this.contacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }

        return -1;
    }


    /** Add contact **/
    public boolean addContact(Contact contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("The contact is already in the file");
            return false;
        }else {
            this.contacts.add(contact);
            return true;
        }
    }

    /** Updated Contact **/
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPositionOfContact = findContact(oldContact);
        if (foundPositionOfContact < 0){
            System.out.println(oldContact.getName() + " was not found in list");
            return false;
        } else if(findContact(newContact.getName()) != -1){
            System.out.println("The " + newContact.getName() + " has the same name.");
            return false;
        }
        this.contacts.set(foundPositionOfContact, newContact);
        System.out.println(oldContact.getName() + " is replaced with: "+ newContact.getName());
        return true;
    }

    /** Removed Contact **/
    public boolean removeContact(Contact contact){
        int foundPositionOfContact = findContact(contact);
        if (foundPositionOfContact < 0){
            System.out.println(contact.getName() + " was not found.");
            return false;
        }
        this.contacts.remove(foundPositionOfContact);
        return true;

    }

    /** Query Contact **/
    public String queryContact(Contact contact){
        if (findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String contact){
        int position = findContact(contact);
        if (position >= 0){
            return this.contacts.get(position);
        }
        return null;
    }

    /** Print the contacts **/
    public void printContactsFromMobile(){
        System.out.println("The list of contact: ");
        for (int i =0; i < this.contacts.size(); i++){
            System.out.println(this.contacts.get(i).getName() + " ---->" + this.contacts.get(i).getPhoneNumber());
        }
    }

}
