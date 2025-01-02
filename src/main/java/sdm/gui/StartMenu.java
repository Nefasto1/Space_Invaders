package sdm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartMenu {
    private JButton startButton;
    private JButton exitButton;
    private boolean start=false;

    public StartMenu(JPanel panel) {
        startButton = createButton("Start", e -> {setVisible(false); start = true;});
        exitButton = createButton("Exit", e -> System.exit(0));

        panel.add(startButton);
        panel.add(exitButton);
    }

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);

        button.setLayout(null);
        button.setBackground(new Color(0, 32, 48));
        button.setForeground(Color.white);
        button.addActionListener(action);

        return button;
    }

    public void reset() {
        start = false;
        setVisible(true);
    }

    private void setVisible(boolean visible) {
        startButton.setVisible(visible);
        exitButton.setVisible(visible);
    }

    public boolean isStart() {
        return start;
    }

    public void draw(Graphics2D g2d, int width, int height) {
        drawBackground(g2d, width, height);
        drawTitle(g2d, width, height);

        startButton.setBounds(50, height/2 - 75, width-100, 75);
        exitButton.setBounds(50, height/2 + 25, width-100, 75);
    }

    private void drawBackground(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, width, height);
    }

    private void drawTitle(Graphics2D g2d, int width, int height) {
        Font big = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics bigText = g2d.getFontMetrics(big);

        g2d.setColor(Color.white);
        g2d.setFont(big);
        g2d.drawString("Space Invaders", (width - bigText.stringWidth("Space Invaders")) / 2,height / 4);
    }
}
