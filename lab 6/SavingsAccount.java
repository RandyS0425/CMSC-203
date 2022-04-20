public class SavingsAccount  extends BankAccount{
    private double rate = 0.025;
    private static int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String name, int initialBalance) {
        super(name,initialBalance);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
        savingsNumber++;
    }
    public void postInterest() {
        super.deposit(getBalance() * (rate / 12));
    }
    public SavingsAccount(SavingsAccount savAcc, int balance) {
        super(savAcc,balance);

        this.accountNumber = super.getAccountNumber() +"-" + savingsNumber;
        savingsNumber++;
    }
}
