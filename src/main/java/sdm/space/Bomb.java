package sdm.space;

public class Bomb {
    private int x;
    private int y;
    private boolean collided=false;

    public Bomb() {
        x = 0;
        y = 0;
    }

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

    public boolean hasCollided() {
        return collided;
    }

    public void collide() {
        collided = true;
    }
}
