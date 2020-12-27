package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
  
  
  private String name;
  private WorkerLevel level;
  private Double baseSalary;

  private Department department; //um departamento por worker
  private List<HourContract> contracts = new ArrayList<>(); ///várioas contratos por worker. Lista pode ser já instaciada na classe

  public Worker (){}

  public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public void setLevel(WorkerLevel level) {
    this.level = level;
  }

  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public List<HourContract> getContracts() {
    return contracts;
  }

  /*public void setContracts(List<HourContract> contracts) {
    this.contracts = contracts;
  }*/ // Não pode colocar o set para a lista, pois do jeito que está permiti troca da lista de contratos do trabalhador

  public void addContract(HourContract contract){
    contracts.add(contract);
  }

  public void removeContract(HourContract contract){
    contracts.remove(contract);
  }

  public double income (int year, int month){
    
    double sum = baseSalary;
    Calendar cal = Calendar.getInstance();

    for (HourContract eachContract : contracts) {
      cal.setTime(eachContract.getDate());
      int c_year = cal.get(Calendar.YEAR);
      int c_month = 1+cal.get(Calendar.MONTH);//acrescentado 1, pois o mês no Calendar começa com 0
      if (year == c_year && month == c_month){
        sum += eachContract.totalValue();
      }
    }
    return sum;
  }

}
