import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CharacterFactory {
    private static final List<Attack> PLAYER_ATTACKS = Arrays.asList(
            new Attack("Coup d'épée", 30, null, "🗡️"),
            new Attack("Coup de poing", 10, null, "🤜"),
            new Attack("Uppercut", 20, null, "🥊"),
            new Attack("Coup de pied circulaire", 25, null, "🦵"),
            new Attack("Lancer de dague", 15, null, "🗡️"),
            new Attack("Flèche perçante", 35, null, "🏹")
    );

    private static final List<Attack> ENEMY_ATTACKS = Arrays.asList(
            new Attack("Coup de griffe", 15, null, "🐾"),
            new Attack("Morsure", 20, null, "🦷"),
            new Attack("Charge brutale", 25, null, "🐂"),
            new Attack("Souffle de feu", 30, null, "🔥"),
            new Attack("Poison", 10, null, "☠️"),
            new Attack("Coup d'épée", 30, null, "🗡️"),
            new Attack("Coup de poing", 10, null, "🤜")
    );

    public static Player createPlayer(String name) {
        Player player = new Player(name);
        assignRandomAttacks(player, 2, 4); // Attribuer entre 2 et 4 attaques aléatoires
        return player;
    }

    public static Enemy createEnemy(String name, int playerExperience, int enemyCoins) {
        Enemy enemy = new Enemy(name, playerExperience, enemyCoins);
        assignRandomAttacks(enemy, 2, 4); // Attribuer entre 2 et 4 attaques aléatoires
        return enemy;
    }

    private static void assignRandomAttacks(Character character, int min, int max) {
        Random rand = new Random();
        int attackCount = rand.nextInt(max - min + 1) + min; // Nombre aléatoire d'attaques
        List<Attack> attackPool = (character instanceof Player) ? PLAYER_ATTACKS : ENEMY_ATTACKS;

        for (int i = 0; i < attackCount; i++) {
            Attack attack = attackPool.get(rand.nextInt(attackPool.size()));
            character.getAttackManager().addAttack(attack.getName(), new Attack(
                    attack.getName(),
                    attack.getDamage(),
                    character,  // Assigner le propriétaire de l'attaque
                    attack.getIcon()
            ));
        }
    }
}