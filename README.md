# RPG-java

## Etat d'avencement

- [x] Système de combat
- [x] Système de Fuite
- [x] Système de Menu Action (il manque repos et elixir)
- [x] Système de Menu Attack
- [x] Système de Menu Items
- [x] Système d'Action
- [x] Système de repos
- [x] Mettre en place la boucle de gameplay (enchainement des levels et scenario)
- [x] Système d'achats
- [x] La prise en compte des repos (rest) et équipements (purchase) dans le calcul des points de vie (health) et d'expérience (experience) du joueur.
- [x] Documentation Character

## Diagramme de class (UML)

RPG-java/digramme.png

## Difficultés rencontrées et solutions adoptées

- Ajouter des nouvelles fonctionnalités en gardant un code maintenable, scalable et générique sans perdre la maîtrise du code
  - Solution : garder en tête le paradigme Objet et ajouter des fonctionnalités petit bout par petit bout

## Bilan des acquis

   🔹 Encapsulation → Structuration du jeu en objets bien définis (Player, Enemy, Story, Level).
   🔹 Héritage → Réutilisation des propriétés et comportements (Enemy vs BossEnemy).
   🔹 Polymorphisme → Gestion uniforme des ennemis et attaques via des méthodes génériques (attack()).
   🔹 Abstraction → Imposition d'une structure (Character impose attack() et takeDamage()).
   🔹 Association / Composition → Un Story gère des Level, un Level gère des Enemy...

