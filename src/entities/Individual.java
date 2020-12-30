package entities;

public class Individual extends TaxPayer {

  private Double healthExpenditures;

  public Individual() {
    super();
  }

  public Individual(String name, Double anualIncome, Double healthExpenditures) {
    super(name, anualIncome);
    this.healthExpenditures = healthExpenditures;
  }

  @Override
  public double tax() {
    double taxValue = 0;
    if (healthExpenditures > 0) {
      if (super.getAnualIncome() > 20000) {
        taxValue = super.getAnualIncome() * 0.25 - (healthExpenditures * 0.5);
      } else {
        taxValue = super.getAnualIncome() * 0.15 - (healthExpenditures * 0.5);
      }
    } else if (super.getAnualIncome() > 20000) {
      taxValue = super.getAnualIncome() * 0.25;
    } else {
      taxValue = super.getAnualIncome() * 0.15;
    }
    return taxValue;
  }

}
