public class GameManager {
    public static void gameOver(Boolean playerWins) {
        if (playerWins) {
            System.out.println("🏆 Félicitations ! Vous avez gagné la partie !");
        } else {
            System.out.println("💀 Game Over ! Vous avez perdu...");
        }

        System.out.println("🎮 Merci d'avoir joué !");
        System.exit(0); // 🔹 Termine le programme proprement
    }
}
