import java.util.InputMismatchException;
import java.util.Scanner;

public class Recursion {

    Scanner console = new Scanner(System.in);

    public static void main (String[] args) {

        Recursion main = new Recursion();
        main.menu();

    } // end of main

    public void menu() {

        boolean menuflag = false;
        char menuinput;

        do {

            try {

                System.out.printf("Please type a command: %n" +
                              "   \"m\" to run mystery method.%n" +
                              "   \"s\" to run sum method.%n" +
                              "   \"d\" to run least common denominator method.%n" +
                              "   \"q\" to quit the program.%n");
                menuinput = console.next().charAt(0);

                switch (menuinput) {
                
                    case 'm':
                        System.out.println("Please enter number a: ");
                        int a = console.nextInt();
                        System.out.println("Please enter number b: ");
                        int b = console.nextInt();
                        int result = mystery(a, b);
                        System.out.println("Result of mystery(" + a + ", " + b + ") is: " + result);
                        break;
                    case 's':
                        System.out.println("Please enter number n: ");
                        int n = console.nextInt();
                        int result2 = sum(n);
                        System.out.println("Result of sum is: " + result2);
                        break;
                    case 'd':
                        // first fraction
                        System.out.println("Enter denominator of the first fraction: ");
                        int den1 = console.nextInt();
                        // second fraction
                        System.out.println("Enter denominator of the second fraction: ");
                        int den2 = console.nextInt();
                        // Calculate the LCD
                        int lcd = lcd(den1, den2);
                        System.out.println("The Least Common Denominator of the two fractions is: " + lcd);
                        break;
                    case 'q':
                        System.out.println("Goodbye.");
                        console.close();
                        menuflag = true;
                        break;
                    default:
                        System.out.println("Invalid menu option. Please enter 'm', 's', 'd', or 'q'.");
                        break;
                        
                } 

            } catch (InputMismatchException e) {

                System.out.println("Invalid input for menu. Please enter a valid character.");
                console.next(); // consume invalid input

            }
            
        } while (!menuflag);

    } // end of menu

    // if b is greater than 1, this method will add a to a b-1 times, effectively multiplying a times b
    public int mystery (int a, int b) {

        if (b == 1) {return a;}

        else {return a + mystery(a, b-1);}

    } // end of mystery

    // originally this recursive method ran an infinite loop which caused a stack overflow
    // to prevent this I changed my else statement to return "n + sum(n-1)" instead of "n + sum(n)"
    public int sum (int n) {

        if (n == 0) {return 0;}

        else {return n + sum(n-1);}

    } // end of sum

    // to find the least common denominator first we must calculate the greatest common denominator
    public int gcd (int a, int b) {

        if (b == 0) {return a;}

        else {return gcd(b, a % b);}

    } // end of gcd

    // now that we have the gcd we can calculate the lcd
    public int lcd (int den1, int den2) {

        return (den1 * den2) / gcd(den1, den2);

    } // end of lcd

} // end of Recursion