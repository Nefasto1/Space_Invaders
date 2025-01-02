package sdm.gui;

import sdm.space.Entity;

import javax.swing.*;
import java.awt.*;

public class Drawable extends Entity {
    private Image image;

    public Drawable() {
        super();
        loadImage(null);
    }

    public Drawable(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadImage(null);
    }

    public Drawable(int x, int y, int width, int height, String imageName) {
        super(x, y, width, height);

        loadImage(imageName);
    }

    private void loadImage(String imageName) {
        if (imageName != null) {
            ImageIcon ii = new ImageIcon("src/main/resources/Images/" + imageName);
            image = ii.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } else {
            image = null;
        }
    }

    public void draw(Graphics2D g2d, JPanel panel) {
        g2d.drawImage(image, x, y, panel);
    }
}
