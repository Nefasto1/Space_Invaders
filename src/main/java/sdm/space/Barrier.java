package sdm.space;

import sdm.gui.Drawable;

public class Barrier extends Drawable {
    private int lives = 4;
    private final String imageName;

    public Barrier() {
        super();
        imageName = "";
    }

    public Barrier(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height);
        this.imageName = imageName;

        loadImage(imageName + lives + ".png");
    }

    public int getLives() {
        return lives;
    }

    @Override
    public boolean isAlive(){
        return lives > 0;
    }

    @Override
    public void die(){
        if (lives > 0) {
            lives--;
            if (!imageName.isEmpty())
                loadImage(imageName + lives + ".png");
        }
    }

}