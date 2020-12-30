package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class ProgramExerciciClassSubtract {
  
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner (System.in);

    System.out.print("Enter the number of tax payers:");
    int n = sc.nextInt();
    List<TaxPayer> listTax = new ArrayList<>();

    for (int i=1; i<=n; i++){
      System.out.println("Tax payer #"+i+" data:");
      System.out.print("Individual or company (i/c)?");
      char response = sc.next().charAt(0);
      System.out.print("Name: ");
      String name = sc.next();
      System.out.print("Anual income: ");
      double anualIncome = sc.nextDouble();
      if (response == 'i'){
        System.out.print("Health expenditures: ");
        double healthExpenditures = sc.nextDouble();
        listTax.add(new Individual(name, anualIncome, healthExpenditures));
      }
      else {
        System.out.print("Number of employees: ");
        int numberOfEmployees = sc.nextInt();
        listTax.add(new Company(name, anualIncome, numberOfEmployees));
      }
    }

    System.out.println();
    System.out.println("TAXES PAID:");
    for (TaxPayer taxPayer : listTax) {
      System.out.println( taxPayer.getName() + ": $ "+String.format("%.2f", taxPayer.tax()));
    }

    double sum = 0;
    for (TaxPayer taxPayer : listTax) {
      sum += taxPayer.tax();     
    }
    System.out.println();
    System.out.println("TOTAL TAXES: $"+String.format("%.2f", sum)); 

    sc.close();

  }

}
