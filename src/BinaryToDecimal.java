/* BinaryToDecimal.java
 * Author:  William Craycroft
 * Module:  7
 * Project: Lab 7
 * Problem Statement: This program takes in a String representing a binary number and converts it to a decimal (integer).
 *
 * Algorithm / Plan:
 *      1. Prompt user for two positive integers
 *      2. Recursively convert integer to binary String
 *          Instantiate decimal sum at 0
 *          If binary String length is equals to 1,
 *              Double decimal sum and add binary character as integer
 *              Return decimal sum
 *          Else,
 *              Method calls itself with a parameter of current decimal sum * 2 + first binary character
 *              Remove first character from binary String
 *              Return decimal sum
 *      3. Iteratively convert integer to binary String
 *          Instantiate decimal sum at 0
 *          While binary String is not empty...
 *              Double decimal sum and add first binary character as integer
 *              Remove first character from binary string
 *          Once binary String is empty, return decimal sum
 *      4. Output to console the result of both the recursive and iterative methods.
 *      5. Repeat steps 1-4 until the user enters "-1".
 */

import java.util.Scanner;

public class BinaryToDecimal {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String binaryInput;

        // Welcome text
        System.out.println("This program converts a binary number to a decimal integer.");

        // User input loop
        while (true) {
            // Prompt user for base 10 integer
            System.out.print("Please enter a binary number ('quit' to exit): ");
            binaryInput = keyboard.nextLine();

            if (binaryInput.equalsIgnoreCase("quit"))
                break;

            // Calculate and output binary number recursively
            System.out.println(binaryInput + " in decimal (recursive method): " + recursiveToDecimal(0, binaryInput));
            // Calculate binary number iteratively
            System.out.println(binaryInput + " in decimal (iterative method): " + iterativeToDecimal(binaryInput));

        }

    }

    // The initial call should always pass a decimalSum of 0.
    public static int recursiveToDecimal(int decimalSum, String binary) {

        // Base case, if only 1 character remains in String
        if (binary.length() == 1) {
            return decimalSum * 2 + Integer.parseInt(binary);
        }
        // Double the recursive sum and add first character in String
        // Send sum to recursive method and remove first character from String
        return recursiveToDecimal(decimalSum * 2 + Integer.parseInt(binary.substring(0, 1)), binary.substring(1));

    }

    public static int iterativeToDecimal(String binary) {

        int decimalSum = 0;

        while (binary.length() > 0) {
            // Multiply sum by 2 and add first character to sum
            decimalSum = decimalSum * 2 + Integer.parseInt(binary.substring(0, 1));
            // Remove first character from binary String
            binary = binary.substring(1);
        }
        // Return sum
        return decimalSum;
    }
}
