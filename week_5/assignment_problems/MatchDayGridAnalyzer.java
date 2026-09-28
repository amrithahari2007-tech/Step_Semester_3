public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0;
        int sum = 0;
        for (int runs : row) sum += runs;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) sb.append(" | ");
            double avg = rowAverage(runsPerOver[i]);
            sb.append("Match ").append(i).append(": ")
              .append(avg >= threshold ? "Power Surge" : "Normal");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(grid, 8));
    }
}