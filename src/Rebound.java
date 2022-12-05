import java.util.Random;

public class Rebound extends AnimatedObject{
    private Integer spanLife = 250;
    private Random r = new Random();
    private Integer nextX = r.nextInt(-3,4);
    private Integer nextY = r.nextInt(-3,4);
    private Coordinates nextPosition = new Coordinates(0,0);
    public Rebound(AnimationModel model) {
        super(model);
        this.setObjectType(ObjectType.SOLDIER);
        this.addToStatistics(this.getStatus());
        this.setPosition(new Coordinates());
    }

    public void move() {
        Random r = new Random();
        if(spanLife-- == 0) {
            setStatus(AnimatedObjectStatus.DEAD);
        } else {
            Coordinates actual = getPosition();
            if ((nextX>0 && actual.x > 1000) || (nextX<0 && actual.x < 0)) {
                nextX = -nextX;
            }
            if ((nextY>0 && actual.y > 750)|| (nextY<0 && actual.y < 0)) {
                nextY = -nextY;
            }

            nextPosition.x = actual.x+nextX;
            nextPosition.y = actual.y+nextY;
            setPosition(nextPosition);
        }
    }
}
