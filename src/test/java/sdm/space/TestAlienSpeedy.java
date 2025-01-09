package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
