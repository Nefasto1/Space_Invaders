package sdm.space;

public class Alien {
    private int x;
    private int y;
    private boolean alive = true;

    public Alien(){
        x = 0;
        y = 0;
    }

    public Alien(int x, int y) {
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

    public void moveLeft() {
        x -= 2;
    }

}