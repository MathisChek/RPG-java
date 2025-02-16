import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class AttackMenu extends BaseMenu {
    private static final String DEFAULT_TITLE_FR = "Listes des compétences";
    private final AttackManager attackManager;

    public AttackMenu(AttackManager attackManager) {
        super(DEFAULT_TITLE_FR, generateMenuItems(attackManager));
        this.attackManager = attackManager;// Récupère directement les noms des attacks
    }

    private static ArrayList<MenuItem> generateMenuItems(AttackManager attackManager) {
        ArrayList<MenuItem> items = new ArrayList<>();
        int rank = 1;
        for (Map.Entry<String, Attack> entry : attackManager.getAttacks().entrySet()) {
            items.add(new MenuItem(rank++, entry.getKey(), entry.getKey(), true));
        }
        return items;
    }

    public Attack execAttack(Scanner scanner) {
        int choice = -1;
        do {
            System.out.print(this);
            if (choice > getNumberOfChoices()) {
                System.out.println("Veuillez saisir une valeur comprise entre 1 et " + getNumberOfChoices() + ".");
            }
            System.out.print(">>> ");
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                choice = -1;
                System.out.println("Veuillez saisir quelque chose.");
            }
        } while (choice < 1 || choice > getNumberOfChoices());

        String attackName = getItems().get(choice - 1).getChoiceAction();
        return attackManager.getAttacks().get(attackName);  // Retourne l'Attack choisie
    }
    // Cette classe reste simple, car la magie est dans la récupération dynamique des attacks.
}