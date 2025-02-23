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

            attackListe.append(String.format("  ➜ 💥%s\n",
                    entry.getKey()
            ));
        }

        // Mise en forme
        String menuTemplate = """ 
                \n  %s""";

        return String.format(menuTemplate, attackListe.toString().trim());
    }
}
