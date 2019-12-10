public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Deutsche Bank");
        if (bank.addBranch("Berlin")){
            System.out.println("Berlin is created");
        }
        bank.addCustomer("Berlin", "Andrew", 50.05);
        bank.addCustomer("Berlin", "Tristan", 175.34);
        bank.addCustomer("Berlin", "Robin", 220.12);


        bank.addBranch("München");
        bank.addCustomer("München", "Jansen", 150.54);


        bank.addCustomerTransaction("Berlin", "Andrew", 44.22);
        bank.addCustomerTransaction("Berlin", "Andrew", 12.44);
        bank.addCustomerTransaction("Berlin", "Andrew", 1.65);

        bank.listCustomers("Berlin",true);
        bank.listCustomers("München", true);

        bank.addBranch("Kaiserlautern");
        if (!bank.addCustomer("Kaiserlautern", "Kobe", 5.53)){
            System.out.println("Error kaiserlautern doesnt exist");
        }

        if (!bank.addBranch("Berlin")){
            System.out.println("The Berlin already exist");
        }

        if (!bank.addCustomerTransaction("Berlin", "Voeller", 50.00)){
            System.out.println("Customer does not exist at branch");
        }

        if (!bank.addCustomer("Berlin", "Andrew", 100.00)) {
            System.out.println("Andrew does exist");
        }
    }
}
