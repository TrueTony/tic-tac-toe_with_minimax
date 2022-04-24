package tictactoe;

public class Move {

    private final Map map;
    private int score;

    public Move (Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
