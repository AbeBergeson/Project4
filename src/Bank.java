import java.util.ArrayList;
import java.util.HashMap;
public class Bank {

    private HashMap<Integer, Customer> customerHashMap = new HashMap();
    public void addCustomer(Customer customer) {
        customerHashMap.put(customer.getPin(), customer);
    }
    public void removeCustomer(Customer customer) {
        customerHashMap.remove(customer.getPin());
    }

    public Customer getCustomer(int pin) {
        return customerHashMap.get(pin);
    }
  /*
    public Customer getCustomer (int pin) {
        Customer foundCustomer = null;
        for (Customer customer: customerArrayList) {
            if (customer.getPin() == pin) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    */
    public StringBuilder getAllCustomers() {
        StringBuilder customerStringBuilder = new StringBuilder();
        for (HashMap.Entry<Integer, Customer> entry : customerHashMap.entrySet()) {
            Integer key = entry.getKey();
            Customer value = entry.getValue();
            customerStringBuilder.append("Customer: " + key + "\nCustomer: " + value);
        }
        return customerStringBuilder;
    }

}
