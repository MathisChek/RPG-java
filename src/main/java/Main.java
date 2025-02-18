import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String choice;

    public static void main(String[] args) {
        Level topLevel = new Level(
                "L'ombre du passé",
                "Il était une fois un village perdu dans les montagnes, où une légende ancienne hantait encore les esprits...",
                "Ainsi, le mystère de l’ombre du passé fut levé, laissant derrière lui un village enfin en paix."
        );

        ArrayList<Level> levels = new ArrayList<>();

        levels.add(new Level(
                "Les murmures de la forêt",
                "Alors que Léa s’aventurait seule dans la forêt interdite, elle entendit des voix chuchoter son nom...",
                "Les esprits de la forêt, enfin apaisés, disparurent dans un dernier souffle de vent."
        ));

        levels.add(new Level(
                "Le dernier train pour Minuit",
                "Paul monta à bord du train en direction d’une destination inconnue, sans savoir qu’il ne reviendrait jamais...",
                "À Minuit, le train s’effaça dans l'obscurité, ne laissant derrière lui qu’une gare vide et silencieuse."
        ));

        levels.add(new Level(
                "Le secret du vieux phare",
                "Par une nuit brumeuse, un jeune marin trouva une carte menant à un phare oublié...",
                "Le secret du vieux phare révéla un trésor inestimable : une lettre d’amour jamais envoyée."
        ));

        ArrayList<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(
                1,
                "Combattre",
                "fight"
        ));

        menuItems.add(new MenuItem(
                2,
                "Se reposer",
                "rest"
        ));

        menuItems.add(new MenuItem(
                3,
                "Prendre la fuite",
                "escape"
        ));

        ActionsMenu actionsMenu = new ActionsMenu("choisir une action", menuItems);

        /*
         * ********** Tests des classes Player et Enemy
         */
        Player player = new Player("Joueur");
        Enemy enemy = new Enemy("Ennemi", player.getExperience());

        player.getAttackManager().addAttack("Coup d'épée", new Attack("Coup d'épée", 30, player));
        player.getAttackManager().addAttack("Coup de poing", new Attack("Coup de point", 10, player));

        enemy.getAttackManager().addAttack("Coup d'épée", new Attack("Coup d'épée", 30, player));

        /*
         * ********** Tests des classes Story et Level
         */
        Story story = new Story(topLevel, levels);
        System.out.println("Nombre de niveaux : " + story.getLevelsNumber());

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
