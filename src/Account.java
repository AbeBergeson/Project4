public class Account {

    private double balance;
    private int accNum;
    private static int numberOfAccounts = 1000;

    public Account(double balance) {
        this.balance = balance;
        this.accNum = numberOfAccounts++;
    }

    public double getBalance(){
        return balance;
    }
    public int getAccNum(){
        return accNum;
    }

    public void deposit(double depositAmount) {
        balance = balance + depositAmount;
        System.out.print("You deposited " + depositAmount + ". New balance: " + balance);
    }
    public void withdraw(double withdrawAmount){
        if (balance < withdrawAmount) {
            System.out.println("You have insufficient funds. Please withdraw a different amount.");
        } else {
            balance = balance - withdrawAmount;
            System.out.println("You withdrew " + withdrawAmount + ". New balance: " + balance);
        }
    }
    @Override
    public String toString() {
        return String.format("Account number: " + accNum + "\n Balance: " + balance);
    }

}
