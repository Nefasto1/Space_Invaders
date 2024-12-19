package sdm.space;

public class Projectile {
    private int x;
    private int y;
    private boolean collided=false;

    public Projectile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Projectile() {
        x = 0;
        y = 0;
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

    public boolean hasCollided() {
        return collided;
    }

    public void collide() {
        collided = true;
    }
}
