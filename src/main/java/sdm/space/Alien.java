package sdm.space;

public class Alien extends Entity {

    public Alien(int x, int y) {
        super(x, y);
    }

    public Alien() {
        super();
    }

    public void moveRight() {
        x += 2;
    }

    public void moveLeft() {
        x -= 2;
    }

    public void moveDown() {
        y += 15;
    }

}