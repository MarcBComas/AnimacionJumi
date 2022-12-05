import java.awt.*;
import java.util.Random;

public abstract class AnimatedObject implements Runnable, VisualObject{
    static private Image[] objectImages = new Image[4];
    static private Integer[][] statistics = new Integer[4][4];
    private ObjectType objectType;
    private AnimatedObjectStatus status;
    private Coordinates position;
    private AnimationModel model;
    private Random r;
    private Integer tiempoVida;


    public AnimatedObject(AnimationModel model) {
        this.r = new Random();
        this.model = model;
        /*this.position = new Coordinates();*/
        this.status = AnimatedObjectStatus.RUNNING;
    }

    static public void createStatistics() {
      for(int i = 0; i < 4 ; i++) {
          statistics[i][0] = i;
          for(int j = 0; j < 4; j++) {
              statistics[i][j] = 0;
          }
      }
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public Random getRandom() {return this.r;}
    static public void loadObjectImages() {
        Toolkit t = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 4; i++) {
            objectImages[i] = t.getImage(ObjectType.values()[i]+".png");
        }
    }

    public synchronized void addToStatistics(AnimatedObjectStatus status) {
        statistics[this.objectType.ordinal()][status.ordinal()]++;
    }

    public static Integer[][] getStatistics() {return statistics;}

    public void setPosition(Coordinates coordinates) {
        this.position = coordinates;
    }

    public synchronized AnimatedObjectStatus getStatus() {return this.status;}

    public AnimationStatus getAnimationStatus() {return this.model.getStatus();}

    public void removeFromStatistics(AnimatedObjectStatus status) {
        statistics[this.objectType.ordinal()][status.ordinal()]--;
    }

    public void setStatus(AnimatedObjectStatus status) {
        this.removeFromStatistics(this.status);
        this.status = status;
        this.addToStatistics(status);
    }

    public Coordinates getPosition() {
        return this.position;
    }

    public void drawObject(Graphics g) {
        g.drawImage(objectImages[this.objectType.ordinal()], this.getPosition().x, this.getPosition().y, null );
    }

    public abstract void move();

    @Override
    public void run() {
        while(!(this.status == AnimatedObjectStatus.DEAD || this.status == AnimatedObjectStatus.STOPPED)) {
            this.getAnimationStatus();
            move();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
