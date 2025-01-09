package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlienSpeedy {
    @Test
    public void moveRightFromTwoAndFive(){
        int x = 2;
        int y = 5;

        AlienSpeedy aliensp = new AlienSpeedy(x,y,45,45, "img");
        aliensp.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(6, aliensp.getXPosition()),
                () -> assertEquals(5, aliensp.getYPosition())
        );
    }

    @Test
    public void moveRightFromEightAndTen(){
        int x = 8;
        int y = 10;

        AlienSpeedy aliensp = new AlienSpeedy(x,y,45,45);
        aliensp.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(12, aliensp.getXPosition()),
                () -> assertEquals(10, aliensp.getYPosition())
        );
    }

    @Test
    public void moveLeftFromTwoAndFive(){
        int x = 4;
        int y = 5;

        AlienSpeedy aliensp = new AlienSpeedy(x,y,45,45);
        aliensp.moveLeft();
        assertAll("Check all the coordinates",
                () -> assertEquals(0, aliensp.getXPosition()),
                () -> assertEquals(5, aliensp.getYPosition())
        );
    }

    @Test
    public void moveLeftFromEightAndTen(){
        int x = 8;
        int y = 10;

        AlienSpeedy aliensp = new AlienSpeedy(x,y,45,45);
        aliensp.moveLeft();
        assertAll("Check all the coordinates",
                () -> assertEquals(4, aliensp.getXPosition()),
                () -> assertEquals(10, aliensp.getYPosition())
        );
    }



    @Test
    public void moveRightBeforeBoundary() {
        int x = 442;
        int y = 10;

        AlienSpeedy aliensp = new AlienSpeedy(x, y,45,45);
        aliensp.moveRight();
        assertTrue(aliensp.isEscaped());
    }

    @Test
    public void moveRightLimit() {
        int x = 445;
        int y = 10;

        AlienSpeedy aliensp = new AlienSpeedy(x, y,45,45);
        aliensp.moveRight();
        assertTrue(aliensp.isEscaped());
    }

    @Test
    public void moveLeftBeforeBoundary() {
        int x = 4;
        int y = 10;

        AlienSpeedy aliensp = new AlienSpeedy(x, y,45,45);
        aliensp.moveLeft();
        assertTrue(aliensp.isEscaped());
    }

    @Test
    public void moveLeftLimit() {
        int x = 2;
        int y = 10;

        AlienSpeedy aliensp = new AlienSpeedy(x, y,45,45);
        aliensp.moveLeft();
        assertTrue(aliensp.isEscaped());
    }

    @Test
    public void checkIfAliveDefault(){
        AlienSpeedy aliensp  = new AlienSpeedy();
        assertTrue(aliensp.isAlive());
    }

    @Test
    public void checkIfAliveAfterDead(){
        AlienSpeedy aliensp  = new AlienSpeedy();
        aliensp.die();
        assertFalse(aliensp.isAlive());
    }

}
