package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlien {
    @Test
    public void moveRightFromTwoAndFive(){
        int x = 2;
        int y = 5;

        Alien alien = new Alien(x,y);
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

        Alien alien = new Alien(x,y);
        alien.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(10, alien.getXPosition()),
                () -> assertEquals(10, alien.getYPosition())
        );
    }

    @Test
    public void moveLeftFromTwoAndFive(){
        int x = 2;
        int y = 5;

        Alien alien = new Alien(x,y);
        alien.moveLeft();
        assertAll("Check all the coordinates",
                () -> assertEquals(0, alien.getXPosition()),
                () -> assertEquals(5, alien.getYPosition())
        );
    }

    @Test
    public void moveLeftFromEightAndTen(){
        int x = 8;
        int y = 10;

        Alien alien = new Alien(x,y);
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

        Alien alien = new Alien(x,y);
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

        Alien alien = new Alien(x,y);
        alien.moveDown();
        assertAll("Check all the coordinates",
                () -> assertEquals(5, alien.getXPosition()),
                () -> assertEquals(25, alien.getYPosition())
        );
    }


}
