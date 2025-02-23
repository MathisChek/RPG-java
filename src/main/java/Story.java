import java.util.ArrayList;

public class Story {
    private ArrayList<Level> levels;
    private int currentLevel = 0;
    private int levelsNumber;

    public Story(ArrayList<Level> levels) {
        this.levels = levels;
        this.levelsNumber = levels.size();
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

    public int getLevelsNumber() {
        return this.levelsNumber;
    }

    public int getCurrentLevelNumber() {
        return this.currentLevel;
    }

    public Level getCurrentLevel() {
        return this.levels.get(this.currentLevel);
    }

    public boolean nextLevel() {
        if (!isLastLevel()) {
            this.currentLevel++; // ✅ Avance au niveau suivant
            return true; // ✅ Indique que le changement de niveau a réussi
        }
        return false; // ❌ Empêche de dépasser le dernier niveau);
    }

    public boolean isLastLevel() {
        return this.currentLevel > this.levelsNumber - 1;
    }
}
