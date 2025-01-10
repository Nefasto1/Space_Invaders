package sdm.space;

import sdm.gui.Drawable;

public class Alien extends Drawable {

    private int speed = 2;

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
        x += speed;
        if (x >= 445) {
            x = 445;
            moveDown();
            movingRight = false;
        }
    }

    public void moveLeft() {
        x -= speed;
        if (x <= 0) {
            x = 0;
            moveDown();
            movingRight = true;
        }
    }

    public void moveDown() {
        y += 15;
        moveDownCounter++;
        if (moveDownCounter % 6 == 0) {
            increaseSpeed();
        }
    }

    public void increaseSpeed() {
        speed += 1;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }


}