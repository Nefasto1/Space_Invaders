package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShuttle {
    @Test
    public void moveRightFromTwoAndTwo() {
        int x = 2;
        int y = 2;

        Shuttle shuttle = new Shuttle(x, y, 45,45);
        shuttle.setStepToRight();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(5, shuttle.getXPosition()),
                () -> assertEquals(2, shuttle.getYPosition())
        );
    }

    @Test
    public void moveRightFromTwentyAndEight() {
        int x = 20;
        int y = 8;

        Shuttle shuttle = new Shuttle(x, y, 45,45);
        shuttle.setStepToRight();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(23, shuttle.getXPosition()),
                () -> assertEquals(8, shuttle.getYPosition())
        );
    }

    @Test
    public void moveLeftFromTwoAndTwo() {
        int x = 2;
        int y = 2;

        Shuttle shuttle = new Shuttle(x, y, 45,45);
        shuttle.setStepToLeft();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(0, shuttle.getXPosition()),
                () -> assertEquals(2, shuttle.getYPosition())
        );
    }

    @Test
    public void moveLeftFromTwentyAndEight() {
        int x = 20;
        int y = 8;

        Shuttle shuttle = new Shuttle(x, y,45,45);
        shuttle.setStepToLeft();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(17, shuttle.getXPosition()),
                () -> assertEquals(8, shuttle.getYPosition())
        );
    }

    @Test
    public void moveRightLimit(){
        // here I will assume that the screen is 500x500
        int x = 443;
        int y = 2;
        Shuttle shuttle = new Shuttle(x,y, 45,45);
        shuttle.setStepToRight();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(445, shuttle.getXPosition()),
                () -> assertEquals(2, shuttle.getYPosition())
        );
    }

    @Test
    public void moveRightLimitMinusOne(){
        // here I will assume that the screen is 500x500
        int x = 444;
        int y = 4;
        Shuttle shuttle = new Shuttle(x,y,45,45);
        shuttle.setStepToRight();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(445, shuttle.getXPosition()),
                () -> assertEquals(4, shuttle.getYPosition())
        );
    }

    @Test
    public void moveLeftLimit(){
        // here I will assume that the screen is 500x500
        int x = 0;
        int y = 2;
        Shuttle shuttle = new Shuttle(x,y, 45,45);
        shuttle.setStepToLeft();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(0, shuttle.getXPosition()),
                () -> assertEquals(2, shuttle.getYPosition())
        );
    }

    @Test
    public void moveLeftLimitPlusOne(){
        // here I will assume that the screen is 500x500
        int x = 1;
        int y = 4;
        Shuttle shuttle = new Shuttle(x,y, 45,45);
        shuttle.setStepToLeft();
        shuttle.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(0, shuttle.getXPosition()),
                () -> assertEquals(4, shuttle.getYPosition())
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