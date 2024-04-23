package Lab3.EmployeeCommission;

public class Employee {
    protected final String firstName;
    protected final String lastName;
    protected final String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    } // end of Employee constructor

    // returns first name
    public String getFirstName() {
        return firstName;
    }
    
    // returns last name
    public String getLastName() {
        return lastName;
    }
    
    // returns social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    
}

