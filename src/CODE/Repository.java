package CODE;

public class Repository {
    // data base curd operations
    public  static void RegisterCustomer(Customer customer){
        VirtualDatabase.CustomerDatabase.add(customer);
    }


}
