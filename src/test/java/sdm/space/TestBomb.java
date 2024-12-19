package sdm.space;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.BomInput;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
