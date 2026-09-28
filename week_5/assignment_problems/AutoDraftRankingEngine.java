import java.util.Arrays;

class FantasyPlayer implements Comparable<FantasyPlayer> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public FantasyPlayer(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() { return name; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public double getBattingAverage() { return battingAverage; }
    public boolean isInjured() { return injured; }

    @Override
    public int compareTo(FantasyPlayer other) {
        return Double.compare(other.battingAverage, this.battingAverage); // descending
    }
}

public class AutoDraftRankingEngine {

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(FantasyPlayer[] players) {
        FantasyPlayer[] draftable = new FantasyPlayer[players.length];
        int count = 0;
        for (FantasyPlayer p : players) {
            if (isDraftable(p.getMatchesPlayed())
                    || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[count++] = p;
            }
        }
        FantasyPlayer[] result = Arrays.copyOf(draftable, count);
        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(result[i].getName());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FantasyPlayer[] players = {
            new FantasyPlayer("Virat", 15, 48.0, false),
            new FantasyPlayer("Rahul", 7, 55.0, false),
            new FantasyPlayer("Sameer", 3, 60.0, false),
            new FantasyPlayer("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}