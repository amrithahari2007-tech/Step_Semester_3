import java.util.Random;

public class RockPaperScissors {
    static String[] moves = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Random rand = new Random();
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String computerMove = moves[rand.nextInt(3)];
            String result = playRound(playerMoves[i], computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.printf("%-6d| %-12s| %-15s| %s%n",
                    (i + 1), playerMoves[i], computerMove, result);
        }

        double winPercentage = (wins * 100.0) / playerMoves.length;
        System.out.println("\nFinal Summary:");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}