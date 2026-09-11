import java.util.Random;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-7d| %-11.2f| %-12.2f| %-6.2f| %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random rand = new Random();

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + rand.nextDouble() * (2.00 - 1.50);
            weights[i] = 45 + rand.nextInt(60);
        }

        printWellnessReport(heights, weights);
    }
}