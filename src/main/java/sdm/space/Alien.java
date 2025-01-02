package sdm.space;

import sdm.gui.Drawable;

public class Alien extends Drawable {

    private boolean movingRight = true;

    public Alien(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Alien() {
        super();
    }

    public Alien(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height, imageName);
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