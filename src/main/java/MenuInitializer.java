import java.util.ArrayList;
import java.util.List;

public class MenuInitializer {
    private ArrayList<MenuItem> menuItems;  // Liste des éléments du menu

    // 🟢 Constructeur qui initialise le menu
    public MenuInitializer(MenuType menuType) {
        this.menuItems = new ArrayList<>();
        initializeMenu(menuType);
    }

    // 🟢 Méthode pour initialiser les items du menu
    private void initializeMenu(MenuType menuType) {
        switch (menuType){
            case COMBAT:
                menuItems.add(new MenuItem(1, "⚔️ Combattre", "fight"));
                menuItems.add(new MenuItem(2, "🧪 Utiliser un élixir", "useElixir", false));
                menuItems.add(new MenuItem(3, "💤 Se reposer", "rest"));
                menuItems.add(new MenuItem(4, "🏃 Prendre la fuite", "escape"));
                break;
            case COMBAT_END:
                menuItems.add(new MenuItem(1, "💤 Se reposer", "rest"));
                menuItems.add(new MenuItem(2, "🛒 Acheter un élixir", "purchase"));
                menuItems.add(new MenuItem(3, "⚔️ Passer au prochain combat", "next_fight"));
                break;
            case LEVEL_END:
                menuItems.add(new MenuItem(1, "💤 Se reposer", "rest"));
                menuItems.add(new MenuItem(2, "🛒 Acheter un élixir", "purchase"));
                menuItems.add(new MenuItem(3, "➡️ Passer au prochain niveau", "next_level")); // 🏆 Action pour changer de niveau
                break;
            case SKILL_SELECTION:
                menuItems.add(new MenuItem(1, "⚔️ Attaque → Dégâts augmentés", "attack"));
                menuItems.add(new MenuItem(2, "🛡️ Défense → Moins de dégâts subis", "defense"));
                break;
            default:
                System.out.println("❌ Type de menu inconnu : " + menuType);
                break;
        }
    }

    // 🟢 Getter pour récupérer le menu
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}