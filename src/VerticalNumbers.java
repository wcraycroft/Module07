import java.util.Scanner;

public class VerticalNumbers {

    public static void main (String[]args) {
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            int n;
            System.out.print("Enter a number: ");
            n = keyboard.nextInt();

            verticalNumbers(n);
        }
    }

    public static void verticalNumbers(int n) {

        if (n >= 10 || n <= -10) {
            verticalNumbers(n / 10);
        }
        System.out.println(n % 10);
        return;
    }
}
