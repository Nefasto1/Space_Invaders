package sdm.space;

import sdm.gui.Drawable;

public class Bomb extends Drawable {
    public Bomb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Bomb(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height, imageName);
    }

    public Bomb() {
        super();
    }

    public void move() {
        y += 2;
        if (y > windowHeight) {
            super.die();
        }
    }
}