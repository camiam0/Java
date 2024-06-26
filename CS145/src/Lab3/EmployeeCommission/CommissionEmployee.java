package Lab3.EmployeeCommission;

public class CommissionEmployee extends Employee {
    private double grossSales; // gross weekly sales       
    private double commissionRate; // commission percentage

    // five-argument constructor
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        // implicit call to Object constructor occurs here

        // if grossSales is invalid throw exception
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }

        // if commissionRate is invalid throw exception
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    // return gross sales
    public double getGrossSales() {
      return grossSales;
    }

    // return commission rate
    public double getCommissionRate() {
        return commissionRate;
    }

    // set gross sales
    public void setGrossSales(double grossSales) {
      if (grossSales < 0.0) {
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
     }
     this.grossSales = grossSales;
    }

    // set commission rate
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
        this.commissionRate = commissionRate;
    }

    // calculate earnings
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    // return String representation of CommissionEmployee object
    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(), getLastName(),
                "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(), "commission rate",
                getCommissionRate());
    }
}