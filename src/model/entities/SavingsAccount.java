package model.entities;

public final class SavingsAccount extends Account{ // com final na Classe, não permiti gerar subsclasses dela
  
  private Double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() { 
		balance += balance * interestRate;
  }
  
  @Override // para subscrever a superclasse
  public final void withdraw (double amount){ //com método final, ele não poderá ser subscrito em outras classes0
    balance -= amount;
  }

}