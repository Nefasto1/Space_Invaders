package sdm.gui;

import javax.swing.*;
import java.awt.*;

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
        setFocusable(true);

        int width = 500;
        int height = 500;

        setSize(width, height);
        this.setLayout(null);
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
            // To draw Start
            System.out.println("Start");

        if (state.equals("Game"))
            // To draw Game
            System.out.println("Game");

        if (state.equals("End"))
            // To draw End
            System.out.println("End");

        repaint();
    }
}