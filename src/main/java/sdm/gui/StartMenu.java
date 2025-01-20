package sdm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StartMenu {
    private final JButton startButton;
    private final JButton exitButton;
    private boolean start=false;

    private final JRadioButton[] barrierButtons;
    private final JRadioButton[] rowButtons;
    private JRadioButton[] speedButtons;

    private int selectedBarriers = 0;
    private int selectedRows = 1;

    private final String[] spaceshipColors = {"red", "blue", "green"};
    private final Image[] images;
    private final JRadioButton[] colorButtons;
    private String selectedColor = "red";
    private final JPanel panel;

    public StartMenu(JPanel panel) {
        images = new Image[3];
        for (int i = 0; i < spaceshipColors.length; i++) {
            ImageIcon image = new ImageIcon("resources/spaceship_" + spaceshipColors[i] + ".png");
            images[i] = image.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        }
        this.panel = panel;

        startButton = createButton("Play", e -> {setVisible(false); start = true;});
        exitButton = createButton("Exit", e -> System.exit(0));
        barrierButtons = CreateRadioButtons(panel, IntStream.range(0, 6).toArray(), e -> selectedBarriers = Integer.parseInt(((JRadioButton) e.getSource()).getText()));
        colorButtons = CreateRadioButtons(panel, IntStream.range(0, 3).toArray(), e -> selectedColor = spaceshipColors[Integer.parseInt(((JRadioButton) e.getSource()).getText())]);
        rowButtons = CreateRadioButtons(panel, IntStream.range(1, 6).toArray(), e -> selectedRows = Integer.parseInt(((JRadioButton) e.getSource()).getText()));

        panel.add(startButton);
        panel.add(exitButton);
    }

    private JRadioButton[] CreateRadioButtons(JPanel panel, int[] values, ActionListener action) {
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] buttons = new JRadioButton[values.length];

        for (int i = 0; i < values.length; i++) {
            buttons[i] = new JRadioButton(Integer.toString(values[i]));
            buttons[i].addActionListener(action);
            buttons[i].setBackground(new Color(0, 32, 48));
            buttons[i].setForeground(Color.white);
            group.add(buttons[i]);
            panel.add(buttons[i]);
        }
        buttons[0].setSelected(true);

        return buttons;
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
        Arrays.stream(barrierButtons).forEach(button -> button.setVisible(visible));
        Arrays.stream(rowButtons).forEach(button -> button.setVisible(visible));
        Arrays.stream(colorButtons).forEach(button -> button.setVisible(visible));
    }

    public boolean isStart() {
        return start;
    }

    public void draw(Graphics2D g2d, int width, int height) {
        drawBackground(g2d, width, height);
        drawTitle(g2d, width, height);

        drawColorShip(g2d, colorButtons, width/8, height/6 + 175);
        drawRadioButtons(g2d, "Number of Barriers:", barrierButtons, width/8, height/6 + 250);
        drawRadioButtons(g2d, "Number of Rows:", rowButtons, width/8, height/6 + 325);

        startButton.setBounds(30, height/6 + 20, (width-100)/2, 75);
        exitButton.setBounds(70 + (width-100)/2, height/6 + 20, (width-100)/2, 75);
    }

    private void drawColorShip(Graphics2D g2d, JRadioButton[] buttons, int x, int y) {
        Font font = new Font("Helvetica", Font.PLAIN, 20);
        g2d.setFont(font);
        g2d.setColor(Color.white);

        g2d.drawString("Number of Colors:", x, y - 10);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(x + 150 + (i * 100), y, 20, 20);
            g2d.drawImage(images[i], x + 120 + (i * 100), y - 5, panel);
        }
    }

    private void drawRadioButtons(Graphics2D g2d, String labelText, JRadioButton[] buttons, int x, int y) {
        Font font = new Font("Helvetica", Font.PLAIN, 20);
        g2d.setFont(font);
        g2d.setColor(Color.white);

        g2d.drawString(labelText, x, y - 10);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(x + 150 + (i * 50), y, 20, 20);
            g2d.drawString(buttons[i].getText(), x + 136 + (i * 50), y + 18);
        }
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
        g2d.drawString("Space Invaders", (width - bigText.stringWidth("Space Invaders")) / 2,height / 8);
    }

    public int getNumBarriers() {
        return selectedBarriers;
    }

    public int getNumRows() {
        return selectedRows;
    }

    public String getColor() {
        return selectedColor;
    }
}
