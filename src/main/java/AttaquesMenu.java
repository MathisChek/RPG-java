import java.util.ArrayList;
import java.util.Map;

public class AttaquesMenu extends BaseMenu {

    public AttaquesMenu(String title, AttaqueManager attaqueManager) {
        super(title, generateMenuItems(attaqueManager)); // Récupère directement les noms des attaques
    }

    private static ArrayList<MenuItem> generateMenuItems(AttaqueManager attaqueManager) {
        ArrayList<MenuItem> items = new ArrayList<>();
        int rank = 1;
        for (Map.Entry<String, Attaque> entry : attaqueManager.getAttaques().entrySet()) {
            items.add(new MenuItem(rank++, entry.getKey(), entry.getKey(), true));
        }
        return items;
    }

    // Cette classe reste simple, car la magie est dans la récupération dynamique des attaques.
}