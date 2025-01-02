package sdm.space;

public class CollisionChecker {
    public static boolean check(Entity first, Entity second) {
        double distance_X = Math.pow(first.getXPosition() - second.getXPosition(), 2);
        double distance_Y = Math.pow(first.getYPosition() - second.getYPosition(), 2);
        double distance = Math.sqrt(distance_X + distance_Y);

        double collisionDistance = (double) (first.getWidth()/2 + second.getWidth()/2);

        boolean collided = distance <= collisionDistance;

        return collided;
    }

    public static boolean checkAndDestroy(Entity first, Entity second) {
        boolean collided = check(first, second);

        if (collided) {
            first.die();
            second.die();
        }

        return collided;
    }
}
