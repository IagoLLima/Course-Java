package model.entities;

import model.exceptions.DomainException;

/*public abstract class Account - inserindo o abstract na classe, faz com que ela só possa ser usada 
por herança, ou seja, no programa se instanciado a conta comum, irá dar erro.*/ 

public class Account {

  private int number;
  private String holder;
  protected double balance;
  private double withdrawLimit;

  public Account(){}

  public Account(int number, String holder, double balance) {
    this.number = number;
    this.holder = holder;
    this.balance = balance;
  }

  public Account(int number, String holder, double balance, double withdrawLimit) { //construtor da exceção
    this.number = number;
    this.holder = holder;
    this.balance = balance;
    this.withdrawLimit = withdrawLimit;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getHolder() {
    return holder;
  }

  public void setHolder(String holder) {
    this.holder = holder;
  }

  public double getWithdrawLimit() {
    return withdrawLimit;
  }

  public void setWithdrawLimit(double withdrawLimit) {
    this.withdrawLimit = withdrawLimit;
  }

  public double getBalance() {
    return balance;
  }


  public void withdraw(double amount){
    if (withdrawLimit<amount){
      throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
    }
    if (amount>balance){
      throw new DomainException("Withdraw error: Not enough balance");
    }
    balance -= amount+5;
  }

  public void deposit(double amount){
    balance += amount;
  }

}
