package sdm.space;

public class Shuttle {
    private int x;
    private final int y;


    public Shuttle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRight() {
        x += 2;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }
}