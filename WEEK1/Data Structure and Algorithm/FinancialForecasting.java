public class FinancialForecasting {

    public double forecastRecursive(double presentValue, double growthRate, int periods) {
        // Validate inputs
        if (presentValue < 0 || growthRate < 0 || periods < 0) {
            throw new IllegalArgumentException("Inputs must be non-negative.");
        }
        if (periods == 0) {
            return presentsValue;
        } else {
            return forecastRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
        }
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        double futureValue = forecasting.forecastRecursive(1000, 0.05, 10);
        System.out.println("Future Value: " + futureValue);
    }
}
