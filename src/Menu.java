import java.util.Scanner;
public class Menu {


    private Scanner scnr = new Scanner(System.in);
    private Bank bank = new Bank();

    public void displayMenu() {
        while (true) {
            String selection;
            System.out.println("\n* * * * * * * * MENU * * * * * * * *\n");
            System.out.print("Please make a selection:\n" +
                    "1) Access Account\n" +
                    "2) Open a New Account\n" +
                    "3) Close all Accounts\n" +
                    "4) Exit\n" +
                    ">>");

            selection = scnr.nextLine();

            if (selection.equals("1")) {
                accessAccount();
            } else if (selection.equals("2")) {
                newAccount();
            } else if (selection.equals("3")) {
                closeAccounts();
            } else if (selection.equals("4")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid entry");

            }
        }
    }

    private void accessAccount() {
        System.out.println("Enter your individual PIN Number: ");
        int pin = Integer.parseInt(scnr.nextLine());
        Customer userInput = bank.getCustomer(pin);
        if (userInput == null) {
            System.out.println("PIN is not valid.");
            return;
        } else {
            System.out.println("PIN identified. Accounts:" +
                    " " + userInput.getAllAccounts());

        }
        System.out.println("Enter the account number you would like to view");
        int accNum = Integer.parseInt(scnr.nextLine());
        Account account = userInput.getAccount(accNum);
        if (account == null) {
            System.out.println("Account number invalid");
            return;
        } else {
            System.out.println("Please make a selection");
            System.out.println("-----------------------");
            System.out.println("1. Make a deposit");
            System.out.println("2. Make a withdraw");
            System.out.println("3. See account balance");
            System.out.println("4. Close account");
            System.out.println("5. Exit");
            System.out.print(">>");
        }

        int input = Integer.parseInt(scnr.nextLine());

        if (input == 1) {
            System.out.println("How much would you like to deposit?");
            double depositAmount = Double.parseDouble(scnr.nextLine());
            account.deposit(depositAmount);
        } else if (input == 2) {
            System.out.println("How much would you like to withdraw?");
            double withdrawAmount = Double.parseDouble(scnr.nextLine());
            account.withdraw(withdrawAmount);
        } else if (input == 3) {
            System.out.println(account.toString());
        } else if (input == 4) {
            userInput.closeAccount(account);
            System.out.println("Account has been closed");
        } else if (input == 5) {
            System.out.println("Exiting...");
            return;
        } else {
            System.out.println("Invalid entry");
        }
    }
    private void newAccount() {
        Customer customer = null;
        System.out.println("Are you a new customer? (yes/no)");
        String input = scnr.nextLine();
        if (input.equals("yes")) {
            customer = createNewCustomer();
        } else if (input.equals("no")); {
            System.out.println("Enter PIN number: ");
            int pinInput = Integer.parseInt(scnr.nextLine());
            customer = bank.getCustomer(pinInput);
            if (customer == null) {
                return;
            }
            System.out.println("How much would you like to deposit into the new account?");
            double depAmount = Double.parseDouble(scnr.nextLine());
            Account account = new Account(depAmount);
            customer.addAccount(account);
            System.out.println("New Account Opened: " + account.getAccNum());

        }
    }

    private Customer createNewCustomer() {
        Customer customer = null;
        System.out.println("Enter your first name: ");
        String firstName = scnr.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scnr.nextLine();
        System.out.println("Enter your new PIN number: ");
        int pin = Integer.parseInt(scnr.nextLine());
        System.out.println("Would you like to be a VIP Customer? 1. Yes      2. No");
        int input = Integer.parseInt(scnr.nextLine());
        if (input == 1) {
            customer = new VIPcustomer(100, firstName, lastName, pin);
            System.out.print("You have received 100 VIP Points!\n");
        }
        else if (input == 2)
            customer = new Customer(firstName, lastName, pin);
        else {
            return customer;
        }
        bank.addCustomer(customer);
        return customer;
    }

    private void closeAccounts() {
        System.out.println("\nEnter your PIN number: ");
        int pin = Integer.parseInt(scnr.nextLine());
        Customer customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("Invalid PIN number");
            return;
        }
        bank.removeCustomer(customer);
        System.out.println("Customer has been removed");

    }

}
