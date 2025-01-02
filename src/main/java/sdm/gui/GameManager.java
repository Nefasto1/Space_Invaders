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

    public GameManager() {
        reset();
    }

    public void reset() {
        shuttle = new Shuttle(40, 400, 45, 45, "spaceship.png");
        alienList = new ArrayList<>();
        bulletList = new ArrayList<>();
        bombList = new ArrayList<>();
        alienList = AlienFactory.generate(2);

        timer = new Timer(10, this);
        timer.start();
    }

    private void moveAliens() {
        alienList.stream().filter(Alien::isAlive).forEach(Alien::move);
    }

    private void moveBullets() {
        bulletList.stream().filter(Projectile::isAlive).forEach(Projectile::move);
        bulletList.stream().filter(Projectile::isAlive).forEach(bullet ->
                alienList.stream().filter(Alien::isAlive).forEach(alien -> CollisionChecker.checkAndDestroy(bullet, alien)));
    }

    private void moveBombs(){
        bombList.stream().filter(Bomb::isAlive).forEach(Bomb::move);
        bombList.stream().filter(Bomb::isAlive).forEach(bomb -> CollisionChecker.checkAndDestroy(bomb, shuttle));
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
        return !shuttle.isAlive();
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
