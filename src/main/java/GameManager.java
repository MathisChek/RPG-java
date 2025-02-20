public class GameManager {
    public static void gameOver(Boolean playerWins) {
        if (playerWins) {
            System.out.println("🏆 Félicitations ! Vous avez gagné la partie !");
        } else {
            System.out.println("💀 Game Over ! Vous avez perdu...");
        }
    }
}
