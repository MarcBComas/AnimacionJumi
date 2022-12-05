import java.util.Random;

public class Anarchic extends AnimatedObject{
    private Coordinates nextPosition = new Coordinates(0,0);
    private Coordinates ending = new Coordinates(0,0);
    private Integer spanLife = 250;

    public Anarchic(AnimationModel model) {
        super(model);
        this.setObjectType(ObjectType.ALIEN);
        this.addToStatistics(this.getStatus());
        this.setPosition(new Coordinates());
    }

    public void move() {
        if(spanLife-- == 0) {
            setStatus(AnimatedObjectStatus.DEAD);
        } else {
            Coordinates actual = getPosition();
            nextPosition.x = actual.x > ending.x? actual.x-1 : actual.x < ending.x? actual.x+1 : actual.x;
            nextPosition.y = actual.y > ending.y? actual.y-1 : actual.y < ending.y? actual.y+1 : actual.y;
            setPosition(nextPosition);
            if(actual.x == ending.x && actual.y == ending.y) {
                newEnding();
            }
        }
    }

    public void newEnding() {
        Random r = new Random();
        ending.x = r.nextInt(700);
        ending.y = r.nextInt(800);
    }
}
