package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Employee;
import model.entities.OutsourcedEmployee;

public class ProgramEmployeeHerancaPolimorfismo {

  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of employees: ");

    int n = sc.nextInt();

    List<Employee> listEmployees = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      System.out.println("Employee #" + i + " data:");
      System.out.print("Outsourced (y/n)? ");
      char response = sc.next().charAt(0);

      System.out.print("Name: ");
      String name = sc.next();
      System.out.print("Hours: ");
      int hours = sc.nextInt();
      System.out.print("Value per hour: ");
      double valuePerHour = sc.nextDouble();

      if (response == 'y') {
				System.out.print("Additional charge: ");
        double additionalCharge = sc.nextDouble();
				listEmployees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				listEmployees.add(new Employee(name, hours, valuePerHour));
			}

    }
    System.out.println();

    System.out.println("PAYMENTS: ");
    for (Employee employee : listEmployees) {
      System.out.println(employee.getName()+" - $ "+String.format("%.2f", employee.payment()));
      
    }
    sc.close();

  }

}
