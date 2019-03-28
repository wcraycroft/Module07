import java.util.Scanner;

public class GCDCalculator {

    public static void main (String[]args) {

        int numberA, numberB;
        Scanner keyboard = new Scanner(System.in);

        // Prompt user for whole number
        System.out.println("This program calculates the GCD of two whole numbers.");

        // Start of input loop
        while(true) {

            System.out.print("Please enter first number: ");
            numberA = keyboard.nextInt();
            System.out.print("Please enter second number: ");
            numberB = keyboard.nextInt();

            // Output GCDs calculated with both methods
            System.out.println("GCD calculated recursively: " + recursivelyCalculateGCD(numberA, numberB));
            System.out.println("GCD calculated iteratively: " + recursivelyCalculateGCD(numberA, numberB));

        }

    }

    public static int recursivelyCalculateGCD(int numberA, int numberB) {
        // Base case, a % b = 0, a is the GCD
        if (numberA % numberB == 0)
            return numberA;

        // Otherwise return the GCD of b and a % b
        return recursivelyCalculateGCD(numberB, numberA % numberB);
    }
}
