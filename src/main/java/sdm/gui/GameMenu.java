package sdm.gui;

import sdm.space.Alien;
import sdm.space.Bomb;
import sdm.space.Projectile;

import javax.swing.*;
import java.awt.*;

public class GameMenu {
    JPanel panel;

    public GameMenu(JPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics2D g2d, int width, int height, GameManager game) {
        drawBackground(g2d, width, height);
        drawScore(g2d, width, height, game.getScore());
        drawLives(g2d, width, height, game.getLives());

        drawShuttle(g2d, panel, game);
        drawAliens(g2d, panel, game);
        drawBullets(g2d, panel, game);
        drawBombs(g2d, panel, game);
    }

    private void drawBackground(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, width, height);
    }

    private void drawScore(Graphics2D g2d, int width, int height, int score) {
        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = g2d.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString("Score: " + score, (width - fontMetrics.stringWidth("Score: " + score)) - 10,height - 50);
    }

    private void drawLives(Graphics2D g2d, int width, int height, int lives) {
        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = g2d.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString("Lives: " + lives, 10, height - 50);
    }


    public void drawShuttle(Graphics2D g2d, JPanel panel, GameManager game) {
        game.getShuttle().draw(g2d, panel);
    }

    public void drawAliens(Graphics2D g2d, JPanel panel, GameManager game) {
        game.getAliens().stream().filter(Alien::isAlive).forEach(alien -> alien.draw(g2d, panel));
    }

    public void drawBullets(Graphics2D g2d, JPanel panel, GameManager game) {
        game.getBullets().stream().filter(Projectile::isAlive).forEach(bullet -> bullet.draw(g2d, panel));
    }

    public void drawBombs(Graphics2D g2d, JPanel panel, GameManager game) {
        game.getBombs().stream().filter(Bomb::isAlive).forEach(bomb -> bomb.draw(g2d, panel));
    }
}
