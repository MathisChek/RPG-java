public class Player extends Character {
    private static final int MAX_HEALTH = 100;
    private static final int EXPERIENCE = 0;
    private static final int SKILLS_NUMBER = 1;

    public int attackSkillsNumber, defenseSkillsNumber;

    public Player(String name) {
        // Appel au constructeur de la classe mère
        super(name, Player.MAX_HEALTH, Player.EXPERIENCE);
        // Initialisation du nombre de compétences (attaque / défense)
        this.attackSkillsNumber = 0; // FIXME Initialiser les compétences en début de partie
        this.defenseSkillsNumber = Player.SKILLS_NUMBER; // FIXME Initialiser les compétences en début de partie
    }

    @Override
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

    @Override
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
