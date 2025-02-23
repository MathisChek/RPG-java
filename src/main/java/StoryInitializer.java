import java.util.ArrayList;
import java.util.Arrays;

public class StoryInitializer {
    private Story story;

    public StoryInitializer() {
        this.story = initializeStory();
    }

    private Story initializeStory() {
        ArrayList<Level> levels = new ArrayList<>();
        levels.add(new Level(
        "\n\uD83C\uDFD4L'Aube du Carnage",
    """
        Le vent hurle entre les pics acérés des Montagnes Noires, soulevant des tourbillons de cendres et de neige. 
        Le sol est souillé de sang séché, vestige d’anciens conflits oubliés. Ici, la lumière du jour peine à percer 
        le voile grisâtre des nuages. Seuls les plus téméraires osent fouler ces terres... et rares sont ceux qui en reviennent.
        
        Tu avances lentement, sentant le poids de ton propre souffle dans cette ambiance oppressante. 
        La rumeur court qu’un seigneur maudit, le Tyran de l’Abîme, règne sur ces terres désolées, 
        corrompant tout ce qui vit sur son passage. Des hordes de créatures fanatiques bloquent le chemin, 
        prêtes à se jeter sur ceux qui oseraient approcher sa forteresse.
        
        Alors que tu traverses un sentier bordé de ruines effondrées, une silhouette encapuchonnée 
        t’interpelle depuis l’ombre d’un arbre mort...
        
        🧑‍🎭 Un Étranger dans l'Ombre
        
        Une silhouette encapuchonnée t’interpelle depuis l’ombre d’un arbre mort. Son visage est dissimulé 
        sous un capuchon de cuir usé, mais son regard perçant brille d’une lueur étrange.
        
        👤 Marchand Mystérieux :
        "On dit que seul un fou ou un guerrier maudit s’aventure ici… et pourtant, te voilà."
        
        L’homme sort une fiole sombre de son manteau et la fait rouler entre ses doigts.
        
        "Si tu veux espérer survivre aux monstruosités qui hantent ces montagnes, il te faudra plus que du courage. 
        Bois ceci, et fais ton choix. Seras-tu l'ombre qui fauche ses ennemis dans un tourbillon d'acier… 
        ou le rempart impénétrable qui brise leurs assauts ?
        """,
        """
        ⚔️ Choix de spécialité 🛡️

        Le liquide dans la fiole a une teinte changeante, presque vivante. Son goût est âpre,
        mais une chaleur étrange t’envahit aussitôt. Un pouvoir ancien s’éveille en toi,
        un pouvoir qu’il te faut maîtriser dès maintenant.

        Alors que la transformation s’opère en toi, un cri guttural résonne dans la brume. 
        ❗ Quelque chose approche…
        
        🔥 Le combat commence. Prépare-toi à affronter ton premier ennemi.
        """,
        """
        📜 Fin du Niveau 1 – Premiers Sanglants Pas
        
        Après avoir tranché le dernier adversaire, tu observes les cadavres gisant à tes pieds. 
        Ces êtres n’étaient que des éclaireurs. Une lueur sinistre brille au sommet de la montagne… 
        Le véritable cauchemar ne fait que commencer.
        
        La brume s’épaissit alors que tu avances sur le sentier, 
        menant aux bois corrompus qui s’étendent à perte de vue.
        
        🔥 Prochain niveau : La Forêt des Pleurs.
        """,
        Arrays.asList(
                CharacterFactory.createEnemy("Squelette Guerrier", 10, 20)
//              CharacterFactory.createEnemy("Zombie Déchaîné", 12, 25)
//              CharacterFactory.createEnemy("Nécromancien", 15, 40)
        )
        ));

        levels.add(new Level(
            "🌲 La Forêt des Pleurs",
            """
            Les montagnes sont derrière toi, mais l’air ne semble pas moins lourd. Devant s’étend une forêt épaisse,
            où les arbres tordus ressemblent à des silhouettes décharnées tendant leurs bras vers le ciel.
            Une brume épaisse rampe entre les racines, rendant chaque pas incertain.

            Ici, le silence est anormal. Pas d’oiseaux, pas d’insectes. Juste le vent qui murmure entre les branches…
            ou peut-être est-ce autre chose ? Des légendes racontent que cette forêt avale ceux qui s’y égarent,
            piégés à jamais dans un cauchemar vivant.

            Alors que tu progresses sur un sentier étroit, un son brise le silence : un râle… non, un gémissement.

            💀 Une Rencontre Funeste

            Adossé contre un rocher moussu, un homme en guenilles se tient à peine debout.
            Son corps est couvert de lacérations profondes, et ses yeux creusés trahissent des jours de souffrance.

            👤 Étranger Blessé :
            "Ils… ils ne sont plus humains… Ils… *grhhh*… ils t’attendent dans l’ombre…"

            Avant même que tu puisses réagir, il pousse un hurlement inhumain et se jette sur toi,
            le regard vide de toute raison.

            ❗ Ce n’était plus un homme… mais une aberration. Quelque chose dans cette forêt
            déforme les corps et corrompt les âmes.

            👁️ Les Cauchemars de la Forêt

            Après avoir terrassé l’homme, les ombres autour de toi bougent.

            Les arbres s’écartent lentement… non, ce ne sont *pas* des arbres. Des silhouettes encapuchonnées émergent
            du brouillard, leurs membres étirés d’une façon inhumaine.

            🔮 Leurs murmures résonnent dans ton crâne :
            "Rejoins-nous… Dépose les armes… Tu n’as plus besoin de combattre…"

            Mais tu ne peux pas t’arrêter ici. Quelque part dans cette forêt, une vérité t’attend.
            Une clef pour atteindre le cœur de ce royaume en ruines.

            ⚔️ Prépare-toi. Ce ne sont pas de simples adversaires… mais des êtres dont la douleur les rend plus forts.
            """,
            """
            📜 Fin du Niveau 2 – Un Chemin sans Retour

            Le dernier ennemi s’écroule, mais la forêt ne retrouve pas son silence.
            Un grondement sourd résonne au loin.

            Alors que tu arrives à la lisière du bois, la brume se dissipe peu à peu, révélant une terre dévastée.
            Des ruines fumantes bordent un chemin menant à une forteresse encerclée par des flammes noires.

            Tu comprends maintenant… ce n’est pas une malédiction, mais une guerre.

            🏰 Prochain niveau : Les Ruines de Cendres.
            """,
            Arrays.asList(
                    CharacterFactory.createEnemy("Spectre de l'Ombre", 18, 50)
    //                        CharacterFactory.createEnemy("Vampire Sanguinaire", 22, 70),
            )
        ));

        levels.add(new Level(
            "\uD83D\uDD25Les Ruines de Cendres",
            """
            Le vent porte une odeur de cendre et de chair brûlée. Autour de toi, les bâtiments éventrés
            semblent gémir sous le poids de leur propre ruine. Ici, tout n’est que destruction, vestige d’un massacre oublié.

            Autrefois, cette cité était un symbole de puissance et de grandeur. Aujourd’hui, il n’en reste
            que des ossements calcinés et des murs éventrés, comme si le feu lui-même avait voulu effacer son existence.

            ❗ Mais tu n’es pas seul.

            Dans les ruelles étroites, des ombres glissent entre les décombres. Leurs yeux rougeoyants
            trahissent une haine qui défie la mort elle-même. Ce ne sont pas simplement des ennemis...
            **Ce sont les fantômes d’anciens guerriers, condamnés à errer sans fin.**

            Si tu veux survivre, il te faudra plus que ton épée. **Leur rage est plus forte que la douleur,
            et leur souffrance alimente leur puissance.**

            ⚔️ Prépare-toi. Ici, ce n’est pas seulement ton corps qu’ils veulent briser… **c’est ton âme.**

            💀 Un Seigneur Déchu

            Une silhouette massive se dresse au milieu d’une place en ruines. Un chevalier en armure brisée,
            tenant une épée aussi grande qu’un homme. Son armure est noircie par les flammes, ses yeux
            vides de toute humanité.

            👤 Seigneur des Cendres :
            "Tu oses fouler les terres des morts ? Ce royaume n’appartient plus aux vivants."

            Tu sens le poids de sa présence écraser l’air autour de toi. Chaque pas qu’il fait résonne comme
            un glas funéraire. Ce n’est pas un simple adversaire. **C’est un gardien de l’enfer.**

            ❗ Il lève son arme et l’abat avec une force démesurée. Le sol tremble sous l’impact.

            🛡️ **Tiens bon, ou sois consumé par les flammes des damnés.**

            🔥 Les Épreuves des Ruines

            La cité en flammes est un labyrinthe de mort. Chaque ruelle cache un piège, chaque ombre est
            une menace. Mais au cœur du chaos, une chose est certaine : **quelqu’un ou quelque chose t’observe.**

            ▪️ Des lames surgissent des ténèbres, des créatures émaciées bondissent sur toi avec une rage aveugle.
            ▪️ Le sol cède sous tes pas, révélant des fosses pleines de flammes et de cadavres calcinés.
            ▪️ **Les hurlements des âmes piégées résonnent dans ta tête.**

            Chaque affrontement te rapproche du château du Tyran… mais te consume un peu plus à chaque instant.

            ❗ **Survivras-tu à cette ville maudite ? Ou rejoindras-tu ceux qui y sont morts avant toi ?**
            """
            ,
            """
            📜 Fin du Niveau 3 – La Dernière Porte

            Dans un dernier élan, ton arme traverse la carcasse du Seigneur des Cendres. Un râle rauque s’échappe
            de sa gorge alors qu’il s’effondre à genoux. Son armure brisée s’écroule dans la poussière… et
            son corps disparaît dans un tourbillon de cendres.

            🌪️ Un vent chaud souffle à travers la ville dévastée. Devant toi, une immense porte d’acier noir se dresse,
            marquée de symboles anciens. De l’autre côté, le trône du Tyran t’attend.

            **Tu n’es plus qu’à une bataille de la vérité.**

            🔥 **Prochain niveau : La Forteresse du Tyran.**
            """,
            Arrays.asList(
                    CharacterFactory.createEnemy("Seigneur Labyrinthique", 40, 100)
//                  CharacterFactory.createEnemy("Commandant brulé", 40, 100)
            )
        ));

        levels.add(new Level(
            "👑 La Forteresse du Tyran",
            """
            Tu te tiens devant les immenses portes noires de la forteresse. Hautes de plusieurs mètres, 
            elles semblent avoir été forgées dans une matière plus sombre que la nuit elle-même. 
            Un souffle glacé s’échappe des interstices, comme si ce lieu rejetait toute présence vivante.
            
            ❗ En posant la main sur la porte, un frisson remonte ton échine. Ce n’est pas du métal… c’est 
            quelque chose de vivant. Et ça attend.
            
            Les battants s’ouvrent lentement dans un vacarme assourdissant, révélant une **salle de trône colossale**, 
            où le temps lui-même semble suspendu. À l’autre bout, une silhouette massive repose sur un siège d’ossements, 
            son regard vide fixé sur toi.
            
            👤 Tyran de l’Abîme :
            "Tu as marché à travers le sang et la cendre… et pourtant, te voilà. 
            Croit-tu vraiment pouvoir me vaincre ?"
            
            Son rire résonne comme un glas funèbre. Les murs tremblent sous la puissance de sa présence.  
            Il se lève, et en un instant, l’atmosphère devient suffocante.  
            **Ce combat n’est pas comme les autres. Ce n’est pas une simple bataille… c’est une fin.**  
            
            ⚔️ **Prépare-toi. Le destin du monde repose sur cette confrontation.**
            """,
            """
            📜 Fin du Voyage – Le Dernier Souffle

            Le coup final transperce l’armure du Tyran. Un râle d’agonie s’échappe de sa gorge,
            son corps massif s’effondrant sous son propre poids. Les runes maudites sur les murs
            s’illuminent une dernière fois… puis s’éteignent.
            
            🌪️ Un vent puissant balaie la salle du trône, emportant les cendres du monstre
            et avec elles, des siècles de souffrance et de ténèbres. La forteresse tremble,
            comme si elle-même sentait la fin approcher.
    
            Tu titubes hors de la citadelle alors que les murs s’écroulent derrière toi.
            Lorsque tu lèves les yeux, l’aube perce enfin les nuages sombres, illuminant un monde
            libéré de son oppresseur.
            
            **Tu as survécu. Mais à quel prix ?**
            
            ❗ **Ton combat est terminé… mais ton histoire ne fait que commencer.**
            """,
            Arrays.asList(
                    CharacterFactory.createEnemy("Spectre de l'Ombre", 35, 120)
                    //                        CharacterFactory.createEnemy("Vampire Sanguinaire", 40, 200),
                    //                        CharacterFactory.createEnemy("Seigneur Démoniaque", 50, 300)
            )
        ));
        return this.story = new Story(levels);
    }

    public Story getStory() {
        return story;
    }
}