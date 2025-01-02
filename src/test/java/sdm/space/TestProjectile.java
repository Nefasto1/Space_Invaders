package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestProjectile {
    @Test
    public void moveFromTwoAndFive() {
        int x = 2;
        int y = 5;

        Projectile projectile = new Projectile(x, y, 15, 15);
        projectile.move();
        assertAll("Check of all the coordinates",
                () -> assertEquals(2, projectile.getXPosition()),
                () -> assertEquals(0, projectile.getYPosition())
        );
    }

    @Test
    public void moveFromFiveAndSeven() {
        int x = 5;
        int y = 7;

        Projectile projectile = new Projectile(x, y, 15, 15);
        projectile.move();
        assertAll("Check of all the coordinates",
                () -> assertEquals(5, projectile.getXPosition()),
                () -> assertEquals(2, projectile.getYPosition())
        );
    }

    @Test
    public void checkIsAliveDefault() {
        Projectile projectile = new Projectile();
        assertTrue(projectile.isAlive());
    }

    @Test
    public void checkIsAliveAfterCollision() {
        Projectile projectile = new Projectile();
        projectile.die();
        assertFalse(projectile.isAlive());
    }

    @Test
    public void checkIsAliveAfterInsideBoundaries() {
        int x = 5;
        int y = 400;

        Projectile projectile = new Projectile(x, y, 15, 15);
        projectile.move();
        assertTrue(projectile.isAlive());
    }

    @Test
    public void checkIsAliveAfterOutOfBounds() {
        int x = 5;
        int y = 0;

        Projectile projectile = new Projectile(x, y, 15, 15);
        projectile.move();
        assertFalse(projectile.isAlive());
    }

    @Test
    public void checkIsAliveAfterOutOfBoundsShifted() {
        int x = 5;
        int y = 4;

        Projectile projectile = new Projectile(x, y, 15, 15);
        projectile.move();
        assertFalse(projectile.isAlive());
    }
}
