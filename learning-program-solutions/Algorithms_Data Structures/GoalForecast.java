import java.util.Scanner;

public class GoalForecast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Goal-Based Financial Forecasting\n");

        System.out.print("Enter your savings goal (₹): ");
        double goal = scanner.nextDouble();

        System.out.print("Enter how much you can save per month (₹): ");
        double monthlySavings = scanner.nextDouble();

        System.out.print("Enter expected annual interest rate (%): ");
        double rate = scanner.nextDouble();

        double monthlyRate = rate / 100 / 12;
        double saved = 0;
        int months = 0;

        System.out.println("\nForecast Progress:");
        System.out.println("----------------------------");

        while (saved < goal) {
            saved = (saved + monthlySavings) * (1 + monthlyRate);
            months++;

            System.out.printf("Month %2d: %.2f saved\n", months, saved);
            if (months > 600) { 
                System.out.println("Goal may not be achievable. Check values.");
                break;
            }
        }

        System.out.println("----------------------------");
        System.out.printf(" You will reach your goal of ₹%.2f in %d months (%.1f years)\n", goal, months, months / 12.0);

        scanner.close();
    }
}
