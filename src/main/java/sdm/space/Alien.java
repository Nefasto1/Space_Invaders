package sdm.space;

import sdm.gui.Drawable;

public class Alien extends Drawable {

    private int x_speed = 2;
    private int y_speed = 15;

    private int moveDownCounter = 0;

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
        x += x_speed;
        if (x >= windowWidth - rightOffset) {
            x = windowWidth - rightOffset;
            moveDown();
            movingRight = false;
        }
    }

    public void moveLeft() {
        x -= x_speed;
        if (x <= 0) {
            x = 0;
            moveDown();
            movingRight = true;
        }
    }

    public void moveDown() {
        y += y_speed;
        moveDownCounter++;
        if (moveDownCounter % 10 == 0) {
            increaseSpeed();
        }
    }

    public void increaseSpeed() {
        x_speed += 1;
    }

    public int getX_speed() {
        return x_speed;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }


}