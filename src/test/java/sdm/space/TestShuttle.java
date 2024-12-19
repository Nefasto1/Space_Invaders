package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShuttle {
    @Test
    public void moveRightFromTwoAndTwo() {
        int x = 2;
        int y = 2;

        Shuttle shuttle = new Shuttle(x, y);
        shuttle.moveRight();
        assertAll("Check all the coordinates",
                () -> assertEquals(4, shuttle.getXPosition()),
                () -> assertEquals(2, shuttle.getYPosition())
        );
    }
}