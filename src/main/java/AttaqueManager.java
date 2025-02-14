import java.util.HashMap;
import java.util.Map;

public class AttaqueManager {
    private final Character character;
    private final Map<String, Attaque> attaques = new HashMap<>();

    // Assigne le personnage
    public AttaqueManager(Character character) {
        this.character = character;
    }

    public Map<String, Attaque> getAttaques() {
        return attaques;
    }

    // Méthode pour ajouter une attaque
    public void addAttack(String name, Attaque attaque) {
        attaques.put(name, attaque);
        System.out.println("✅ Attaque ajoutée : " + name);
    }

    // Méthode pour lister les attaques
    public String listAttaqueCharacter() {
        if (attaques.isEmpty()) {
            return "❌ Aucune attaque disponible.";
        }

        StringBuilder attaqueListe = new StringBuilder();
        int index = 1;

        // Affiche chaque attaque avec son index et ses dégâts
        for (Map.Entry<String, Attaque> entry : attaques.entrySet()) {
            attaqueListe.append(String.format("[%d] %s (💥 %d dégâts)\n",
                    index++,
                    entry.getKey(),
                    entry.getValue().getDamage())
            );
        }

        // Mise en forme
        String menuTemplate = """
                ****************************************
                ***** Liste des attaques de %s
                ****************************************
                %s
                ****************************************
                """;

        return String.format(menuTemplate, character.getName(), attaqueListe.toString().trim());
    }

    // Méthode pour exécuter une attaque par son nom
    public void executeAttaque(String attaqueName) {
        Attaque attaque = attaques.get(attaqueName);
        if (attaque != null) {
            attaque.execute();
        } else {
            System.out.println("❌ Attaque introuvable : " + attaqueName);
        }
    }
}
