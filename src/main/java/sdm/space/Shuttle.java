package sdm.space;

import sdm.gui.Drawable;

public class Shuttle extends Drawable {

    private int stepX;

    public Shuttle() {
        super();
    }
    public Shuttle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Shuttle(int x, int y, int width, int height, int windowWidth, int windowHeight, String imageName) {
        super(x,y,width,height,windowWidth, windowHeight, imageName);}

    public void move(){
        x += stepX;
        if (x > windowWidth-rightOffset){
            x = windowWidth-rightOffset;
        }
        if (x<0){
            x = 0;
        }
    }
    public void setStepToRight() {
        stepX = 3;
    }

    public void setStepToLeft() {
        stepX = -3;

    }

    public void stayStill(){
        stepX = 0;
    }
}