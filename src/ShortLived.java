public class ShortLived extends AnimatedObject{
    private Integer spanLife = 100;
    public ShortLived(AnimationModel model) {
        super(model);
        this.setObjectType(ObjectType.ZOMBIE);
        this.addToStatistics(this.getStatus());
        this.setPosition(new Coordinates());
    }

    public void move() {
        if(spanLife-- == 0) {
            setStatus(AnimatedObjectStatus.DEAD);
        }
    }
}
