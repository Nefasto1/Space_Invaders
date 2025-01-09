package sdm.gui;

import sdm.space.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameManager implements ActionListener {
    private final Timer timer;
    protected Shuttle shuttle;
    protected AlienSpeedy alienSpeedy;
    protected ArrayList<Alien> alienList;
    protected ArrayList<Projectile> bulletList;
    protected ArrayList<Bomb> bombList;
    protected ArrayList<Barrier> barrierList;

    private int score;
    private int speedyKilled;
    private int lastShot;
    private int lives;

    public GameManager() {
        timer = new Timer(10, this);
        reset();
    }

    public void reset() {
        shuttle = new Shuttle(40, 400, 45, 45, "spaceship.png");
        alienList = new ArrayList<>();
        bulletList = new ArrayList<>();
        bombList = new ArrayList<>();
        barrierList = BarrierFactory.generate(3);
        alienList = AlienFactory.generate(2);
        alienSpeedy = null;

        score = 0;
        speedyKilled = 0;
        lives = 3;

        lastShot = (int) System.currentTimeMillis();

        timer.restart();
    }

    private void moveAliens() {
        alienList.stream().filter(Alien::isAlive).forEach(Alien::move);
        alienList.stream().filter(Alien::isAlive).forEach(alien -> alienShot(alien.getXPosition(), alien.getYPosition()));
    }

    private void alienShot(int x, int y) {
        int curr_time = (int) System.currentTimeMillis();
        double num_alien = (double) alienList.stream().filter(Alien::isAlive).count();
        double probability = 1 / (num_alien * 50);

        if (Math.random() < probability && curr_time - lastShot > 300) {
            bombList.add(new Bomb(x + 16, y + 16, 15, 15, "bomb.png"));
            lastShot = (int) System.currentTimeMillis();
        }
    }

    private void moveBullets() {
        bulletList.stream().filter(Projectile::isAlive).forEach(Projectile::move);
    }

    private void bulletAlienCollisionCheck() {
        bulletList.stream().filter(Projectile::isAlive).forEach(bullet ->
                alienList.stream().filter(Alien::isAlive).forEach(alien -> CollisionChecker.checkAndDestroy(bullet, alien)));
    }

    private void bulletSpeedyCollisionCheck() {
        if (alienSpeedy != null)
            bulletList.stream().filter(Projectile::isAlive).forEach(bullet -> CollisionChecker.checkAndDestroy(bullet, alienSpeedy));
    }

    private void bulletBarrierCollisionCheck() {
        bulletList.stream().filter(Projectile::isAlive).forEach(bullet ->
                barrierList.stream().filter(Barrier::isAlive).forEach(barrier -> CollisionChecker.checkAndDestroy(bullet, barrier)));
    }

    private void moveBombs() {
        bombList.stream().filter(Bomb::isAlive).forEach(Bomb::move);
    }

    private void bombBarrierCollisionCheck() {
        bombList.stream().filter(Bomb::isAlive).forEach(bomb ->
                barrierList.stream().filter(Barrier::isAlive).forEach(barrier -> CollisionChecker.checkAndDestroy(bomb, barrier)));
    }

    private void bombShuttleCollisionCheck() {
        bombList.stream().filter(Bomb::isAlive).forEach(bomb -> {
            if (CollisionChecker.check(bomb, shuttle)){
                lives--;
                bomb.die();
            }
            if (lives == 0)
                shuttle.die();
        });
    }

    private void updateScore() {
        score = (int) alienList.stream().filter(alien -> !alien.isAlive()).count() * 100;
        score += speedyKilled * 200;
        score += checkVictory() ? 1000 : 0;
        score -= checkLoss() ? 500 : 0;
    }

    private boolean checkVictory() {
        return alienList.stream().noneMatch(Alien::isAlive);
    }

    private boolean checkLoss() {
        return !shuttle.isAlive() || alienList.stream().anyMatch(alien -> alien.getYPosition() >= 350);
    }

    private void drawShuttle(Graphics2D g2d, JPanel panel) {
        shuttle.draw(g2d, panel);
    }

    private void drawAliens(Graphics2D g2d, JPanel panel) {
        alienList.stream().filter(Alien::isAlive).forEach(alien -> alien.draw(g2d, panel));
    }

    private void drawBullets(Graphics2D g2d, JPanel panel) {
        bulletList.stream().filter(Projectile::isAlive).forEach(bullet -> bullet.draw(g2d, panel));
    }

    private void drawBombs(Graphics2D g2d, JPanel panel) {
        bombList.stream().filter(Bomb::isAlive).forEach(bomb -> bomb.draw(g2d, panel));
    }

    private void drawSpeedy(Graphics2D g2d, JPanel panel) {
        if (alienSpeedy != null)
            alienSpeedy.draw(g2d, panel);
    }

    private void drawBarrier(Graphics2D g2d, JPanel panel) {
        barrierList.stream().filter(Barrier::isAlive).forEach(barrier -> barrier.draw(g2d, panel));
    }

    private void generateSpeedy() {
        if (Math.random() < 0.005 && alienSpeedy == null)
            alienSpeedy = new AlienSpeedy(30,30,"alienSpeedy.png");
    }

    private void killSpeedyIfDead(){
        if (alienSpeedy != null) {
            speedyKilled += !alienSpeedy.isAlive() && !alienSpeedy.isEscaped() ?1:0;
            alienSpeedy = alienSpeedy.isAlive() ? alienSpeedy : null;
        }
    }

    private void moveSpeedy(){
        if (alienSpeedy != null)
            alienSpeedy.move();
    }

    private void CollisionChecker() {
        bulletAlienCollisionCheck();
        bulletBarrierCollisionCheck();
        bombShuttleCollisionCheck();
        bulletSpeedyCollisionCheck();
        bombBarrierCollisionCheck();
        killSpeedyIfDead();
    }

    private void moveEntities() {
        shuttle.move();
        moveAliens();
        moveBullets();
        moveBombs();
        moveSpeedy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isEnded()){
            generateSpeedy();
            moveEntities();
            CollisionChecker();
            updateScore();
        }
    }

    public void draw(Graphics2D g2d, JPanel panel){
        drawShuttle(g2d, panel);
        drawAliens(g2d, panel);
        drawBullets(g2d, panel);
        drawBombs(g2d, panel);
        drawBarrier(g2d, panel);
        drawSpeedy(g2d, panel);
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

    public int getLives() {
        return lives;
    }

    public void moveLeftShuttle() {
        shuttle.moveLeft();
    }

    public void moveRightShuttle() {
        shuttle.moveRight();
    }

    public void shuttleStayStill(){
        shuttle.stayStill();
    }

    public void shuttleShot() {
        bulletList.add(new Projectile(shuttle.getXPosition() + 15, shuttle.getYPosition() + 10, 15, 15, "bullet.png"));
    }
}
