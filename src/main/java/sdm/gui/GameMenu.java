package sdm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class GameMenu {
    final JPanel panel;

    public GameMenu(JPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics2D g2d, int width, int height, GameManager game) {
        drawBackground(g2d, width, height);
        drawScore(g2d, width, height, game.getScore());
        drawLives(g2d, width, height, game.getLives());

        game.draw(g2d, panel);
    }

    private void drawBackground(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, width, height);
        Line2D line = new Line2D.Double(0, height-height/4, width, height-height/4);
        g2d.setColor(Color.WHITE);
        g2d.draw(line);
    }

    private void drawScore(Graphics2D g2d, int width, int height, int score) {
        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = g2d.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString("Score: " + score, (width - fontMetrics.stringWidth("Score: " + score)) - 20,height - 50);
    }

    private void drawLives(Graphics2D g2d, int width, int height, int lives) {
        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = g2d.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString("Lives: " + lives, (width - fontMetrics.stringWidth("Lives: " + lives)) - 20, height - 70);
    }
}
