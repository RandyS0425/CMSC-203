public class CheckingAccount extends BankAccount{
      static double FEE = 0.15;

      public CheckingAccount(String name, int initialAmount){
          super(name,initialAmount);
          this.setAccountNumber(getAccountNumber() + "-10");
      }
      @Override
    public boolean withdraw(double amount) {
          amount += FEE;
       return super.withdraw(amount);
      }

}
