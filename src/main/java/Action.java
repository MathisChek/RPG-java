public class Action {
    public Boolean fight(Player player, Enemy enemy, Boolean isOngoing) {
        System.out.println("Battle");

        AttackMenu attackMenu = new AttackMenu(player.getAttackManager());
        Attack choice = attackMenu.execAttack(new java.util.Scanner(System.in));

        player.getAttackManager().executeAttack(choice.getName());

        int dealtDamage = player.attack(choice) - enemy.defend(choice);
        int takenDamage = enemy.attack(choice) - player.defend(choice);

        if (takenDamage < 0) {
            dealtDamage -= takenDamage / 2;
            takenDamage = 0;
        }

        if (dealtDamage < 0) {
            dealtDamage = 0;
        }

        player.decreaseHealth(takenDamage);
        enemy.decreaseHealth(dealtDamage);

        if (player.isDead()) {
            isOngoing = false;
        } else if (enemy.isDead()) {
            // Calcul de montée en points d'expérience
            player.increaseExperience(enemy.getExperience());
            isOngoing = false;
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
}
