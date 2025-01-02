package sdm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel {
    private StartMenu startMenu;
    private EndMenu endMenu;
    private GameMenu gameMenu;
    private GameManager game;

    private String state = "Start";

    public GameBoard() {
        initializeBoard();
    }

    private void initializeBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        int width = 500;
        int height = 500;

        setSize(width, height);
        this.setLayout(null);

        startMenu = new StartMenu(this);
        endMenu = new EndMenu(this);
        gameMenu = new GameMenu(this);

        game = new GameManager();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (state.equals("Start"))
            drawStartMenu(g2d);

        if (state.equals("Game"))
            drawGame(g2d);

        if (state.equals("End"))
            drawEndMenu(g2d);

        repaint();
    }

    private void drawStartMenu(Graphics2D g2d) {
        int width = getWidth();
        int height = getHeight();

        startMenu.draw(g2d, width, height);
        if (startMenu.isStart()) {
            state = "Game";
            game.reset();
        }
    }

    private void drawGame(Graphics2D g2d) {
        int width = getWidth();
        int height = getHeight();

        gameMenu.draw(g2d, width, height, game);
        if (game.isEnded()) {
            endMenu.reset();
            state = "End";
        }
    }

    private void drawEndMenu(Graphics2D g2d) {
        int width = getWidth();
        int height = getHeight();

        endMenu.draw(g2d, width, height, game.getScore(), game.getResult());
        if (endMenu.isRetry()) {
            game.reset();
            state = "Game";
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                game.moveLeftShuttle();
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                game.moveRightShuttle();

            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) {
                game.shuttleShot();
            }
        }
    }
}
