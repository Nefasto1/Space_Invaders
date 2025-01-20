package sdm.space;

public class CollisionChecker {
    public static boolean check(Entity first, Entity second) {
        double distance_X = Math.pow(first.getXPosition() - second.getXPosition(), 2);
        double distance_Y = Math.pow(first.getYPosition() - second.getYPosition(), 2);
        double distance = Math.sqrt(distance_X + distance_Y);

        double first_width = first.getWidth();
        double second_width = second.getWidth();
        double collisionDistance = (first_width + second_width) / 2;

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
