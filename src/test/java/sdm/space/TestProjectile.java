package sdm.space;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class TestProjectile {
    @Test
    public void moveUpFrom() {
        int x = 2;
        int y = 5;

        Projectile projectile = new Projectile(x, y);
        projectile.move();
        assertAll("Check of all the coordinates",
                () -> projectile.getXPosition(),
                () -> projectile.getYPosition()
        );

    }
}
