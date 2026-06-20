import java.util.*;

public class FinancialForecast {
    public static double forecastRecursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return forecastRecursive(presentValue, rate, years - 1) * (1 + rate);
    }

    public static double forecastIterative(double presentValue, double rate, int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result = result * (1 + rate);
        }
        return result;
    }

    public static double forecastFormula(double presentValue, double rate, int years) {
        return presentValue * Math.pow(1 + rate, years);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double presentValue = sc.nextDouble();
        double growthRate = sc.nextDouble();
        growthRate = growthRate / 100;
        int years = sc.nextInt();

        double recursiveResult = forecastRecursive(presentValue, growthRate, years);
        System.out.println("Recursive Future Value: " + recursiveResult);

        double iterativeResult = forecastIterative(presentValue, growthRate, years);
        System.out.println("Iterative Future Value: " + iterativeResult);

        double formulaResult = forecastFormula(presentValue, growthRate, years);
        System.out.println("Formula Future Value: " + formulaResult);
    }
}