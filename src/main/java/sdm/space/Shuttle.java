package sdm.space;

public class Shuttle {
    private int x;
    private final int y;
    private boolean alive = true;
    private final int xRightLimit=500;
    private final int xLeftLimit=0;

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
        if (x>500){
            x = 500;
        }
    }

    public void moveLeft() {
        x -= 2;
        if (x<0){
            x = 0;
        }
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
        alive = false;
    }
}