import java.util.Random;

public class Coordinates {
    public Integer x;
    public Integer y;

    public Coordinates() {
        Random r = new Random();
        this.x = r.nextInt(500);
        this.y = r.nextInt(500);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
