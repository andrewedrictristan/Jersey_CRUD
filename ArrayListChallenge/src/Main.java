import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("+4917662680870");


    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit){
            System.out.println("\n Enter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContactsFromMobile();
                    break;
                case 2:
                    addMainContact();
                    break;
                case 3:
                    updateMainContact();
                    break;
                case 4:
                    removeMainContact();
                    break;
                case 5:
                    queryMainContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void startPhone(){
        System.out.println("Starting the phone ..........");
    }

    private static void addMainContact(){
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the number: ");
        String phone = scanner.nextLine();
        Contact newContact =new Contact(name,phone);
        if (mobilePhone.addContact(newContact)){
            System.out.println("The name " + name + " and the number " + phone + " has been added to contact");
        }else {
            System.out.println(name + " is already existed");
        }
    }

    private static void  updateMainContact(){
        System.out.println("Enter existing contact name: ");
        String name= scanner.nextLine();
        Contact existingAccount  = mobilePhone.queryContact(name);
        if (existingAccount == null){
            System.out.println("The contact is not existed in the list");
            return;
        }else {
            System.out.println("Enter the new name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter the phone number: ");
            String newPhoneNumber = scanner.nextLine();
            Contact newContactNameAndNumber = new Contact(newName, newPhoneNumber);
            if (mobilePhone.updateContact(existingAccount, newContactNameAndNumber)){
                System.out.println("Contact has been added");
            }else {
                System.out.println("Cant add the contact");
            }
        }
    }

    private static void removeMainContact(){
        System.out.println("Enter existing contact name: ");
        String name= scanner.nextLine();
        Contact existingAccount  = mobilePhone.queryContact(name);
        if (existingAccount == null){
            System.out.println("The contact is not existed in the list");
            return;
        }else {
            mobilePhone.removeContact(existingAccount);
            System.out.println("The contact has been removed successfully");
        }
    }

    private static void queryMainContact(){
        System.out.println("Enter existing contact name: ");
        String name= scanner.nextLine();
        Contact existingAccount  = mobilePhone.queryContact(name);
        if (existingAccount == null){
            System.out.println("The mentioned contact is not found");
        }
        else {
            System.out.println("name: " + existingAccount.getName() + " and phone: "+  existingAccount.getPhoneNumber() + " is found.");
        }
    }

    private static void printActions(){
        System.out.println("Choose one of the options below: ");
        System.out.println("0 - To shutdown \n" +
                            "1 - To print contacts \n" +
                            "2 - To add new contact \n" +
                            "3 - To update an existing contact \n"+
                            "4 - To remove and existing contact \n" +
                            "5 - Query if an existing contact exists \n" +
                            "6 - To print the list of actions");
    }




}
