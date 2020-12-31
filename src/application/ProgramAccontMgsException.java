package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class ProgramAccontMgsException {

  public static void main(String[] args) {
  
  try {  
  Locale.setDefault(Locale.US);  
  Scanner sc = new Scanner (System.in);

  System.out.println("Enter account data: ");
  
  System.out.print("Number: ");
  int number = sc.nextInt();
  sc.nextLine();
  System.out.print("Holder: ");
  String holder = sc.nextLine();
  System.out.print("Initial balance: ");
  double balance = sc.nextDouble();
  System.out.print("Withdraw limit: ");
  double withdrawLimit = sc.nextDouble();
  System.out.println();

  Account account = new Account(number, holder, balance,withdrawLimit);

  System.out.print("Enter amount for withdraw: ");

  double withdraw = sc.nextDouble();
  account.withdraw(withdraw);

  System.out.println();
  System.out.println("New balance: $"+account.getBalance());


  sc.close();
  }
  catch (DomainException e){
    System.out.println(e.getMessage());
  }
  catch (RuntimeException e) {
    System.out.println("Unexpected error");
  }

  }

}
