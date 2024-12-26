package sdm.space;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCollisions {
    @Test
    public void projectileShuttleNotCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 125;

        int projectileX = 100;
        int projectileY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertFalse(CollisionChecker.check(projectile, shuttle));
    }

    @Test
    public void projectileShuttleCollidedOnY() {
        int shuttleX = 100;
        int shuttleY = 123;

        int projectileX = 100;
        int projectileY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertTrue(CollisionChecker.check(projectile, shuttle));
    }

    @Test
    public void projectileShuttleNotCollidedOnX() {
        int shuttleX = 125;
        int shuttleY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertFalse(CollisionChecker.check(projectile, shuttle));
    }

    @Test
    public void projectileShuttleCollidedOnX() {
        int shuttleX = 123;
        int shuttleY = 100;

        int projectileX = 100;
        int projectileY = 100;

        Shuttle shuttle = new Shuttle(shuttleX, shuttleY);
        Projectile projectile = new Projectile(projectileX, projectileY);

        assertTrue(CollisionChecker.check(projectile, shuttle));
    }
}
