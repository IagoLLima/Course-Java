package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Department;
import model.entities.HourContract;
import model.entities.Worker;
import model.entities.enums.WorkerLevel;

public class ProgramWorker {
  public static void main(String[] args) throws ParseException {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner (System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    

    System.out.println("Enter department's name:");
    String departmentName = sc.nextLine();
    System.out.println("Enter worker data: ");
    System.out.print("name: ");
    String workerName = sc.nextLine();
    System.out.print("Level: ");
    String workerLevel = sc.nextLine();
    System.out.print("Base salary: ");
    double workerBaseSalary = sc.nextDouble();
    System.out.println();
    Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),workerBaseSalary, new Department(departmentName));
    System.out.print("How many contracts to this worker?");
    int n = sc.nextInt();

    for (int i=1; i<=n; i++){
      System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (yyyy-MM-dd): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
    }

    System.out.print("Enter month and year to calculate income (MM-YYYY): ");

    String monthAndYear = sc.next();

    int month = Integer.parseInt(monthAndYear.substring(0, 2));
    int year = Integer.parseInt(monthAndYear.substring(3));
    
    System.out.printf("Name: %s \nDepartment: %s \nIncome for %s: $ %.2f",worker.getName(), worker.getDepartment().getName(),monthAndYear   ,worker.income(year, month));

    sc.close();
  }
}
