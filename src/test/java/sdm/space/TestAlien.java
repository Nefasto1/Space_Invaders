package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlien {
    @Test
    public void moveRightFromTwoAndFive(){
        int x = 2;
        int y = 5;

        Alien alien = new Alien(x,y,45,45);
        alien.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(4, alien.getXPosition()),
                () -> assertEquals(5, alien.getYPosition())
        );
    }

    @Test
    public void moveRightFromEightAndTen(){
        int x = 8;
        int y = 10;

        Alien alien = new Alien(x,y,45,45);
        alien.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(10, alien.getXPosition()),
                () -> assertEquals(10, alien.getYPosition())
        );
    }

    @Test
    public void moveLeftFromTwoAndFive(){
        int x = 4;
        int y = 5;

        Alien alien = new Alien(x,y,45,45);
        alien.moveLeft();
        assertAll("Check all the coordinates",
                () -> assertEquals(2, alien.getXPosition()),
                () -> assertEquals(5, alien.getYPosition())
        );
    }

    @Test
    public void moveLeftFromEightAndTen(){
        int x = 8;
        int y = 10;

        Alien alien = new Alien(x,y,45,45);
        alien.moveLeft();
        assertAll("Check all the coordinates",
                () -> assertEquals(6, alien.getXPosition()),
                () -> assertEquals(10, alien.getYPosition())
        );
    }

    @Test
    public void moveDownFromTwoAndFive(){
        int x = 2;
        int y = 5;

        Alien alien = new Alien(x,y,45,45);
        alien.moveDown();
        assertAll("Check all the coordinates",
                () -> assertEquals(2, alien.getXPosition()),
                () -> assertEquals(20, alien.getYPosition())
        );
    }

    @Test
    public void moveDownFromFiveAndTen(){
        int x = 5;
        int y = 10;

        Alien alien = new Alien(x,y,45,45);
        alien.moveDown();
        assertAll("Check all the coordinates",
                () -> assertEquals(5, alien.getXPosition()),
                () -> assertEquals(25, alien.getYPosition())
        );
    }

    @Test
    public void moveRightBeforeBoundary() {
        int x = 442;
        int y = 10;

        Alien alien = new Alien(x, y,45,45);
        alien.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(444, alien.getXPosition()),
                () -> assertEquals(10, alien.getYPosition()),
                () -> assertTrue(alien.isMovingRight())
        );
    }

    @Test
    public void moveRightLimit() {
        int x = 445;
        int y = 10;

        Alien alien = new Alien(x, y,45,45);
        alien.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(445, alien.getXPosition()),
                () -> assertEquals(25, alien.getYPosition()),
                () -> assertFalse(alien.isMovingRight())
        );
    }

    @Test
    public void moveLeftBeforeBoundary() {
        int x = 4;
        int y = 10;

        Alien alien = new Alien(x, y,45,45);
        alien.setMovingRight(false);
        alien.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(2, alien.getXPosition()),
                () -> assertEquals(10, alien.getYPosition()),
                () -> assertFalse(alien.isMovingRight())
        );
    }

    @Test
    public void moveLeftLimit() {
        int x = 2;
        int y = 10;

        Alien alien = new Alien(x, y,45,45);
        alien.setMovingRight(false);
        alien.move();
        assertAll("Check all the coordinates",
                () -> assertEquals(0, alien.getXPosition()),
                () -> assertEquals(25, alien.getYPosition()),
                () -> assertTrue(alien.isMovingRight())
        );
    }

    @Test
    public void testSpeedIncreaseAfterMoveDown() {
        int x = 10;
        int y = 8;

        Alien alien = new Alien(x, y, 45, 45);
        int initialSpeed = alien.getX_speed();
        alien.moveDown();
        assertAll("Check speed after moving down",
                () -> assertEquals(initialSpeed, alien.getX_speed()),
                () -> assertEquals(23, alien.getYPosition())
        );
    }


    @Test
    public void checkIfAliveDefault(){
        Alien alien  = new Alien();
        assertTrue(alien.isAlive());
    }

    @Test
    public void checkIfAliveAfterDead(){
        Alien alien  = new Alien();
        alien.die();
        assertFalse(alien.isAlive());
    }


}
