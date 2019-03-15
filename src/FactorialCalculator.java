import java.util.Scanner;

public class FactorialCalculator {

    public static void main (String[]args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }
    public static double factorial(double n) {
        return (n == 0) ? 1.0 : n * factorial(n - 1.0);
    }
}
