import java.util.ArrayList;
import java.util.List;

public class MenuInitializer {
    private ArrayList<MenuItem> menuItems;  // Liste des éléments du menu

    // 🟢 Constructeur qui initialise le menu
    public MenuInitializer() {
        this.menuItems = new ArrayList<>();
        initializeMenu();
    }

    // 🟢 Méthode pour initialiser les items du menu
    private void initializeMenu() {
        menuItems.add(new MenuItem(1, "Combattre", "fight"));
        menuItems.add(new MenuItem(2, "Se reposer", "rest"));
        menuItems.add(new MenuItem(3, "Acheter des objets", "purchase"));
        menuItems.add(new MenuItem(4, "Prendre la fuite", "escape"));
    }

    // 🟢 Getter pour récupérer le menu
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}