package sdm.space;

public class CollisionChecker {
    public static boolean check(Entity first, Entity second) {
        double distanceX = Math.pow(first.getXPosition() - second.getXPosition(), 2);
        double distanceY = Math.pow(first.getYPosition() - second.getYPosition(), 2);
        double distance = Math.sqrt(distanceX + distanceY);

        double firstWidth = first.getWidth();
        double secondWidth = second.getWidth();
        double collisionDistance = (firstWidth + secondWidth) / 2;

        return distance < collisionDistance;
    }

    public static void checkAndDestroy(Entity first, Entity second) {
        boolean collided = check(first, second);

        if (collided) {
            first.die();
            second.die();
        }

    }
}
