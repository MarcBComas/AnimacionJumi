public class Gravity extends AnimatedObject{
    private Integer g = 0;
    private Integer maxVelocidad = 50;
    private Coordinates nextPosition = new Coordinates(0,0);

    public Gravity(AnimationModel model) {
        super(model);
        this.setObjectType(ObjectType.DOG);
        this.addToStatistics(this.getStatus());
        this.setPosition(new Coordinates(this.getRandom().nextInt(400), 100));
    }

    public void move() {
        g++;
        if(g >= maxVelocidad) {
            g = maxVelocidad;
        }
        Coordinates actual = getPosition();
        if(actual.y >= 700) {
            setStatus(AnimatedObjectStatus.DEAD);
        }
        nextPosition.x = actual.x;
        nextPosition.y = actual.y + g;
        setPosition(nextPosition);
    }
}
