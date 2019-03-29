/* Palindromes.java
 * Author:  William Craycroft
 * Module:  7
 * Project: Lab 7
 * Problem Statement: This program takes in a String input from the user and determines if that String is a palindrome.
 *
 * Algorithm / Plan:
 *      1. Prompt user for a word, phrase or sentence.
 *      2. Replace all non-alphabetical character and spaces from input String
 *      3. Set input String to lower case
 *      4. Recursively test if String is palindrome
 *          If String length is 1, return true.
 *          Else, test if first and last characters of the String match.
 *          If true, remove first and last character from String and repeat Step 4.
 *          Else, return false.
 *      5. Iteratively test if String is a palindrome
 *          Loop through first half of String
 *          For each character, test if it matches its opposing counterpart in second half of String
 *          If false, return false
 *          After loop, return true
 *      6. Output to console the result of both the recursive and iterative methods.
 *      7. Repeat steps 1-6 until the user enters "quit".
 */

import java.util.Scanner;

public class Palindromes {

    public static void main(String[] args) {

        // Declarations
        Scanner keyboard = new Scanner(System.in);
        String input, modified;

        // Start of input loop
        while (true) {
            // Prompt user for Palindrome string
            System.out.print("Enter a word, phrase or sentence (or 'quit' to exit): ");
            input = keyboard.nextLine();

            // Check for exit prompt
            if (input.equalsIgnoreCase("quit"))
                break;

            // Remove all non-alphanumeric characters
            modified = input.replaceAll("[^\\w\\s]", "");
            // Remove all numbers and underscores
            modified = modified.replaceAll("0123456789_", "");
            // Remove all spaces
            modified = modified.replaceAll(" ", "");
            // Set remaining character to lower case
            modified = modified.toLowerCase();

            // Output the original string and whether or not it is a palindrome
            System.out.printf("\"%s\" is%s a palindrome (recursive method used).\n", input,
                    recursiveTestPalindrome(modified) ? "" : " not");

            System.out.printf("\"%s\" is%s a palindrome (iterative method used).\n\n", input,
                    iterativeTestPalindrome(modified) ? "" : " not");

        } // end of input loop

        keyboard.close();
        System.out.print("Goodbye!");
    }

    // This recursive method returns True if the input String is a Palindrome (reads forwards and backwards)
    public static boolean recursiveTestPalindrome(String text) {
        // Base condition: if string length is <2 return true
        if (text.length() < 2)
            return true;

        // Test if first and last character match
        if (text.substring(0,1).equals(text.substring(text.length() - 1))) {
            // call recursively for remaining chars
            return recursiveTestPalindrome(text.substring(1, text.length() - 1));
        }
        // Else, it is not a palindrome
        return false;
    }

    // This iterative method returns True if the input String is a Palindrome (reads forwards and backwards)
    public static boolean iterativeTestPalindrome(String text) {
         // Loop through first half of string
        for (int i = 0; i < text.length() / 2; i++) {
            // Test if char at index i is equals to it counterpart at last char - i
            if (!text.substring(i, i + 1).equals(
                    text.substring(text.length() - (i + 1), text.length() - i)))
                // If not equal, return false
                return false;
        }
        // All characters match, return true
        return true;
    }
}
