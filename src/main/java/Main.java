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

        // 🔹 Création du personnage principale
        Player player = CharacterFactory.createPlayer("Joueur");

        while (!story.isLastLevel()) {
            System.out.println("Niveau " + (story.getCurrentLevelNumber() + 1) + " : " + story.getCurrentLevel().getTitle());
            System.out.println(story.getCurrentLevel().getIntro());

            ActionType choice = menu.exec(scanner);

            System.out.println(story.getCurrentLevel().getSpecialization()); if (story.getCurrentLevel().getSpecialization() != null);
            player.specialize(choice);

            while (story.getCurrentLevel().hasRemainingEnemies()) { // 🔹 Tant qu'il y a des ennemis
                Enemy enemy = story.getCurrentLevel().getNextEnemy(); // 🔹 Récupère le prochain ennemi
                System.out.println("⚔️ Un nouvel ennemi apparaît : " + enemy.getName());

                do {
                    System.out.println(player);
                    System.out.println(enemy);
                    choice = actionsMenu.exec(scanner);
                } while (player.fight(enemy, choice));

                if (story.getCurrentLevel().hasRemainingEnemies()) {
                    handleCombatEndMenu(player, story, scanner); // 🔹 Permet de récupérer après un combat
                }
            }

            System.out.println(story.getCurrentLevel().getOutro());
            handleLevelEndMenu(player, story, scanner); // 🔹 Ajoute un menu de fin de niveau
        }
        System.out.println("helo");
    }

    public static void handleCombatEndMenu(Player player, Story story, Scanner scanner) {
        System.out.println("\n🏆 Le combat est terminé !");
        System.out.println("Que voulez-vous faire ?");

        MenuType menuType = story.getCurrentLevel().hasRemainingEnemies() ? MenuType.COMBAT_END : MenuType.LEVEL_END;
        MenuInitializer menuInitializer = new MenuInitializer(menuType);
        ActionsMenu actionsMenu = new ActionsMenu("choisir une action", menuInitializer.getMenuItems());

        ActionType choice;
        ActionManager actionManager = new ActionManager();

        do {
            choice = actionsMenu.exec(scanner);
            boolean isOngoing = actionManager.executeAction(choice, player, story, true);

            // 🔹 Si l'action est NEXT_FIGHT, on continue le combat immédiatement
            if (choice == ActionType.NFIGHT) {
                break;
            }

            // 🔄 Tant que l'action n'est pas NEXT_FIGHT, on redemande un choix
        } while (choice != ActionType.NFIGHT);

        System.out.println("📢 Vous passez au combat suivant !");
    }

    public static void handleLevelEndMenu(Player player, Story story, Scanner scanner) {
        System.out.println("\n🏁 Vous avez terminé ce niveau !");

        // ✅ Vérification après l'affichage du message pour éviter de montrer le menu après le boss final
        if ((story.getCurrentLevelNumber() + 1) == story.getLevelsNumber()) {
            System.out.println("🏆 Vous avez terminé l'aventure !");
            GameManager.gameOver(true);
            return; // 🔹 Quitte immédiatement la méthode pour éviter l'affichage du menu
        }

        System.out.println("Que voulez-vous faire ?");

        player.resetRestCount();

        // 🔹 Création du menu de fin de niveau
        MenuInitializer menuInitializer = new MenuInitializer(MenuType.LEVEL_END);
        ActionsMenu levelEndMenu = new ActionsMenu("choisir une action", menuInitializer.getMenuItems());

        // 🔹 Exécuter l’action avec `ActionManager`
        ActionManager actionManager = new ActionManager();

        boolean finishedActions = false;

        while (!finishedActions) {
            // 🔹 Afficher et récupérer l'action choisie
            ActionType choice = levelEndMenu.exec(scanner);

            // 🔹 Si le joueur choisit NEXT_LEVEL, on sort de la boucle et passe au niveau suivant
            if (choice == ActionType.NLEVEL) {
                actionManager.executeAction(choice, player, story); // 🔹 Passe au niveau suivant
                finishedActions = true;
            } else {
                actionManager.executeAction(choice, player, story);
            }
        }
    }
}
