import java.util.ArrayList;
import java.util.Scanner;

public abstract class BaseMenu {
    private String title;
    private ArrayList<MenuItem> items;
    private int defaultChoice;
    private int numberOfChoices = 0;


    public BaseMenu(String title, ArrayList<MenuItem> items, int defaultChoice) {
        this.title = title;
        this.items = items;
        this.defaultChoice = defaultChoice;
        this.items.removeIf(item -> item.isDisabled()); // Supprime de notre ArrayList les MenuItem désactivés
        this.numberOfChoices = this.items.size();
        // TODO Vérifier qu'aucun doublon de valeur de position n'est présent dans notre ArrayList
        this.items.sort((item1, item2) -> item1.getchoiceRank() - item2.getchoiceRank()); // Tri notre ArrayList en fonction du choiceRank
    }

    public BaseMenu(String title, ArrayList<MenuItem> items) {
        this(title, items, 1);
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title;}

    public ArrayList<MenuItem> getItems() { return items;}

    public void setItems(ArrayList<MenuItem> items) { this.items = items; }

    public int getDefaultChoice() { return defaultChoice; }

    public void setDefaultChoice(int defaultChoice) { this.defaultChoice = defaultChoice; }

    public int getNumberOfChoices() { return numberOfChoices; }

    public void setNumberOfChoices(int numberOfChoices) { this.numberOfChoices = numberOfChoices; }

    public ActionType exec(Scanner scanner) {
        int choice = -1;
        do {
            System.out.print(this);
            if (choice > numberOfChoices) {
                System.out.println("Veuillez saisie une valeur comprise entre 1 et " + numberOfChoices + ".");
            }
            System.out.print(">>> ");
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                choice = -1;  // En cas d'erreur, on reste dans la boucle d'interaction
                System.out.println("Veuillez saisir quelque chose.");
            }
        } while (choice < 1 || choice > numberOfChoices);

        String choiceStr = items.get(choice - 1).getChoiceAction(); // 🔹 Récupère le nom de l'action en `String`

        // 🔹 Convertir en `ActionType`
        ActionType actionChoice = null;
        for (ActionType action : ActionType.values()) {
            if (action.name().equalsIgnoreCase(choiceStr)) {
                actionChoice = action;
                break;
            }
        }

        System.out.println("🔍 Debug: choiceStr = " + choiceStr);
        System.out.println("🔍 Debug: actionChoice = " + (actionChoice != null ? actionChoice.name() : "null"));

        return actionChoice;
    }

    public String toString() {
        // Définition des couleurs ANSI
        final String RESET = "\u001B[0m";  // Réinitialisation couleur
        final String CYAN = "\u001B[36m";  // Couleur titre
        final String GREEN = "\u001B[32m"; // Couleur pour options activées
        final String RED = "\u001B[31m";   // Couleur pour options désactivées

        StringBuilder menuItems = new StringBuilder();
        int index = 0;
        for (MenuItem item : items) {
            menuItems.append(item.isEnabled() ? "[" + ++index + "] " + item.getChoiceLabel() + ".\n" : "");
            //menuItems.append(item.isEnabled() ? "[" + item.getChoiceValue() + "] " + item.getChoiceLabel() + ".\n" : "");
        }

// Correction de l'affichage du menu
        String menuTemplate = """
        %s***************************************
        *          📜 MENU PRINCIPAL          *
        ***************************************
        %s%s
        %s***************************************
        %s
        """;

        String menu = String.format(menuTemplate, CYAN, GREEN, menuItems.toString().trim(), CYAN, RESET);

        return menu;
    }
}