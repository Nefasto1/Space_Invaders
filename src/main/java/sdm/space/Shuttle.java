package sdm.space;

public class Shuttle extends Entity{

    public Shuttle(int x, int y) {
        super(x, y);
    }

    public Shuttle() {
        super();
    }

    public void moveRight() {
        x += 2;
        if (x>500){
            x = 500;
        }
    }

    public void moveLeft() {
        x -= 2;
        if (x<0){
            x = 0;
        }
    }
}