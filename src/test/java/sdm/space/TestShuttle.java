package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShuttle {
    @Test
    public void moveRightFromTwoAndTwo() {
        int x = 2;
        int y = 2;

        Shuttle shuttle = new Shuttle(x, y);
        shuttle.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(4, shuttle.getXPosition()),
                () -> assertEquals(2, shuttle.getYPosition())
        );
    }

    @Test
    public void moveRightFromTwentyAndEight() {
        int x = 20;
        int y = 8;

        Shuttle shuttle = new Shuttle(x, y);
        shuttle.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(22, shuttle.getXPosition()),
                () -> assertEquals(8, shuttle.getYPosition())
        );
    }

    @Test
    public void moveLeftFromTwoAndTwo() {
        int x = 2;
        int y = 2;

        Shuttle shuttle = new Shuttle(x, y);
        shuttle.moveLeft();

        assertAll("Check all the coordinates",
                () -> assertEquals(0, shuttle.getXPosition()),
                () -> assertEquals(2, shuttle.getYPosition())
        );
    }

    @Test
    public void moveLeftFromTwentyAndEight() {
        int x = 20;
        int y = 8;

        Shuttle shuttle = new Shuttle(x, y);
        shuttle.moveLeft();

        assertAll("Check all the coordinates",
                () -> assertEquals(18, shuttle.getXPosition()),
                () -> assertEquals(8, shuttle.getYPosition())
        );
    }

    @Test
    public void checkIfAliveDefault() {
        Shuttle shuttle = new Shuttle();
        assertTrue(shuttle.isAlive());
    }

    @Test
    public void checkIfAliveAfterDead() {
        Shuttle shuttle = new Shuttle();
        shuttle.die();

        assertFalse(shuttle.isAlive());
    }

}