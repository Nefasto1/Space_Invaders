package sdm.space;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCollisions {
    @Test
    public void bombShuttleNotCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 130;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY, 45,45);
        Bomb bomb = new Bomb(bombX, bombY, 15,15);

        assertFalse(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 129;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY,45,45);
        Bomb bomb = new Bomb(bombX, bombY,15,15);

        assertTrue(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleNotCollidedOnX() {
        int shuttleX = 130;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY, 45,45);
        Bomb bomb = new Bomb(bombX, bombY, 15,15);

        assertFalse(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleCollidedOnX() {
        int shuttleX = 129;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY, 45,45);
        Bomb bomb = new Bomb(bombX, bombY,15,15);

        assertTrue(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleNotCollidedOnYCheckBothAlive() {
        int shuttleX = 100;
        int shuttleY = 130;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY, 45,45);
        Bomb bomb = new Bomb(bombX, bombY, 15,15);
        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both alive",
                () -> assertTrue(bomb.isAlive()),
                () -> assertTrue(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleCollidedOnYBothDead() {
        int shuttleX = 100;
        int shuttleY = 129;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY, 45,45);
        Bomb bomb = new Bomb(bombX, bombY, 15,15);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both dead",
                () -> assertFalse(bomb.isAlive()),
                () -> assertFalse(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleNotCollidedOnXBothAlive() {
        int shuttleX = 130;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY, 45,45);
        Bomb bomb = new Bomb(bombX, bombY, 15,15);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both Alive",
                () -> assertTrue(bomb.isAlive()),
                () -> assertTrue(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleCollidedOnXBothDead() {
        int shuttleX = 129;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY, 45,45);
        Bomb bomb = new Bomb(bombX, bombY, 15,15);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both dead",
                () -> assertFalse(bomb.isAlive()),
                () -> assertFalse(shuttle.isAlive()));
    }

    @Test
    public void projectileAlienNotCollidedOnY() {
        int alienX = 100;
        int alienY = 130;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);

        assertFalse(CollisionChecker.check(projectile, alien));
    }
    @Disabled
    @Test
    public void projectileAlienCollidedOnY() {
        int alienX = 100;
        int alienY = 129;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);

        assertTrue(CollisionChecker.check(projectile, alien));
    }
    @Disabled
    @Test
    public void projectileAlienNotCollidedOnX() {
        int alienX = 130;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);

        assertFalse(CollisionChecker.check(projectile, alien));
    }
    @Disabled
    @Test
    public void projectileAlienCollidedOnX() {
        int alienX = 129;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);

        assertTrue(CollisionChecker.check(projectile, alien));
    }
    @Disabled
    @Test
    public void projectileAlienNotCollidedOnYCheckBothAlive() {
        int alienX = 100;
        int alienY = 130;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);
        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both alive",
                () -> assertTrue(projectile.isAlive()),
                () -> assertTrue(alien.isAlive()));
    }
    @Disabled
    @Test
    public void projectileAlienCollidedOnYBothDead() {
        int alienX = 100;
        int alienY = 129;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);

        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both dead",
                () -> assertFalse(projectile.isAlive()),
                () -> assertFalse(alien.isAlive()));
    }
    @Disabled
    @Test
    public void projectileAlienNotCollidedOnXBothAlive() {
        int alienX = 130;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);

        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both Alive",
                () -> assertTrue(projectile.isAlive()),
                () -> assertTrue(alien.isAlive()));
    }
    @Disabled
    @Test
    public void projectileAlienCollidedOnXBothDead() {
        int alienX = 129;
        int alienY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Alien alien = new Alien(alienX, alienY);
        Projectile projectile = new Projectile(projectileX, projectileY, 15,15);

        CollisionChecker.checkAndDestroy(projectile, alien);

        assertAll("Check they are both dead",
                () -> assertFalse(projectile.isAlive()),
                () -> assertFalse(alien.isAlive()));
    }

}