import java.util.ArrayList;
import java.util.HashMap;

public class Customer {


    private String firstName;
    private String lastName;
    private int pin;

    //Change from ArrayList to HashMap
    private HashMap<Integer, Account> accountHashMap = new HashMap<>();

    public Customer(String firstName, String lastName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public int getPin(){
        return pin;
    }
    //public int setPin() {
    //this.pin = pin;
    //}

    public void addAccount(Account account) {
        accountHashMap.put(account.getAccNum(), account);
    }
    public void closeAccount(Account account) {
        accountHashMap.remove(pin, account);
    }

    public Account getAccount(int pin) {
        return accountHashMap.get(pin);
    }

 /*
    public Account getAccount(int accNum) {
        Account foundAccount = null;
        for (Account account: accountHashMap) {
            if (account.getAccNum() == accNum) {
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }
  */
    public StringBuilder getAllAccounts() {
        StringBuilder accountStringBuilder = new StringBuilder();
        for (HashMap.Entry<Integer, Account> entry : accountHashMap.entrySet()) {
            Integer key = entry.getKey();
            Account value = entry.getValue();
            accountStringBuilder.append("Account number: " + key + "\nAccount: " + value);
        }
        return accountStringBuilder;
    }

    @Override
    public String toString() {
        return String.format("You are " + firstName + " " + lastName + ". Your pin number is " + pin + ".");
    }

}
