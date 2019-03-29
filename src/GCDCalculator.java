import java.util.Scanner;

public class GCDCalculator {

    public static void main (String[]args) {

        int numberA, numberB;
        Scanner keyboard = new Scanner(System.in);

        // Prompt user for whole number
        System.out.println("This program calculates the GCD of two whole numbers.");

        // Start of input loop
        while(true) {

            System.out.print("Please enter two positive numbers (e.g 17 51): ");
            numberA = keyboard.nextInt();
            numberB = keyboard.nextInt();

            // Output GCDs calculated with both methods
            System.out.println("GCD calculated recursively: " + recursivelyCalculateGCD(numberA, numberB));
            System.out.println("GCD calculated iteratively: " + iterativelyCalculateGCD(numberA, numberB));

        }

    }

    public static int recursivelyCalculateGCD(int numberA, int numberB) {
        // Base case, b = 0, a is the GCD
        if (numberB == 0)
            return numberA;

        // Otherwise return the GCD of b and a % b
        return recursivelyCalculateGCD(numberB, numberA % numberB);
    }

    public static int iterativelyCalculateGCD(int numberA, int numberB) {
        int temp;

        while (numberB != 0) {
            temp = numberB;
            numberB = numberA % numberB;
            numberA = temp;
        }
        return numberA;
    }
}
