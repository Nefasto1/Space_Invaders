package sdm.space;

public abstract class Entity {
    protected int x;
    protected int y;
    protected final int width;
    protected final int height;
    protected boolean alive = true;

    protected final int windowWidth;
    protected final int windowHeight;
    protected final int rightOffset = 55;

    public Entity() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.windowWidth = 500;
        this.windowHeight = 500;
    }

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.windowWidth = 500;
        this.windowHeight = 500;
    }

    public Entity(int x, int y, int width, int height, int windowWidth, int windowHeight) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        this.alive = false;
    }
}