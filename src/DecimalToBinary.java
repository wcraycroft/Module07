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
            System.out.print("Please enter a positive whole number: ");
            inputNumber = keyboard.nextInt();

            // Calculate and output binary number recursively
            System.out.println(inputNumber + " in binary (recursive method): " + recursiveToBinary(inputNumber, ""));
            // Calculate binary number iteratively
            System.out.println(inputNumber + " in binary (iterative method): " + iterativeToBinary(inputNumber));

        }

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
