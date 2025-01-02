package sdm.gui;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        initUI();
    }

    private void initUI() {
        add(new GameBoard());

        setSize(500, 500);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }
}
