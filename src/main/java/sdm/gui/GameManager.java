package sdm.gui;

import sdm.space.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameManager implements ActionListener {
    private final Timer timer;
    private int windowWidth;
    private int windowHeight;

    private Shuttle shuttle;
    private AlienSpeedy alienSpeedy;
    private ArrayList<Alien> alienList;
    private ArrayList<Projectile> bulletList;
    private ArrayList<Bomb> bombList;
    private ArrayList<Barrier> barrierList;

    private int score;
    private int speedyKilled;
    private int lastShotTime;
    private int lives;


    public GameManager(int windowWidth, int windowHeight) {
        timer = new Timer(10, this);
        reset(3, 1, "red", windowWidth, windowHeight);
    }

    public void reset(int NumBarriers, int NumRows, String shipColor, int windowWidth, int windowHeight) {
        lastShotTime = (int) System.currentTimeMillis();

        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        shuttle = new Shuttle(40, windowHeight-100, 45, 45, windowWidth, windowHeight,"spaceship_" + shipColor + ".png");
        alienList = new ArrayList<>();
        bulletList = new ArrayList<>();
        bombList = new ArrayList<>();
        barrierList = BarrierFactory.generate(NumBarriers, windowWidth, windowHeight);
        alienList = AlienFactory.generate(NumRows, windowWidth, windowHeight);
        alienSpeedy = null;

        score = 0;
        speedyKilled = 0;
        lives = 3;

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

        if (Math.random() < probability && curr_time - lastShotTime > 300) {
            bombList.add(new Bomb(x + 16, y + 16, 15, 15, windowWidth, windowHeight, "bomb.png"));
            lastShotTime = (int) System.currentTimeMillis();
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
                Player.setDeadAudio();
                bomb.die();
            }
            if (lives == 0)
                shuttle.die();
        });
    }

    private void updateScore() {
        score = (int) alienList.stream().filter(alien -> !alien.isAlive()).count() * 100;
        score += speedyKilled * 500;
        score += checkVictory() ? 1000 * lives : 0;
        score -= checkLoss() ? 500 : 0;
    }

    private boolean checkVictory() {
        return alienList.stream().noneMatch(Alien::isAlive);
    }

    private boolean checkLoss() {
        return !shuttle.isAlive() || alienList.stream().anyMatch(alien -> alien.getYPosition() >= windowHeight-windowHeight/4 -30);
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
        if (Math.random() < 0.001 && alienSpeedy == null)
            alienSpeedy = new AlienSpeedy(30,30, windowWidth, windowHeight,"alienSpeedy.png");
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

    private void collisionChecker() {
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
            collisionChecker();
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
        shuttle.setStepToLeft();
    }

    public void moveRightShuttle() {
        shuttle.setStepToRight();
    }

    public void shuttleStayStill(){
        shuttle.stayStill();
    }

    public void shuttleShot() {
        bulletList.add(new Projectile(shuttle.getXPosition() + 15, shuttle.getYPosition() + 10, 15, 15, windowWidth, windowHeight,"bullet.png"));
    }
}
