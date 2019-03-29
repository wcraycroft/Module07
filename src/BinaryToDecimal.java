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
            System.out.print("Please enter a binary number: ");
            binaryInput = keyboard.nextLine();

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
