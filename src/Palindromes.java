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

            //System.out.println(modified);

        } // end of input loop
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
