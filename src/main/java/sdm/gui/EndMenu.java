package sdm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EndMenu {
    private JButton retryButton;
    private JButton exitButton;
    private boolean retry = false;

    public EndMenu(JPanel panel) {
        retryButton = createButton("Retry", e -> {setVisible(false); retry = true;});
        exitButton = createButton("Exit", e -> System.exit(0));

        panel.add(retryButton);
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

    private void setVisible(boolean visible) {
        retryButton.setVisible(visible);
        exitButton.setVisible(visible);
    }

    public void reset() {
        retry = false;
        setVisible(true);
    }

    public boolean isRetry() {
        return retry;
    }

    public void draw(Graphics2D g2d, int width, int height, int score, String title) {
        drawBackground(g2d, width, height);
        drawRectangle(g2d, width, height);
        drawTitle(g2d, width, height, title);
        drawScore(g2d, width, height, score);
        drawButtons(width, height);
    }

    private void drawBackground(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, width, height);
    }

    private void drawRectangle(Graphics2D g2d, int width, int height) {
        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, height / 2 - 80, width - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, height / 2 - 80, width - 100, 50);
    }

    private void drawTitle(Graphics2D g2d, int width, int height, String title) {
        var small = new Font("Helvetica", Font.BOLD, 14);
        var smallText = g2d.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(title, (width - smallText.stringWidth(title))/2,height/2 - 50);
    }

    private void drawScore(Graphics2D g2d, int width, int height, int score) {
        var small = new Font("Helvetica", Font.BOLD, 14);
        var smallText = g2d.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString("Score: " + score, (width - smallText.stringWidth("Score: " + score))/2,height/2 - 100);
    }

    private void drawButtons(int width, int height) {
        int buttonWidth = (width - 80) / 2 - 30;
        retryButton.setBounds(buttonWidth + 91, height / 2, buttonWidth, 50);
        exitButton.setBounds(50, height / 2, buttonWidth, 50);
    }
}
