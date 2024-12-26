package sdm.space;

public class Projectile extends Entity {
    public Projectile(int x, int y) {
        super(x, y);
    }

    public Projectile() {
        super();
    }

    public void move() {
        y += 5;
        if (y > 500) {
            y = 500;
        }
    }
}
