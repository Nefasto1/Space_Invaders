package sdm.space;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
public class TestCollisions {
    @Test
    public void bombShuttleNotCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 125;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertFalse(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 123;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertTrue(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleNotCollidedOnX() {
        int shuttleX = 125;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertFalse(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleCollidedOnX() {
        int shuttleX = 123;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertTrue(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleNotCollidedOnYCheckBothAlive() {
        int shuttleX = 100;
        int shuttleY = 125;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);
        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both alive",
                () -> assertTrue(bomb.isAlive()),
                () -> assertTrue(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleCollidedOnYBothDead() {
        int shuttleX = 100;
        int shuttleY = 123;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both dead",
                () -> assertFalse(bomb.isAlive()),
                () -> assertFalse(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleNotCollidedOnXBothAlive() {
        int shuttleX = 125;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both Alive",
                () -> assertTrue(bomb.isAlive()),
                () -> assertTrue(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleCollidedOnXBothDead() {
        int shuttleX = 123;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both dead",
                () -> assertFalse(bomb.isAlive()),
                () -> assertFalse(shuttle.isAlive()));
    }

    @Test
    public void projectileAlienNotCollidedOnY() {
        int alienX = 100;
        int alienY = 125;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertFalse(CollisionChecker.check(projectile, alien));
    }

    @Test
    public void projectileAlienCollidedOnY() {
        int alienX = 100;
        int alienY = 123;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertTrue(CollisionChecker.check(projectile, alien));
    }

    @Test
    public void projectileAlienNotCollidedOnX() {
        int alienX = 125;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertFalse(CollisionChecker.check(projectile, alien));
    }

    @Test
    public void projectileAlienCollidedOnX() {
        int alienX = 123;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertTrue(CollisionChecker.check(projectile, alien));
    }

    @Test
    public void projectileAlienNotCollidedOnYCheckBothAlive() {
        int alienX = 100;
        int alienY = 125;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);
        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both alive",
                () -> assertTrue(projectile.isAlive()),
                () -> assertTrue(alien.isAlive()));
    }

    @Test
    public void projectileAlienCollidedOnYBothDead() {
        int alienX = 100;
        int alienY = 123;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both dead",
                () -> assertFalse(projectile.isAlive()),
                () -> assertFalse(alien.isAlive()));
    }

    @Test
    public void projectileAlienNotCollidedOnXBothAlive() {
        int alienX = 125;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both Alive",
                () -> assertTrue(projectile.isAlive()),
                () -> assertTrue(alien.isAlive()));
    }

    @Test
    public void projectileAlienCollidedOnXBothDead() {
        int alienX = 123;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both dead",
                () -> assertFalse(projectile.isAlive()),
                () -> assertFalse(alien.isAlive()));
    }

}