import java.util.ArrayList;
import java.util.function.DoubleUnaryOperator;

public class Bank {

    private ArrayList <Branch> branches;
    private String name;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    //Methods
    private Branch findBranch(String branchName){
        for (int i = 0; i < this.branches.size(); i++){
            Branch existedBranch = this.branches.get(i);
            if (existedBranch.getName().equals(branchName)){
                return existedBranch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        else return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch checkedBranches = findBranch(branchName);
        if (branchName != null){
            return checkedBranches.newCustomer(customerName,initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch checkedBranches = findBranch(branchName);
        if (checkedBranches != null){
            return checkedBranches.addAdditionalTransactions(customerName,amount);
        }else return false;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch= findBranch(branchName);
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size();i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer "+ branchCustomer.getName() + " ["+ (i+1)+"]. ");
                if (showTransactions){
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++){
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j) );
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }

}
