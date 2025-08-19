public class Main {
    public static void main(String[] args) {

        System.out.println("Bank Name: " + BankAccount.bankName);
        System.out.println("Interest Rate: " + (BankAccount.interestRate * 100) + "%\n");


        BankAccount acc1 = new BankAccount("John Doe", 1000.0);
        System.out.printf("Account Created: %s for %s with initial balance: $%.1f\n",
                acc1.getAccountNumber(), acc1.getAccountHolderName(), acc1.getBalance());

        BankAccount acc2 = new BankAccount("Jane Smith", 2500.0);
        System.out.printf("Account Created: %s for %s with initial balance: $%.1f\n",
                acc2.getAccountNumber(), acc2.getAccountHolderName(), acc2.getBalance());

        BankAccount acc3 = new BankAccount("Bob Johnson", 500.0);
        System.out.printf("Account Created: %s for %s with initial balance: $%.1f\n",
                acc3.getAccountNumber(), acc3.getAccountHolderName(), acc3.getBalance());


        System.out.println("\n═══ Account Operations ═══");
        acc1.deposit(500.0);
        System.out.printf("%s deposited $500.0. New balance: $%.1f\n",
                acc1.getAccountHolderName(), acc1.getBalance());

        boolean withdrew = acc2.withdraw(300.0);
        if (withdrew) {
            System.out.printf("%s withdrew $300.0. New balance: $%.1f\n",
                    acc2.getAccountHolderName(), acc2.getBalance());
        } else {
            System.out.printf("%s attempted to withdraw $300.0. Insufficient funds.\n",
                    acc2.getAccountHolderName());
        }

        System.out.println("\n═══ Interest Calculation ═══");
        System.out.printf("%s's interest: $%.1f\n", acc1.getAccountHolderName(), acc1.calculateInterest());
        System.out.printf("%s's interest: $%.1f\n", acc2.getAccountHolderName(), acc2.calculateInterest());
        System.out.printf("%s's interest: $%.1f\n", acc3.getAccountHolderName(), acc3.calculateInterest());

        System.out.println("\nTotal Accounts Created: " + BankAccount.totalAccounts);
    }
}
