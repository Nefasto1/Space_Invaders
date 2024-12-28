package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCollisions {
    @Test
    public void bombShuttleNotCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 125;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertFalse(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 123;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertTrue(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleNotCollidedOnX() {
        int shuttleX = 125;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertFalse(CollisionChecker.check(bomb, shuttle));
    }

    @Test
    public void bombShuttleCollidedOnX() {
        int shuttleX = 123;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        assertTrue(CollisionChecker.check(bomb, shuttle));
    }
}
