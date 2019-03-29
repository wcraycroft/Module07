/* GCDCalculator.java
 * Author:  William Craycroft
 * Module:  7
 * Project: Lab 7
 * Problem Statement: This program takes two positive integers from the user and calculated the Greatest Common Divisor
 *      of those two integers.
 *
 * Algorithm / Plan:
 *      1. Prompt user for two positive integers
 *      2. Recursively calculate GCD for integers A and B
 *          If B is 0, return A as the GCD
 *          Else, the method calls itself to test the GCD of B and (A % B)
 *      3. Iteratively calculate GCD for integers A and B
 *          If B is not 0, set B equals to A % B and set A equals to B's original value
 *          Repeat previous step until B is equal to 0
 *          Return A as GCD
 *      4. Output to console the result of both the recursive and iterative methods.
 *      5. Repeat steps 1-4 until the user enters "-1".
 */

import java.util.Scanner;

public class GCDCalculator {

    public static void main (String[]args) {

        int numberA, numberB;
        Scanner keyboard = new Scanner(System.in);

        // Prompt user for whole number
        System.out.println("This program calculates the GCD of two whole numbers.");

        // Start of input loop
        while(true) {

            System.out.print("Please enter two positive whole numbers (or -1 to quit): ");
            numberA = keyboard.nextInt();
            // Check for exit prompt
            if (numberA == -1)
                break;

            numberB = keyboard.nextInt();

            // Output GCDs calculated with both methods
            System.out.println("GCD calculated recursively: " + recursivelyCalculateGCD(numberA, numberB));
            System.out.println("GCD calculated iteratively: " + iterativelyCalculateGCD(numberA, numberB));

        }

        keyboard.close();
        System.out.print("Goodbye!");

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
