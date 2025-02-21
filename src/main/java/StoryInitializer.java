import java.util.ArrayList;
import java.util.Arrays;

public class StoryInitializer {
    private Story story;

    public StoryInitializer() {
        this.story = initializeStory();
    }

    private Story initializeStory() {
        Level topLevel = new Level(
                "L'ombre du passé",
                "Il était une fois un village perdu dans les montagnes, où une légende ancienne hantait encore les esprits...",
                "Ainsi, le mystère de l’ombre du passé fut levé, laissant derrière lui un village enfin en paix.",
                Arrays.asList(
                        CharacterFactory.createEnemy("Loup Sauvage", 5, 10),
                        CharacterFactory.createEnemy("Gobelin Fourbe", 7, 15)
                )
        );

        ArrayList<Level> levels = new ArrayList<>();
        levels.add(new Level(
                "Les murmures de la forêt",
                "Alors que Léa s’aventurait seule dans la forêt interdite, elle entendit des voix chuchoter son nom...",
                "Les esprits de la forêt, enfin apaisés, disparurent dans un dernier souffle de vent.",
                Arrays.asList(
                        CharacterFactory.createEnemy("Squelette Guerrier", 10, 20),
                        CharacterFactory.createEnemy("Zombie Déchaîné", 12, 25),
                        CharacterFactory.createEnemy("Nécromancien", 15, 40)
                )
        ));

        levels.add(new Level(
                "Le dernier train pour Minuit",
                "Paul monta à bord du train en direction d’une destination inconnue, sans savoir qu’il ne reviendrait jamais...",
                "À Minuit, le train s’effaça dans l'obscurité, ne laissant derrière lui qu’une gare vide et silencieuse.",
                Arrays.asList(
                        CharacterFactory.createEnemy("Spectre de l'Ombre", 18, 50),
                        CharacterFactory.createEnemy("Vampire Sanguinaire", 22, 70),
                        CharacterFactory.createEnemy("Seigneur Démoniaque", 30, 100)
                )
        ));

        levels.add(new Level(
                "Le secret du vieux phare",
                "Par une nuit brumeuse, un jeune marin trouva une carte menant à un phare oublié...",
                "Le secret du vieux phare révéla un trésor inestimable : une lettre d’amour jamais envoyée.",
                Arrays.asList(
                        CharacterFactory.createEnemy("Spectre de l'Ombre", 35, 120),
                        CharacterFactory.createEnemy("Vampire Sanguinaire", 40, 200),
                        CharacterFactory.createEnemy("Seigneur Démoniaque", 50, 300)
                )
        ));

        return this.story = new Story(topLevel, levels);
    }

    public Story getStory() {
        return story;
    }
}