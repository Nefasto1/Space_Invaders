package sdm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class GameBoard extends JPanel {
    private StartMenu startMenu;
    private GameMenu gameMenu;
    private EndMenu endMenu;

    private GameManager game;

    private long lastShot;
    private String state = "Start";

    public GameBoard(int windowWidth, int windowHeight) {
        initializeBoard(windowWidth, windowHeight);
    }

    private void initializeBoard(int windowWidth, int windowHeight) {
        addKeyListener(new TAdapter());
        setFocusable(true);

        setSize(windowWidth, windowHeight);
        this.setLayout(null);

        startMenu = new StartMenu(this);
        endMenu = new EndMenu(this);
        gameMenu = new GameMenu(this);

        game = new GameManager(windowWidth, windowHeight);

        Player.setMenuAudio();
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
        int width = startMenu.getWindowSize();
        int height = startMenu.getWindowSize();

        startMenu.draw(g2d, width, height);
        setSize(width, height);
        SwingUtilities.getWindowAncestor(this).setSize(width, height);
        if (startMenu.isStart()) {
            state = "Game";
            Player.setBackgroundAudio();
            game.reset(startMenu.getNumBarriers(), startMenu.getNumRows(), startMenu.getColor(), width, height);
        }
    }

    private void drawGame(Graphics2D g2d) {
        int width = startMenu.getWindowSize();
        int height = startMenu.getWindowSize();

        gameMenu.draw(g2d, width, height, game);
        if (game.isEnded()) {
            endMenu.reset();
            state = "End";
            if (Objects.equals(game.getResult(), "Game Over")){
                Player.setGameOverAudio();}
            else {
                Player.setVictoryAudio();
            }
        }
    }

    private void drawEndMenu(Graphics2D g2d) {
        int width = startMenu.getWindowSize();
        int height = startMenu.getWindowSize();

        endMenu.draw(g2d, width, height, game.getScore(), game.getResult());

        if (endMenu.isRetry()) {
            game.reset(startMenu.getNumBarriers(), startMenu.getNumRows(), startMenu.getColor(), width, height);
            state = "Game";
            Player.setBackgroundAudio();
        }

        if (endMenu.isGoToSettings()){
            startMenu.reset();
            state = "Start";
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (state.equals("Game")) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    game.moveLeftShuttle();
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    game.moveRightShuttle();

                long current_time = System.currentTimeMillis();
                if (e.getKeyCode() == KeyEvent.VK_UP && current_time - lastShot > 500) {
                    game.shuttleShot();

                    Player.setProjectileAudio();
                    lastShot = System.currentTimeMillis();
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if (state.equals("Game")){
                if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
                    game.shuttleStayStill();
            }
        }
    }

}
