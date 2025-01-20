package sdm.space;

import sdm.gui.Drawable;

public class AlienSpeedy extends Drawable {

    private boolean movingRight;
    private boolean escaped=false;

    public AlienSpeedy() {
        super();
    }

    public AlienSpeedy(int width, int height, String imageName) {
        super(0, 10, width, height, imageName);
        initSpeedy();
    }

    public AlienSpeedy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public AlienSpeedy(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height, imageName);
    }

    private void initSpeedy() {
        movingRight = Math.random() < 0.5;
        this.x = movingRight ? 0 : windowWidth;
    }

    public void move() {
        if (movingRight) {
            moveRight();
        } else {
            moveLeft();
        }
    }

    public void moveRight() {
        x += 4;
        if (x >= windowWidth) {
            escaped=true;
            die();
        }
    }

    public void moveLeft() {
        x -= 4;
        if (x <= 0) {
            escaped=true;
            die();
        }
    }

    public boolean isEscaped() {
        return escaped;
    }

}