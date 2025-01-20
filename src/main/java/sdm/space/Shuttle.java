package sdm.space;

import sdm.gui.Drawable;

public class Shuttle extends Drawable {

    private int dx;

    public Shuttle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Shuttle() {
        super();
    }

    public Shuttle(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height, imageName);
    }

    public void move(){
        x += dx;
        if (x > windowWidth-rightOffset){
            x = windowWidth-rightOffset;
        }
        if (x<0){
            x = 0;
        }
    }
    public void moveRight() {
        dx = 3;
    }

    public void moveLeft() {
        dx = -3;

    }

    public void stayStill(){
        dx = 0;
    }
}