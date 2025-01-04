package sdm.gui;

import sdm.space.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameManager implements ActionListener {
    private Timer timer;
    private Shuttle shuttle;
    private ArrayList<Alien> alienList;
    private ArrayList<Projectile> bulletList;
    private ArrayList<Bomb> bombList;
    private int score = 0;
    private int lastshot;
    private int lives = 3;

    public GameManager() {
        timer = new Timer(10, this);
        reset();
    }

    public void reset() {
        shuttle = new Shuttle(40, 400, 45, 45, "spaceship.png");
        alienList = new ArrayList<>();
        bulletList = new ArrayList<>();
        bombList = new ArrayList<>();
        alienList = AlienFactory.generate(2);
        lives = 3;
        timer.restart();
    }


    private void moveAliens() {
        alienList.stream().filter(Alien::isAlive).forEach(Alien::move);
        alienList.stream().filter(Alien::isAlive).forEach(alien -> alienShot(alien.getXPosition(), alien.getYPosition()));
    }

    private void alienShot(int x, int y){
        int curr_time = (int) System.currentTimeMillis();
        double num_alien = (double) alienList.stream().filter(Alien::isAlive).count();
        double probability = 1/(num_alien*50);
        if (Math.random() < probability && curr_time - lastshot > 300) {
            bombList.add(new Bomb(x + 16, y + 16, 15, 15, "bomb.png"));
            lastshot = (int) System.currentTimeMillis();
        }
    }

    private void moveBullets() {
        bulletList.stream().filter(Projectile::isAlive).forEach(Projectile::move);
        bulletList.stream().filter(Projectile::isAlive).forEach(bullet ->
                alienList.stream().filter(Alien::isAlive).forEach(alien -> CollisionChecker.checkAndDestroy(bullet, alien)));
    }

    private void moveBombs() {
        bombList.stream().filter(Bomb::isAlive).forEach(Bomb::move);
        bombList.stream().filter(Bomb::isAlive).forEach(bomb -> {
            if (CollisionChecker.checkAndDestroy(bomb, shuttle)) {
                lives--;
                if (lives <= 0) {
                    shuttle.die();
                }
            }
        });
    }


    private void updateScore() {
        score = (int) alienList.stream().filter(alien -> !alien.isAlive()).count() * 100;
        score += checkVictory() ?  1000 : 0;
        score -= checkLoss() ?  500 : 0;
    }

    private boolean checkVictory() {
        return alienList.stream().noneMatch(Alien::isAlive);
    }

    private boolean checkLoss() {
        return lives <= 0 || alienList.stream().anyMatch(alien -> alien.getYPosition() >= 350);
    }

    public Shuttle getShuttle() {
        return shuttle;
    }

    public ArrayList<Alien> getAliens() {
        return alienList;
    }

    public ArrayList<Projectile> getBullets() {
        return bulletList;
    }

    public ArrayList<Bomb> getBombs() {
        return bombList;
    }

    public int getScore() {
        return score;
    }

    public boolean isEnded() {
        return checkVictory() || checkLoss();
    }

    public String getResult() {
        return checkVictory() ? "Victory" : "Game Over";
    }

    public int getLives() { return lives; }

    public void moveLeftShuttle() {
        shuttle.moveLeft();
    }

    public void moveRightShuttle() {
        shuttle.moveRight();
    }

    public void shuttleShot() {
        bulletList.add(new Projectile(shuttle.getXPosition() + 15, shuttle.getYPosition() + 10, 15, 15, "bullet.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveAliens();
        moveBullets();
        moveBombs();
        updateScore();
    }
}
