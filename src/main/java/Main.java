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

//        // 🔹 Instanciation de MenuInitializer pour les actions en dehors du combat
//        MenuInitializer combatEndMenuInitializer = new MenuInitializer(MenuType.COMBAT_END);
//        ArrayList<MenuItem> combatEndActions = combatEndMenuInitializer.getMenuItems();  // 🔹 Récupération des items du menu en dehors des combats
//        ActionsMenu combatEndMenu = new ActionsMenu("choisir une action", combatEndActions); // 🔹 Création du menu d'actions pour les combats

        // 🔹 Création des personnages
        Player player = CharacterFactory.createPlayer("Joueur");
        Enemy enemy = CharacterFactory.createEnemy("Ennemi", player.getExperience(), 50);

        System.out.println(story.getLevelsNumber());

//        while (!story.isLastLevel()) {
//            System.out.println("Niveau " + story.getCurrentLevelNumber() + " : " + story.getCurrentLevel().getTitle());
//            story.nextLevel();
//        }

//        do {
//            System.out.println(player);
//            System.out.println(enemy);
//            choice = actionsMenu.exec(scanner);
//        } while(player.fight(enemy, choice));

//        System.out.println(player);
//        System.out.println(enemy);

        while (!story.isLastLevel()) {
            System.out.println("Niveau " + (story.getCurrentLevelNumber() + 1) + " : " + story.getCurrentLevel().getTitle());
            System.out.println("Histoire " + story.getCurrentLevel().getIntro());

            do {
                System.out.println(player);
                System.out.println(enemy);

                // 🔹 Récupérer le choix en ActionType
                choice = actionsMenu.exec(scanner);

            } while (player.fight(enemy, choice));

            System.out.println(story.getCurrentLevel().getOutro());
            break;
        }

        // Generer les menu items pour le repos,
        // Permet de choisir après un combat si on peut se reposer ou continuer TODO : AJouter cette partie après un combat (peut etre directement à la fin de la méthode fight (dire bravo et proposer de se reposer)
        //        ArrayList<MenuItem> restItems = new ArrayList<>();
        //
        //        restItems.add(new MenuItem(
        //                1,
        //                "Oui, se reposer",
        //                null
        //        ));
        //
        //        restItems.add(new MenuItem(
        //                2,
        //                "Non, continuer d'avancer",
        //                null
        //        ));
        //
        //        RestMenu restMenu = new RestMenu("choisir une action", restItems);
        //
        //        // Recuperer le choix du joueur
        //        String choice = restMenu.exec(new java.util.Scanner(System.in));
    }

    public static void handleCombatEndMenu(Player player, Story story, Scanner scanner) {
        System.out.println("\n🏆 Le combat est terminé !");
        System.out.println("Que voulez-vous faire ?");

        // 🔹 Création du menu de fin de combat
        MenuInitializer combatEndMenuInitializer = new MenuInitializer(MenuType.COMBAT_END);
        ArrayList<MenuItem> combatEndActions = combatEndMenuInitializer.getMenuItems();
        ActionsMenu combatEndMenu = new ActionsMenu("choisir une action", combatEndActions);

        // 🔹 Afficher et récupérer l'action choisie
        ActionType choice = combatEndMenu.exec(scanner);

        // 🔹 Exécuter l’action avec `ActionManager`
        ActionManager actionManager = new ActionManager();

        if (choice == ActionType.FIGHT || choice == ActionType.REST || choice == ActionType.ESCAPE) {
            boolean isOngoing = actionManager.executeAction(choice, player, story, true);
            if (isOngoing) {
                handleCombatEndMenu(player, story, scanner);
            }
        } else {
            actionManager.executeAction(choice, player, story);
        }
    }
}
