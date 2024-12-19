package sdm.space;

public class Projectile {
    private int x;
    private int y;

    public Projectile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        this.y +=5;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }
}
