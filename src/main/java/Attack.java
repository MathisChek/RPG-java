public class Attack {
    private String name;
    private int damage;
    private Character character;

    public Attack(String name, int damage, Character character) {
        this.name = name;
        this.damage = damage;
        this.character = character;
    }

    public int getDamage() {
        return damage;
    }

    public void execute() {
        System.out.println(character.getName() + " lance " + name + " et inflige " + damage + " dégâts !");
    }

    public String getName() {
        return name;
    }
}
