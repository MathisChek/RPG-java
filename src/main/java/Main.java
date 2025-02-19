import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String choice;

    public static void main(String[] args) {
        // Initialisation de l'histoire
        StoryInitializer storyInitializer = new StoryInitializer();
        Story story = storyInitializer.getStory();
        System.out.println("Nombre de niveaux : " + story.getLevelsNumber());

        // 🔹 Instanciation de MenuInitializer
        MenuInitializer menuInitializer = new MenuInitializer();

        // 🔹 Récupération des items du menu
        ArrayList<MenuItem> menuItems = menuInitializer.getMenuItems();

        // 🔹 Création du menu d'actions
        ActionsMenu actionsMenu = new ActionsMenu("choisir une action", menuItems);

        // 🔹 Création des personnages
        Player player = CharacterFactory.createPlayer("Joueur");
        Enemy enemy = CharacterFactory.createEnemy("Ennemi", player.getExperience(), 50);

        while (!story.isLastLevel()) {
            System.out.println("Niveau " + story.getCurrentLevelNumber() + " : " + story.getCurrentLevel().getTitle());
            story.nextLevel();
        }

        do {
            System.out.println(player);
            System.out.println(enemy);
            choice = actionsMenu.exec(scanner);
        } while(player.fight(enemy, choice));

        System.out.println(player);
        System.out.println(enemy);

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
}
