import java.text.NumberFormat;

public class LoanPayoff {

    public static void main (String[] args) {

        int months;

        System.out.println("Test case 1:" +
                "\nInitial loan = $180,000" +
                "\nAnnual interest = 6.25%" +
                "\nMonthly payment: $1,850.00");

        months = monthsToPayoff(180000,0.0625, 1850, 0.0);
        if (months != -1)
            System.out.println("It will take " + months + " months to pay off this loan.");

        System.out.println("\nTest case 2:" +
                "\nInitial loan = $400,000" +
                "\nAnnual interest = 5.00%" +
                "\nMonthly payment: $2,000.00");

        months = monthsToPayoff(400000,0.05, 2000, 0.0);
        if (months != -1)
            System.out.println("It will take " + months + " months to pay off this loan.");

        System.out.println("\nTest case 3:" +
                "\nInitial loan = $300,000" +
                "\nAnnual interest = 4.50%" +
                "\nMonthly payment: $1,000.00");

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
