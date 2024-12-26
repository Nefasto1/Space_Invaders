package sdm.space;

public class CollisionChecker {
    public static boolean check(Entity first, Entity second) {
        double distance_X = Math.pow(first.getXPosition() - second.getXPosition(), 2);
        double distance_Y = Math.pow(first.getYPosition() - second.getYPosition(), 2);
        double distance = Math.sqrt(distance_X + distance_Y);

        return distance <= 23;
    }
}
