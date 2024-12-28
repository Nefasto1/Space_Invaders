package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void bombShuttleNotCollidedOnYCheckBothAlive() {
        int shuttleX = 100;
        int shuttleY = 125;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);
        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both alive",
                () -> assertTrue(bomb.isAlive()),
                () -> assertTrue(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleCollidedOnYBothDead() {
        int shuttleX = 100;
        int shuttleY = 123;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both dead",
                () -> assertFalse(bomb.isAlive()),
                () -> assertFalse(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleNotCollidedOnXBothAlive() {
        int shuttleX = 125;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both Alive",
                () -> assertTrue(bomb.isAlive()),
                () -> assertTrue(shuttle.isAlive()));
    }

    @Test
    public void bombShuttleCollidedOnXBothDead() {
        int shuttleX = 123;
        int shuttleY = 100;

        int bombX = 100;
        int bombY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Bomb bomb = new Bomb(bombX, bombY);

        CollisionChecker.checkAndDestroy(bomb, shuttle);

        assertAll("Check they are both dead",
                () -> assertFalse(bomb.isAlive()),
                () -> assertFalse(shuttle.isAlive()));
    }

}