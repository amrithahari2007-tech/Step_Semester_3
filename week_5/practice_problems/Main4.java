import java.util.Arrays;
import java.util.Locale;

class Candidate implements Comparable<Candidate> {
    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public int getCodingScore() { return codingScore; }

    // composite = 10 * CGPA + 0.5 * codingScore
    public double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    // descending by composite score
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class Main4{
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        Candidate[] temp = new Candidate[candidates.length];
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa(), c.getCodingScore())) {
                temp[count++] = c;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(temp, count);
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ")
              .append(shortlisted[i].getName())
              .append(" (")
              .append(String.format(Locale.US, "%.1f", shortlisted[i].getCompositeScore()))
              .append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(batch));
        // 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}