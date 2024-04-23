/*Cam's Lab 2
 * for extra credit I utilize file.io, I use this., and I use array lists
 * I also used the package declaration
 * also check out my use of something new, I learned how to serialize my data
 * main is sexily small
 * I used ChatGPT and Kevin (my classmate) to guide me
 */

package Lab2.HeartRate;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private ArrayList<UserInfo> users;
    private UserDataManager dataManager;
    // scanner for the menu
    Scanner console = new Scanner(System.in);
    // scanner for updating user info
    Scanner input = new Scanner(System.in);

    // main method
    public static void main(String[] args) {
        UserInterface calculator = new UserInterface();
        calculator.menu();
        calculator.closeConsole();
        calculator.closeInput();
    } // end of main
    
    // method for user navigation
    public void menu() {
        boolean menuflag = false;
        char menuinput;

        do {
            System.out.printf("Please type a command: %n" +
                              "   \"u\" to add a user.%n" +
                              "   \"d\" to display user info.%n" +
                              "   \"q\" to quit the program.%n");
            menuinput = console.next().charAt(0);
            switch (menuinput) {
                case 'u':
                    userInfoUpdater();
                    break;
                case 'd':
                    loadUserData();
                    if (users.isEmpty()) {
                        System.out.println("Error, user info fields are empty! Please update user info.");
                    }
                    displayUserInfo();
                    break;
                case 'q':
                    System.out.println("Goodbye.");
                    menuflag = true;
                    break;
                default:
                    break;
            } 
        } while (!menuflag);
    } // end of menu

    // adds a user
    public void userInfoUpdater() {
        System.out.println("Please enter your first name.");
        String firstName = input.nextLine();
        System.out.println("Please enter your last name.");
        String lastName = input.nextLine();
        System.out.println("Please enter your birth year.");
        int birthYear = input.nextInt();
        input.nextLine(); // Consume newline character
        UserInfo user = new UserInfo(firstName, lastName, birthYear);
        users.add(user);
        saveUserData();
    } // end of userInfoUpdater

    public void displayUserInfo() {
        if (users.isEmpty()) {
            System.out.println("No user information available.");
        } else {
            System.out.println("User Information:");
            for (UserInfo user : users) {
                System.out.println("First Name: " + user.getFirstName());
                System.out.println("Last Name: " + user.getLastName());
                System.out.println("Age: " + user.getAge());
                System.out.println("Maximum Heart Rate: " + user.getMaxHeartRate());
                System.out.println("Target Heart Rate Max: " + user.getTargetMax());
                System.out.println("Target Heart Rate Min: " + user.getTargetMin());
            }
        }
    } // end of displayUserInfo

    // method for data manager and file path for userdata.dat file
    public UserInterface() {
        users = new ArrayList<>();
        String filePath = "C:/Users/camer/Documents/CS145/Lab 2/HeartRate/src/Lab2/HeartRate/userdata.dat";
        dataManager = new UserDataManager(filePath);
    } // end of data manager

    // saves a users data
    public void saveUserData() {
        dataManager.saveUserData(users);
    } // end of saveUserData

    // loads a users data
    public void loadUserData() {
        users = dataManager.loadUserData();
    } // end of loadUserData

    // scanner closing methods
    public void closeConsole() {console.close();}
    public void closeInput() {input.close();}
} // end of class