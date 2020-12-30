package entities;

public class Employee {
  private String name;
  protected Integer hours;
  protected Double valorPerHour;

  public Employee (){}

  public Employee(String name, Integer hours, Double valorPerHour) {
    this.name = name;
    this.hours = hours;
    this.valorPerHour = valorPerHour;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getHours() {
    return hours;
  }

  public void setHours(Integer hours) {
    this.hours = hours;
  }

  public Double getValorPerHour() {
    return valorPerHour;
  }

  public void setValorPerHour(Double valorPerHour) {
    this.valorPerHour = valorPerHour;
  }

  public double payment (){
    return valorPerHour*hours;
  }
  
}
