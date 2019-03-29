/* DecimalToBinary.java
 * Author:  William Craycroft
 * Module:  7
 * Project: Lab 7
 * Problem Statement: This program takes in a positive integer from the user and converts it to binary (as a String).
 *
 * Algorithm / Plan:
 *      1. Prompt user for two positive integers
 *      2. Recursively convert integer to binary String
 *          If integer / 2 (integer division) is equal to 0, append the remainder to the binary String
 *              Return the string
 *          Else, the method calls itself with a parameter of integer / 2
 *              Append the remainder to the binary String and return the String
 *      3. Iteratively convert integer to binary String
 *          If integer / 2 is not equals to 0, add remainder to start of binary String
 *          Divide integer by 2
 *          Repeat last 2 step until integer / 2 is equals to 0
 *          Return binary String
 *      4. Output to console the result of both the recursive and iterative methods.
 *      5. Repeat steps 1-4 until the user enters "-1".
 */

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int inputNumber;

        // Welcome text
        System.out.println("This program converts a positive base 10 number into a binary String.");

        // User input loop
        while (true) {
            // Prompt user for base 10 integer
            System.out.print("Please enter a positive whole number (-1 to quit): ");
            inputNumber = keyboard.nextInt();

            // Check for exit prompt
            if (inputNumber == -1)
                break;

            // Calculate and output binary number recursively
            System.out.println(inputNumber + " in binary (recursive method): " + recursiveToBinary(inputNumber, ""));
            // Calculate binary number iteratively
            System.out.println(inputNumber + " in binary (iterative method): " + iterativeToBinary(inputNumber));

        }
        keyboard.close();
        System.out.print("Goodbye!");

    }

    public static String recursiveToBinary(int decimal, String binary) {

        // Base case, if decimal number / 2 = 0
        if (decimal / 2 == 0) {
            return binary + (decimal % 2);
        }
        // Add remainder of decimal / 2 to end of recursive String
        return recursiveToBinary(decimal / 2, binary) + (decimal % 2);

    }

    public static String iterativeToBinary(int decimal) {

        String binary = "";

        while (decimal / 2 != 0) {
            // Add remainder of decimal / 2 to start of binary String
            binary = (decimal % 2) + binary;
            // Divide decimal nby 2
            decimal /= 2;
        }
        // Add final remainder to start of String and return it
        return (decimal % 2) + binary;
    }

}
