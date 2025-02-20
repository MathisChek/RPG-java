import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Character {
    private int enemyExperience;

    public Enemy(String name, int enemyExperience, int coins) {
        // Appel au constructeur de la classe mère
        super(name, (int) (Math.random() * enemyExperience + (double) enemyExperience / 3 + 5), (int) (Math.random() * ((double) enemyExperience / 4 + 2) + 1), coins);
        this.enemyExperience = enemyExperience;
    }

    public int getEnemyExperience() {
        return enemyExperience;
    }

    public void setEnemyExperience(int enemyExperience) {
        if (enemyExperience < 0) {
            this.enemyExperience = 0;
        }
        this.enemyExperience = enemyExperience;
    }

    public int getMaxHealth(int experience) {
        return (int) (Math.random() * experience + (double) experience / 3 + 5);
    }

    public int getExperience(int experience) {
        return (int) (Math.random() * ((double) experience / 4 + 2) + 1);
    }

    public Attack getRandomEnemyAttack() {
        AttackManager attackManager = this.getAttackManager();
        ArrayList<Attack> attacks = new ArrayList<>(attackManager.getAttacks().values());
        Random rand = new Random();
        return attacks.get(rand.nextInt(attacks.size()));  // Choisit un index au hasard
    }
}
