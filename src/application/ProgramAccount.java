package application;

import java.util.Locale;
import java.util.Scanner;

import entities.BusinessAccount;

public class ProgramAccount {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner (System.in);

    System.out.println("Informar dados da conta");
    System.out.print("Número da conta: ");
    int number = sc.nextInt();
    System.out.print("Nome do Titular: ");
    String holder = sc.next();
    System.out.print("Deposito Inicial: ");
    double balance = sc.nextDouble();
    System.out.print("Limite de crédito: ");
    double loanLimit = sc.nextDouble();
    BusinessAccount bussinessAccount = new BusinessAccount(number, holder, balance, loanLimit);
    System.out.print("Valor de deposito: ");
    double amount = sc.nextDouble();
    bussinessAccount.deposit(amount);
    System.out.print("Valor de saque: ");
    amount = sc.nextDouble();
    bussinessAccount.withdraw(amount);
    System.out.print("Valor de empréstimo: ");
    amount = sc.nextDouble();
    bussinessAccount.loanLimit(amount);
    System.out.println(bussinessAccount+". Limit used: $"+String.format("%.2f", amount));

    sc.close();

  }

}
