package sdm.space;

public class Bomb {
    private int x;
    private int y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        y -= 5;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }
}
