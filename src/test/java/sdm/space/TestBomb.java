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
    public void moveLimited() {
        int x = 5;
        int y = 0;

        Bomb bomb = new Bomb(x, y);
        bomb.move();
        assertAll("Check of all the coordinates",
                () -> assertEquals(5, bomb.getXPosition()),
                () -> assertEquals(0, bomb.getYPosition())
        );
    }

    @Test
    public void checkHasCollidedDefault() {
        Bomb bomb = new Bomb();
        assertFalse(bomb.hasCollided());
    }

    @Test
    public void checkHasCollidedAfterCollision() {
        Bomb bomb = new Bomb();
        bomb.collide();
        assertTrue(bomb.hasCollided());
    }
}
