package Lab2.HeartRate;

import java.io.Serializable;
import java.time.Year;

public class UserInfo implements Serializable {

    private String firstName;
    private String lastName;
    private int birthYear;
    private int currentYear = Year.now().getValue();
    private int age;
    private int maxHeartRate;
    private int[] targetHeartRates;
    

    // Constructor
    public UserInfo(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.age = calculateAge();
        this.maxHeartRate = calculateMaxHeartRate();
        this.targetHeartRates = calculateTargetHeartRates();
    }

    // Calculates a user's age
    private int calculateAge() {
        return currentYear - birthYear;
    }

    // Calculates maximum heart rate
    private int calculateMaxHeartRate() {
        return 220 - age;
    }

    // Calculates target heart rates
    private int[] calculateTargetHeartRates() {
        int max = (int) (maxHeartRate * 0.85);
        int min = (int) (maxHeartRate * 0.5);
        return new int[] { max, min };
    }

    // Getter methods
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getAge() {return age;}
    public int getMaxHeartRate() {return maxHeartRate;}
    public int getTargetMax() {return targetHeartRates[0];}
    public int getTargetMin() {return targetHeartRates[1];}

} // end of class