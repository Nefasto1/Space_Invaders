package sdm.space;

public class Shuttle {
    private int x;
    private final int y;
    private boolean alive = true;


    public Shuttle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shuttle() {
        x = 0;
        y = 0;
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

    public void moveLeft() {
        x -= 2;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
    }
}