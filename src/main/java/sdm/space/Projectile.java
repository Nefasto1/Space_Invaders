package sdm.space;

import sdm.gui.Drawable;

public class Projectile extends Drawable {
    public Projectile() {
        super();
    }
    public Projectile(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Projectile(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height, imageName);
    }
    public Projectile(int x, int y, int width, int height, int windowWidth, int windowHeight, String imageName) {
        super(x,y,width,height,windowWidth, windowHeight, imageName);}

    public void move() {
        y -= 5;
        if (y < 0) {
            super.die();
        }
    }
}