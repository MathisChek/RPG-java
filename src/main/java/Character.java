import java.lang.reflect.Method;

/**
 * Classe destinée à gérer les personnages du RPG
 * @author Captain America
 */
public abstract class Character { // Classe abstraite (car non instantiable) imposant un « contrat » pour les classes dérivées
    private final String BATTLE_MODE = "1";
    private final String ESCAPE_MODE = "2";
    private final AttackManager attackManager;
    // Attributs communs à l'ensemble des classes filles
    private String name;
    private int health;
    private int maxHealth;
    private int experience;

    protected int attackSkillsNumber, defenseSkillsNumber;


    // Constructeur : définit l'état initial d'un personnage
    /**
     * <p>Méthode destinée à generer une nouvelle instance du personnage</p>
     * @param name nom du personnage
     * @param maxHealth nombre de points de vie maximum du personnage
     * @param experience nombre de points experience du personnage
     */
    public Character(String name, int maxHealth, int experience) {
        this.name = name;
        this.health = this.maxHealth = maxHealth;
        this.experience = experience;
        this.attackManager = new AttackManager(this);
    }

    /**
     * <p>Méthode destinée à récupérer le nom du personnage</p>
     * @return nom du personnage
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Méthode destinée à définir le nom du personnage</p>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Méthode destinée à récupérer le nombre de points de vie du personnage </p>
     * @return PV max du personnage
     */
    public int getHealth() {
        return health;
    }

    /**
     * <p>Méthode destinée à définir le nombre de points de vie du personnage </p>
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * <p>Méthode destinée à décrémenter le nombre de points de vie actuel du personnage </p>
     * @param points nombre de points à enlever au personnage
     */
    public void decreaseHealth(int points) {
        this.health -= points;
    }

    /**
     * <p>Méthode destinée à incrémenter le nombre de points de vie actuel du personnage </p>
     * @param points nombre de points à ajouter au personnage
     */
    public void increaseHealth(int points) {
        this.health += points;
    }

    /**
     * <p>Méthode destinée à récupérer le nombre de points de vie maximum du personnage </p>
     * @return PV max du personnage
     */
    public int getMaxHealth() {
        return maxHealth;
    }


    /**
     * <p>Méthode destinée à définir le nombre de points de vie maximum du personnage </p>
     * @param maxHealth nombre de point de vie maximum du personnage
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * <p>Méthode destinée à récupérer le nombre de points experience du personnage </p>
     * @return PV max du personnage
     */
    public int getExperience() {
        return experience;
    }

    /**
     * <p>Méthode destinée à définir le nombre de points d'experience du personnage </p>
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }


    /**
     * <p>Méthode destinée à récupérer l'attackManager du personnage </p>
     * @return PV max du personnage
     */
    public AttackManager getAttackManager() { return attackManager; }

    /**
     * <p>Méthode destinée à décrémenter le nombre de points d'experience du personnage </p>
     * @param points nombre de points d'experience à ajouter au personnage
     */
    public void decreaseExperience(int points) {
        this.experience -= points;
    }

    /**
     * <p>Méthode destinée à incrémenter le nombre de points d'experience du personnage </p>
     * @param points nombre de points à ajouter au personnage
     */
    public void increaseExperience(int points) {
        this.experience += points;
    }

    /**
     * <p>Méthode destinée savoir si un personnage possède encore des points de vie </p>
     * @return un boolean - true si le personnage n'a plus de PV et false s'il est toujours en vie
     */
    public boolean isDead() {
        return this.health <= 0;
    }

    /**
     * <p>Méthode destinée à implémenter le système de combat de l'application </p>
     * @param character - ennemi (character) qui attack le player
     * @param mode - mode de combat, en fonction du mode différentes actions seront réaliser par le joueur
     * @return un boolean qui permet de savoir si le combat à était gagné ou perdu par le joueur
     */
    public boolean fight(Character character, String mode) {
        boolean isOngoing = true;

        Action action = new Action();
        try {
            Method method = action.getClass().getMethod(mode, Player.class, Enemy.class, Boolean.class);
            isOngoing = (boolean) method.invoke(action, this, character, isOngoing);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("Erreur d'accès à la méthode : " + mode, e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOngoing;
    }

    /**
     * <p>Méthode destinée à structurer avec un template les affichages dans le terminal</p>
     * @return une string avec le bon format
     */
    public String toString() {
        String statsTemplate = """
                ****************************************
                ***** %S
                ****************************************
                * HP : %d / %d
                * XP : %d
                * Compétences : \n  %s
                * Équipements : %s
                * Position: [X:%d, Y:%d]
                ****************************************
                """;

        String stats = String.format(statsTemplate, this.name, this.health, this.maxHealth, this.experience, this.attackManager.attacks(), "à implémenter", 0, 0);

        return stats;
    }

    // Méthodes abstraites liées à l'action de « combattre »
    /**
     * <p>Méthode destinée à structurer les class enfants ennemi et player</p>
     */
    public int attack(Attack attack) { // Définition de l'attaque du point de vue du joueur
        double base = (this.getExperience() / 4.0) + (attackSkillsNumber * 3.0) + 3.0;
        double experienceBonus = this.getExperience() / 10.0;
        double skillBonus = (attackSkillsNumber * 2.0) + defenseSkillsNumber + 1.0;

        // Pondération avec damage
        int damage = attack.getDamage();
        double damageFactor = 1 + (damage / 100.0);  // Exemple : damage=20 → facteur 1.2

        double total = Math.random() * (base * damageFactor) + experienceBonus + skillBonus;
        return (int) total;
    }

    /**
     * <p>Méthode destinée à structurer les class enfants ennemi et player</p>
     */
    public int defend(Attack attack) { // Définition de la défense du point de vue de l'ennemi
        double base = (this.getExperience() / 4.0) + (attackSkillsNumber * 3.0) + 3.0;
        double experienceBonus = this.getExperience() / 10.0;
        double skillBonus = (attackSkillsNumber * 2.0) + defenseSkillsNumber + 1.0;

        // Pondération avec damage
        int damage = attack.getDamage();
        double damageFactor = 1 + (damage / 100.0);  // Exemple : damage=20 → facteur 1.2

        double total = Math.random() * (base * damageFactor) + experienceBonus + skillBonus;
        return (int) total;
    }
}
