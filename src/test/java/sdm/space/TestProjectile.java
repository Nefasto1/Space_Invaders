package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProjectile {
    @Test
    public void moveFromTwoAndFive() {
        int x = 2;
        int y = 5;

        Projectile projectile = new Projectile(x, y);
        projectile.move();
        assertAll("Check of all the coordinates",
                () -> assertEquals(2, projectile.getXPosition()),
                () -> assertEquals(10, projectile.getYPosition())
        );
    }

    @Test
    public void moveFromFiveAndSeven() {
        int x = 5;
        int y = 7;

        Projectile projectile = new Projectile(x, y);
        projectile.move();
        assertAll("Check of all the coordinates",
                () -> assertEquals(5, projectile.getXPosition()),
                () -> assertEquals(12, projectile.getYPosition())
        );

    }
}
