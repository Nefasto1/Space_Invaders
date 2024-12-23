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
}
