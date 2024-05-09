package Lab5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner console = new Scanner(System.in);
    LinkedList phonebook = new LinkedList("Phonebook");

    public static void main(String[] args){

        Main main = new Main();
        main.menu();

    } // end of main

    public void menu() {

        boolean menuflag = false;
        char menuinput;

        do {
            System.out.printf("Please type a command: %n" +
                              "   \"a\" to add someone to the phonebook.%n" +
                              "   \"r\" to remove someone from the phonebook.%n" +
                              "   \"d\" to display phonebook.%n" +
                              "   \"q\" to quit the program.%n");
            menuinput = console.next().charAt(0);
            switch (menuinput) {
                case 'a':
                    insertPerson();
                    break;
                case 'r':
                    removePerson();
                    break;
                case 'd':
                    displayPhonebook();
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

    public void insertPerson() {

        String lastName;
        String firstName;
        String address;
        int zipCode = 0;
        int phoneNum = 0;

        System.out.println("Enter last name:");
        lastName = console.next();

        System.out.println("Enter first name:");
        firstName = console.next();

        System.out.println("Enter address:");
        address = console.next();

        boolean validZipCode = false;
        do {
            
            try {
                
                System.out.println("Enter zip code:");
                zipCode = console.nextInt();
                validZipCode = true;
            
            } catch (InputMismatchException e) {
            
                System.out.println("Invalid input for zip code. Please enter a valid integer.");
                console.next(); // consume invalid input

            }
        } while (!validZipCode);

        boolean validPhoneNum = false;
        do {

            try {

                System.out.println("Enter phone number in format 1234567890:");
                phoneNum = console.nextInt();
                validPhoneNum = true;

            } catch (InputMismatchException e) {

                System.out.println("Invalid input for phone number. Please enter a valid integer.");
                console.next(); // consume invalid input

            }
        } while (!validPhoneNum);

        phonebook.insertAtFront(lastName, firstName, address, zipCode, phoneNum, null);

    } // end of insertPerson

    public void removePerson() {

        int index = 0;

        System.out.println("Enter index point for removal (entries are organized from newest to oldest, numbered starting at 0):");
        index = console.nextInt();
        
        phonebook.removeAtIndex(index);

    } // end of removePerson

    public void displayPhonebook() {

        phonebook.print();

    } // end of displayPerson

} // end of Main class
