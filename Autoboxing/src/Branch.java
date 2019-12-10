import java.util.ArrayList;

public class Branch {

    private ArrayList<Customer> customers;
    private String name;

    public Branch(String name){
        this.name=name;
        this.customers = new ArrayList<Customer>();
    }


    //GETTERS
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    //METHODS

    public Customer findCustomer(String name){
        for (int i=0; i<this.customers.size();i++){
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(name)){
                return checkedCustomer;
            }
        }
        return null;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if (findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }else {
            return false;
        }
    }

    public boolean addAdditionalTransactions(String name, double amount){
        Customer existedCustomer = findCustomer(name);
        if (existedCustomer != null){
            existedCustomer.addTransactions(amount);
            return true;
        }else {
            return false;
        }
    }
}
