package entities;

public class BusinessAccount extends Account {
  private double loanLimit;

  public BusinessAccount() {
    super();
  }

  public BusinessAccount(double loanLimit) {
    this.loanLimit = loanLimit;
  }

  public BusinessAccount(int number, String holder, double balance, double loanLimit) {
    super(number, holder, balance);
    this.loanLimit = loanLimit;
  }

  public double getLoanLimit() {
    return loanLimit;
  }

  public void setLoanLimit(double loanLimit) {
    this.loanLimit = loanLimit;
  }

  public void loanLimit(double amount) {
    if (amount <= loanLimit) {
      balance += amount - 10;
    }
  }

  public static void main(String[] args) {

    Account acc1 = new Account(1001, "Alex", 1000.0);
    acc1.withdraw(200.0);
    System.out.println(acc1.getBalance());

    Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
    acc2.withdraw(200.0);
    System.out.println(acc2.getBalance());

    Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
    acc3.withdraw(200.0);
    System.out.println(acc3.getBalance());
  }

  @Override
  public void withdraw(double amount) {
    super.withdraw(amount); // vai ser reaproveitado a regra da classe Account
    balance -= 2.0;  // da regra da classe Account, com essa variavel vai ser descontado mais 2
  }

  public String toString() {
    return "BussinessAccount [" + "Holder= " + getHolder() + ", " + "Number Account= " + getNumber() + ", "
        + "loanLimit= $" + String.format("%.2f", loanLimit) + " and " + "Balance= $"
        + String.format("%.2f", getBalance()) + "," + "]";
  }

}
