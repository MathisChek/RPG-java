public class Player extends Character {
    private static final int MAX_HEALTH = 100;
    private static final int EXPERIENCE = 0;
    private static final int SKILLS_NUMBER = 1;

    public int attackSkillsNumber, defenseSkillsNumber;

    public Player(String name) {
        // Appel au constructeur de la classe mère
        super(name, Player.MAX_HEALTH, Player.EXPERIENCE, 0);
        // Initialisation du nombre de compétences (attaque / défense)
        this.attackSkillsNumber = 0; // FIXME Initialiser les compétences en début de partie
        this.defenseSkillsNumber = Player.SKILLS_NUMBER; // FIXME Initialiser les compétences en début de partie
    }


}
