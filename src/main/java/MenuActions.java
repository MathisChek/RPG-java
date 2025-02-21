public class MenuActions {
    public boolean goToNextFight(Player player, Story story) {
        if (story.getCurrentLevel().hasRemainingEnemies()) {
            System.out.println("⚔️ Un nouvel ennemi apparaît !");
            return true; // Continue les combats
        }
        System.out.println("✅ Tous les ennemis ont été vaincus !");
        return false; // Tous les ennemis sont vaincus, on peut passer au niveau suivant
    }

    public boolean goToNextLevel(Player player, Story story) {
        if (!story.isLastLevel()) {
            System.out.println("✅ Tous les ennemis du niveau ont été vaincus !");
            story.nextLevel();
            System.out.println("🎭 Passage au niveau suivant...");
        } else {
            System.out.println("🏆 Vous avez terminé l'aventure !");
            GameManager.gameOver(true);
        }
        return false; // Arrête le menu après le passage de niveau
    }

    public Boolean rest(Player player, Boolean isOngoing) {
        // Définition des couleurs ANSI (à vérifier si ton terminal les supporte)
        final String RESET = "\u001B[0m";  // Réinitialise la couleur
        final String GREEN = "\u001B[32m"; // Texte en vert
        final String CYAN = "\u001B[36m";  // Texte en cyan
        final String YELLOW = "\u001B[33m"; // Texte en jaune
        final String RED = "\u001B[31m"; // Texte en rouge

        int restHealthEffect = (int) (Math.random() * ((double) player.getExperience() / 4 + 1) + 10);
        int restCount = player.getRestCount();

        if (player.canRest()) {
            System.out.println("\n" + CYAN + "****************************************");
            System.out.println("*          🛏️  REPOS DU JOUEUR         *");
            System.out.println("****************************************" + RESET);
            System.out.println("\n📢 Vous avez choisi de vous reposer.");

            System.out.println(GREEN + "\n - 🔄 Nombre de repos restants : " + player.getRestCount() + RESET);

            if ((restHealthEffect + player.getHealth()) >= player.getMaxHealth()) {
                System.out.println(YELLOW + "\n✨ -> Vous avez récupéré " + (player.getMaxHealth() - player.getHealth())  + " points de vie !");
            } else {
                System.out.println(YELLOW + "\n✨ -> Vous avez récupéré " + restHealthEffect + " points de vie !");
            }

            player.setHealth(Math.min(player.getHealth() + restHealthEffect, player.getMaxHealth()));
            player.setRestCount(--restCount);


            System.out.println("❤️ -> Points de vie actuels : " + player.getHealth() + RESET);
            System.out.println(RED + "\n❗ Il vous reste " + player.getRestCount() + " repos disponible.\n" + RESET);

        } else {
            System.out.println(RED + "❌ Vous ne pouvez plus vous reposer");
        }

        return isOngoing;
    }
}