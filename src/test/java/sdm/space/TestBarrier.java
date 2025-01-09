package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBarrier {

    @Test
    public void DieOnce() {
        Barrier barrier = new Barrier();

        barrier.die();

        assertAll("Check Barrier still alive and has 3 lives",
                () -> assertEquals(3, barrier.getLives()),
                () -> assertTrue(barrier.isAlive())
        );
    }

    @Test
    public void DieTwice() {
        Barrier barrier = new Barrier();

        barrier.die();
        barrier.die();

        assertAll("Check Barrier still alive and has 3 lives",
                () -> assertEquals(2, barrier.getLives()),
                () -> assertTrue(barrier.isAlive())
        );
    }

    @Test
    public void DieThreeTimes() {
        Barrier barrier = new Barrier();

        barrier.die();
        barrier.die();
        barrier.die();

        assertAll("Check Barrier still alive and has 3 lives",
                () -> assertEquals(1, barrier.getLives()),
                () -> assertTrue(barrier.isAlive())
        );
    }

    @Test
    public void DieFourTimes() {
        Barrier barrier = new Barrier();

        barrier.die();
        barrier.die();
        barrier.die();
        barrier.die();

        assertAll("Check Barrier still alive and has 3 lives",
                () -> assertEquals(0, barrier.getLives()),
                () -> assertFalse(barrier.isAlive())
        );
    }
}
