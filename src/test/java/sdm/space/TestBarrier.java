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
}
