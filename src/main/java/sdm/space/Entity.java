package sdm.space;

public abstract class Entity {
    protected int x;
    protected int y;
    protected boolean alive = true;

    public Entity() {
        this.x = 0;
        this.y = 0;
    }

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        this.alive = false;
    }
}
