public class BankAccount {

    public static String bankName = "Liceo Bank";
    public static double interestRate = 0.03; // 3%
    public static int totalAccounts = 0;
    private static int nextAccountNumber = 1;


    private String accountNumber;
    private String accountHolderName;
    private double balance;

    
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountNumber = String.format("ACC%03d", nextAccountNumber++);
        totalAccounts++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }
}
