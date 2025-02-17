import java.util.HashMap;
import java.util.Map;

public class AttackManager {
    private final Character character;
    private final Map<String, Attack> attacks = new HashMap<>();

    // Assigne le personnage
    public AttackManager(Character character) {
        this.character = character;
    }

    public Map<String, Attack> getAttacks() { return attacks; }

    // Méthode pour ajouter une attack
    public void addAttack(String name, Attack attack) {
        attacks.put(name, attack);
        System.out.println("✅ Attack ajoutée : " + name);
    }

    // Méthode pour lister les attacks du personage
    public String attacks() {
        if (attacks.isEmpty()) {
            return "❌ Aucune attack disponible.";
        }

        StringBuilder attackListe = new StringBuilder();
        int index = 1;

        // Affiche chaque attack avec son index et ses dégâts
        for (Map.Entry<String, Attack> entry : attacks.entrySet()) {

            attackListe.append(String.format("  [%d] %s (💥 %d dégâts)\n",
                    index++,
                    entry.getKey(),
                    entry.getValue().getDamage())
            );
        }

        // Mise en forme
        String menuTemplate = """ 
                %s""";

        return String.format(menuTemplate, attackListe.toString().trim());
    }

    // Méthode pour exécuter une attack par son nom
    public void executeAttack(String attackName) {
        Attack attack = attacks.get(attackName);
        if (attack != null) {
            attack.execute();
        } else {
            System.out.println("❌ Attack introuvable : " + attackName);
        }
    }
}
