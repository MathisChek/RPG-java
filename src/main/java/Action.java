import java.util.ArrayList;

public class Action {
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
            player.increaseMoney(enemy.getMoney());
            isOngoing = false;
        } else {
            System.out.println("\n⚡ " + CYAN + "Le combat continue... Prépare-toi !" + RESET + "\n");
        }
        return isOngoing;
    }

    public Boolean escape(Player player, Enemy enemy, Boolean isOngoing) {
        System.out.println("Escape");
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
                System.out.println("baaaaaaa");
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

    public Boolean purchase(Player player) {
        return true;
    }
}
