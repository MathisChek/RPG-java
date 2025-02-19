public class CharacterFactory {
    public static Player createPlayer(String name) {
        Player player = new Player(name);
        player.getAttackManager().addAttack("Coup d'épée", new Attack("Coup d'épée", 30, player, "🗡️"));
        player.getAttackManager().addAttack("Coup de poing", new Attack("Coup de poing", 10, player, "🤜"));
        return player;
    }

    public static Enemy createEnemy(String name, int playerExperience, int enemyMoney) {
        Enemy enemy = new Enemy(name, playerExperience, enemyMoney);
        enemy.getAttackManager().addAttack("Coup d'épée", new Attack("Coup d'épée", 30, enemy, "🗡️"));
        return enemy;
    }
}