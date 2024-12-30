package sdm.space;

public class Bomb extends Entity {
    public Bomb() {
        super();
    }

    public Bomb(int x, int y) {
        super(x, y);
    }

    public void move() {
        y += 5;
        if (y > 500) {
            super.die();
        }
    }
}