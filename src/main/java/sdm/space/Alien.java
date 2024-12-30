package sdm.space;

public class Alien extends Entity {

    private boolean movingRight = true;

    public Alien(int x, int y) {
        super(x, y);
    }

    public Alien() {
        super();
    }

    public void move() {
        if (movingRight) {
            moveRight();
        } else {
            moveLeft();
        }
    }

    public void moveRight() {
        x += 2;
        if (x >= 500) {
            moveDown();
            movingRight = false;
        }
    }

    public void moveLeft() {
        x -= 2;
        if (x <= 0) {
            moveDown();
            movingRight = true;
        }
    }

    public void moveDown() {
        y += 15;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }


}