public class CombatActions {
    public Boolean fight(Player player, Enemy enemy, Boolean isOngoing) {
        // Définition des couleurs ANSI
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";    // Dégâts
        final String GREEN = "\u001B[32m";  // Actions joueur
        final String YELLOW = "\u001B[33m"; // Actions ennemi
        final String CYAN = "\u001B[36m";   // Informations générales

        AttackMenu attackMenu = new AttackMenu(player.getAttackManager());
        Attack choice = attackMenu.execAttack(new java.util.Scanner(System.in));
        Attack enemyChoice = enemy.getRandomEnemyAttack();

        int dealtDamage = player.attack(choice) - enemy.defend(choice);
        int takenDamage = enemy.attack(enemyChoice) - player.defend(enemyChoice);


        if (takenDamage < 0) {
            dealtDamage -= takenDamage / 2;
            takenDamage = 0;
        }

        if (dealtDamage < 0) {
            dealtDamage = 0;
        }

        // Affichage du combat avec couleurs et emojis
        System.out.println(GREEN + player.getName() + " " + choice.getIcon() + " " + choice.getName() + RESET);
        System.out.println(YELLOW + enemy.getName() + " " + enemyChoice.getIcon() + " " + enemyChoice.getName() + RESET);

        System.out.println(RED + "\n💥 " + player.getName() + " inflige " + dealtDamage + " points de dégât !" + RESET);
        System.out.println(RED + "🔥 " + enemy.getName() + " inflige " + takenDamage + " points de dégât !" + RESET);

        // Appliquer les dégâts
        player.decreaseHealth(takenDamage);
        enemy.decreaseHealth(dealtDamage);

        // Vérification de la fin du combat
        if (player.isDead()) {
            System.out.println("\n❌ " + RED + player.getName() + " a été vaincu... 💀" + RESET + "\n");
            isOngoing = false;
        } else if (enemy.isDead()) {
            System.out.println("\n🏆 " + GREEN + enemy.getName() + " est vaincu ! " + player.getName() + " gagne de l'expérience ! ✨" + RESET + "\n");
            player.increaseExperience(enemy.getExperience());
            player.increaseCoins(enemy.getCoins());
            isOngoing = false;
        } else {
            System.out.println("\n⚡ " + CYAN + "Le combat continue... Prépare-toi !" + RESET + "\n");
        }
        return isOngoing;
    }

    public Boolean escape(Player player, Enemy enemy, Boolean isOngoing) {
        if (Math.random() * 10 + 1 <= 3.5) {
            isOngoing = false;
        } else {
            int takenDamage = enemy.attack(enemy.getRandomEnemyAttack());
            player.decreaseHealth(takenDamage);
            if (player.isDead()) {
                isOngoing = false;
            }
        }
        return isOngoing;
    }
}
