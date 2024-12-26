package sdm.space;

public class Projectile {
    private final int x;
    private int y;
    private boolean collided=false;

    public Projectile() {
        x = 0;
        y = 0;
    }

    public Projectile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        y += 5;
        if (y > 500) {
            y = 500;
        }
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
