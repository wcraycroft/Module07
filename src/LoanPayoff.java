/* LoanPayoff.java
 * Author:  William Craycroft
 * Module:  7
 * Project: Homework 7, Project 2
 * Problem Statement: This program uses a recursive method to calculate the time in months it will take to pay off a loan.
 *
 * Algorithm / Plan:
 *      1. Print values for first test case
 *      2. Recursively calculate the months until payoff
 *          Instantiate months counter and total interest sum
 *          If outstanding balance <= 0, return months
 *          Calculate monthly interest amount = annual rate / 12 * loan amount
 *          If monthly interest amount > monthly payment, return -1 and display negative amortization error message
 *          Increment months by 1
 *          Calculate new outstanding balance = balance + interest amount - monthly payment
 *          Add monthly interest to sum
 *          Call method recursively with new outstanding balance
 *      3. Output formatted loan information to user.
 *      4. Repeat step 1 - 3 for test cases 2 and 3.
 */

import java.text.NumberFormat;

public class LoanPayoff {

    public static void main (String[] args) {

        int months;
        // Print initial data for Test case 1
        System.out.println("Test case 1:" +
                "\nInitial loan = $180,000" +
                "\nAnnual interest = 6.25%" +
                "\nMonthly payment: $1,850.00");

        // Recursively calculate months until payoff
        months = monthsToPayoff(180000,0.0625, 1850, 0.0);
        if (months != -1)
            System.out.println("It will take " + months + " months to pay off this loan.");

        // Print initial data for Test case 2
        System.out.println("\nTest case 2:" +
                "\nInitial loan = $400,000" +
                "\nAnnual interest = 5.00%" +
                "\nMonthly payment: $2,000.00");

        // Recursively calculate months until payoff
        months = monthsToPayoff(400000,0.05, 2000, 0.0);
        if (months != -1)
            System.out.println("It will take " + months + " months to pay off this loan.");

        // Print initial data for Test case 2
        System.out.println("\nTest case 3:" +
                "\nInitial loan = $300,000" +
                "\nAnnual interest = 4.50%" +
                "\nMonthly payment: $1,000.00");

        // Recursively calculate months until payoff
        months = monthsToPayoff(300000,0.045, 1000, 0.0);
        if (months != -1)
            System.out.println("It will take " + months + " months to pay off this loan.");


    }

    public static int monthsToPayoff(double outstandingBalance, double annualInterestRate, double monthlyPayment,
                                     double totalInterestPaid)
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // Base case, paid in full
        if (outstandingBalance <= 0) {

            System.out.println("Total interest paid: " + currency.format(totalInterestPaid));
            return 0;
        }
        // Calculate monthly interest rate
        double monthlyInterest = annualInterestRate / 12.0 * outstandingBalance;

        // Base case, negative amortization
        if (monthlyInterest > monthlyPayment) {
            System.out.println("The monthly interest is higher than the monthly payment. The loan cannot be paid off.");
            System.out.println("Monthly interest = " + currency.format(monthlyInterest));
            System.out.println("Monthly payment = " + currency.format(monthlyPayment));
            return -1;
        }

        // Calculate new balance
        outstandingBalance = outstandingBalance + monthlyInterest - monthlyPayment;

        // Add 1 to months and call recursively
        return 1 + monthsToPayoff(outstandingBalance, annualInterestRate, monthlyPayment,
                totalInterestPaid + monthlyInterest);
    }
}
