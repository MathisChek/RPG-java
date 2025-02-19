public class Attack {
    private String name;
    private int damage;
    private Character character;
    private String icon;

    private static final String DEFAULT_ICON = "⚔️";

    public Attack(String name, int damage, Character character, String icon) {
        this.name = name;
        this.damage = damage;
        this.character = character;
        this.icon = icon;
    }

    public Attack(String name, int damage, Character character) {
        this(name, damage, character, DEFAULT_ICON);
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getIcon() { return icon; }
}
