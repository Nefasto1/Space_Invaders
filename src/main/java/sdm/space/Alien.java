package sdm.space;

public class Alien extends Entity {

    public Alien(int x, int y) {
        super(x, y);
    }

    public Alien() {
        super();
    }

    public void moveRight() {
        if (x == 499){
            x = 500;
        } else if (x == 500) {
            moveDown();
            moveLeft();
        }
        else {
            x += 2;
        }
    }

    public void moveLeft() {
        if (x == 1){
            x = 0;
        } else if (x == 0) {
            moveDown();
            moveRight();
        }
        else {
            x -= 2;
        }
    }

    public void moveDown() {
        y += 15;
    }

}