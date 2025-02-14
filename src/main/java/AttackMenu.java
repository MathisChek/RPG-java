import java.util.ArrayList;
import java.util.Map;

public class AttackMenu extends BaseMenu {
    private static final String DEFAULT_TITLE_FR = "Listes des compétences";

    public AttackMenu(AttackManager attaqueManager) {
        super(DEFAULT_TITLE_FR, generateMenuItems(attackManager)); // Récupère directement les noms des attaques
    }

    private static ArrayList<MenuItem> generateMenuItems(AttackManager attaqueManager) {
        ArrayList<MenuItem> items = new ArrayList<>();
        int rank = 1;
        for (Map.Entry<String, Attack> entry : attaqueManager.getAttack().entrySet()) {
            items.add(new MenuItem(rank++, entry.getKey(), entry.getKey(), true));
        }
        return items;
    }

    // Cette classe reste simple, car la magie est dans la récupération dynamique des attaques.
}