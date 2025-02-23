import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level {
    private String title;
    private String intro;
    private String specialization;
    private String outro;
    private Queue<Enemy> enemies;

    public Level(String name, String intro, String specialization,  String outro, List<Enemy> enemyList) {
        this.title = name;
        this.intro = intro;
        this.specialization = specialization;
        this.outro = outro;
        this.enemies = new LinkedList<>(enemyList);
    }
    public Level(String name, String intro,  String outro, List<Enemy> enemyList) {
        this.title = name;
        this.intro = intro;
        this.outro = outro;
        this.enemies = new LinkedList<>(enemyList);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    // ✅ Vérifie s'il reste des ennemis dans ce niveau
    public boolean hasRemainingEnemies() {
        return !enemies.isEmpty();
    }

    // ✅ Récupère le prochain ennemi
    public Enemy getNextEnemy() {
        return enemies.poll(); // 🔹 Supprime et retourne le prochain ennemi
    }
}
