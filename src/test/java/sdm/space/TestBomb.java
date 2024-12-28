package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBomb {
    @Test
    public void moveFromTwoAndFive() {
        int x = 2;
        int y = 5;

        Bomb bomb = new Bomb(x, y);
        bomb.move();
        assertAll("Check of all the coordinates",
                () -> assertEquals(2, bomb.getXPosition()),
                () -> assertEquals(0, bomb.getYPosition())
        );
    }

    @Test
    public void moveFromFiveAndSeven() {
        int x = 5;
        int y = 7;

        Bomb bomb = new Bomb(x, y);
        bomb.move();
        assertAll("Check of all the coordinates",
                () -> assertEquals(5, bomb.getXPosition()),
                () -> assertEquals(2, bomb.getYPosition())
        );
    }

    @Test
    public void checkIsAliveDefault() {
        Bomb bomb = new Bomb();
        assertTrue(bomb.isAlive());
    }

    @Test
    public void checkIsAliveAfterCollision() {
        Bomb bomb = new Bomb();
        bomb.die();
        assertFalse(bomb.isAlive());
    }

    @Test
    public void checkIsAliveAfterInsideBoundaries() {
        int x = 5;
        int y = 400;

        Bomb bomb = new Bomb(x, y);
        bomb.move();
        assertTrue(bomb.isAlive());
    }

    @Test
    public void checkIsAliveAfterOutOfBounds() {
        int x = 5;
        int y = 0;

        Bomb bomb = new Bomb(x, y);
        bomb.move();
        assertFalse(bomb.isAlive());
    }

    @Test
    public void checkIsAliveAfterOutOfBoundsShifted() {
        int x = 5;
        int y = 4;

        Bomb bomb = new Bomb(x, y);
        bomb.move();
        assertFalse(bomb.isAlive());
    }
}