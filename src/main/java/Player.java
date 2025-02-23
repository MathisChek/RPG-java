public class Player extends Character {
    private static final int MAX_HEALTH = 500;
    private static final int EXPERIENCE = 0;
    private static final int SKILLS_NUMBER = 0;

    public int attackSkillsNumber, defenseSkillsNumber;

    public Player(String name) {
        // Appel au constructeur de la classe mère
        super(name, Player.MAX_HEALTH, Player.EXPERIENCE, 0);
        // Initialisation du nombre de compétences (attaque / défense)
        this.attackSkillsNumber = this.defenseSkillsNumber = 1;
    }

    public void specialize(ActionType choice) {
        if (choice == ActionType.ATTACK) {
            this.attackSkillsNumber += 1; // 🔥 Augmente l'attaque
            System.out.println("🔥 Vous vous spécialisez en " + ActionType.ATTACK.name().toLowerCase() + " ! (+1 Attaque)");
        } else if (choice == ActionType.DEFENSE) {
            this.defenseSkillsNumber += 1; // 🛡️ Augmente la défense
            System.out.println("🛡️ Vous vous spécialisez en " + ActionType.DEFENSE.name().toLowerCase() + " ! (+1 Defense)");
        } else {
            System.out.println("⚠️ Choix invalide dans la spécialisation.");
        }
    }
}
