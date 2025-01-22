package sdm.gui;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        initUI();
    }

    private void initUI() {
        int windowWidth = 600;
        int windowHeight = 600;
        add(new GameBoard(windowWidth, windowHeight));

        setSize(windowWidth, windowHeight);
        setResizable(false);

        setTitle("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon myIcon = new ImageIcon("resources/alien.png");
        setIconImage(myIcon.getImage());
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}
