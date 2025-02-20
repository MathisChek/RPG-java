import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static ActionType choice;

    public static void main(String[] args) {
        // Initialisation de l'histoire
        StoryInitializer storyInitializer = new StoryInitializer();
        Story story = storyInitializer.getStory();
        System.out.println("Nombre de niveaux : " + story.getLevelsNumber());

        // 🔹 Instanciation de MenuInitializer pour les actions du combat
        MenuInitializer combatMenuInitializer = new MenuInitializer(MenuType.COMBAT);
        ArrayList<MenuItem> combatActions = combatMenuInitializer.getMenuItems();   // 🔹 Récupération des items du menu de combat
        ActionsMenu actionsMenu = new ActionsMenu("choisir une action", combatActions); // 🔹 Création du menu d'actions pour les combats

        // 🔹 Initialisation du menu de sélection des compétences
        MenuInitializer skillMenu = new MenuInitializer(MenuType.SKILL_SELECTION);
        ActionsMenu menu = new ActionsMenu("Sélection de compétence", skillMenu.getMenuItems());

        // 🔹 Création des personnages
        Player player = CharacterFactory.createPlayer("Joueur");
        Enemy enemy = CharacterFactory.createEnemy("Ennemi", player.getExperience(), 50);

        System.out.println(story.getLevelsNumber());

        while (!story.isLastLevel()) {
            System.out.println("Niveau " + (story.getCurrentLevelNumber() + 1) + " : " + story.getCurrentLevel().getTitle());
            System.out.println("Histoire " + story.getCurrentLevel().getIntro());

            ActionType choice = menu.exec(scanner);
            player.specialize(choice);

            do {
                System.out.println(player);
                System.out.println(enemy);

                // 🔹 Récupérer le choix en ActionType
                choice = actionsMenu.exec(scanner);

            } while (player.fight(enemy, choice));

            System.out.println(story.getCurrentLevel().getOutro());
            break;
        }
    }

    public static void handleCombatEndMenu(Player player, Story story, Scanner scanner) {
        System.out.println("\n🏆 Le combat est terminé !");
        System.out.println("Que voulez-vous faire ?");

        // 🔹 Choisir le bon menu en fonction des ennemis restants
        MenuType menuType = story.getCurrentLevel().hasMoreEnemies() ? MenuType.COMBAT_END : MenuType.LEVEL_END;
        MenuInitializer menuInitializer = new MenuInitializer(menuType);
        ActionsMenu actionsMenu = new ActionsMenu("choisir une action", menuInitializer.getMenuItems());

        // 🔹 Afficher et récupérer l'action choisie
        ActionType choice = actionsMenu.exec(scanner);

        // 🔹 Exécuter l’action avec `ActionManager`
        ActionManager actionManager = new ActionManager();

        // 🔹 Vérifier si l'action nécessite `isOngoing`
        if (choice == ActionType.FIGHT || choice == ActionType.REST || choice == ActionType.ESCAPE) {
            boolean isOngoing = actionManager.executeAction(choice, player, story, true);

            // 🔄 Si l'action continue le combat, on rappelle le menu
            if (isOngoing) {
                handleCombatEndMenu(player, story, scanner);
            }
        } else {
            actionManager.executeAction(choice, player, story);
        }
    }
}
