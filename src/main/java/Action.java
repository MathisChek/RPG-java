public class Action {
    public Boolean fight(Character player, Character enemy, Boolean isOngoing) {
        System.out.println("Battle");

        AttaquesMenu attaqueMenu = new AttaquesMenu(player.attaque);

        int dealtDamage = player.attack() - enemy.defend();
        int takenDamage = enemy.attack() - player.defend();

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

    public Boolean escape(Character player, Character enemy, Boolean isOngoing) {
        System.out.println("Escape");
        if (Math.random() * 10 + 1 <= 3.5) {
            isOngoing = false;
        } else {
            int takenDamage = enemy.attack();
            player.decreaseHealth(takenDamage);
            if (player.isDead()) {
                isOngoing = false;
            }
        }
        return isOngoing;
    }
}
