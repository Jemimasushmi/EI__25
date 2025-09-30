import java.util.*;

class Leaderboard {
    private static final Leaderboard instance = new Leaderboard();
    private Map<String, Integer> scores = new HashMap<>();

    private Leaderboard() {}

    public static Leaderboard getInstance() {
        return instance;
    }

    public void updateScore(String player, int score) {
        scores.put(player, score);
        System.out.println("Score updated: " + player + " = " + score);
    }

    public void showScores() {
        System.out.println("Current Leaderboard:");
        scores.forEach((p, s) -> System.out.println(p + ": " + s));
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Leaderboard lb = Leaderboard.getInstance();

        System.out.print("How many players to update? ");
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter player name: ");
            String player = sc.nextLine();
            System.out.print("Enter player score: ");
            int score = Integer.parseInt(sc.nextLine());
            lb.updateScore(player, score);
        }

        lb.showScores();
    }
}
