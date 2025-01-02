package sdm.space;

import sdm.gui.Drawable;

public class Shuttle extends Drawable {

    public Shuttle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Shuttle() {
        super();
    }

    public Shuttle(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height, imageName);
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
}