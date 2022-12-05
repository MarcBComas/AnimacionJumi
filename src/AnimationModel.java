import java.util.ArrayList;
import java.util.Random;

public class AnimationModel implements Runnable{
    private Integer minObjectsAlive = 2;
    private Integer maxObjectsAlive = 6;
    private AnimationStatus status;
    private AnimationController animationController;
    private ArrayList<AnimatedObject> animatedObjects;

    public AnimationModel(AnimationController controller) {
        this.setController(controller);
        AnimatedObject.loadObjectImages();
        AnimatedObject.createStatistics();
        this.start();
    }

    public void addNewObject() {
        Random r = new Random();
        AnimatedObject obj;
        switch (r.nextInt(4)) {
            case 0:
                obj = new Anarchic(this);
                this.animatedObjects.add(obj);
                new Thread(obj).start();
                break;
            case 1:
                obj = new Gravity(this);
                this.animatedObjects.add(obj);
                new Thread(obj).start();
                break;
            case 2:
                obj = new ShortLived(this);
                this.animatedObjects.add(obj);
                new Thread(obj).start();
                break;
            case 3:
                obj = new Rebound(this);
                this.animatedObjects.add(obj);
                new Thread(obj).start();
                break;
        }
    }

    public synchronized AnimationStatus getStatus() {
        if (this.status == AnimationStatus.PAUSED) {
            try {
                wait();
                } catch (InterruptedException e) {
                System.out.println(e.fillInStackTrace());
            }
        }
        return this.status;
    }

    public ArrayList<AnimatedObject> getObjects() {
        return animatedObjects;
    }

    public Integer[][] getStatistics() {
        return this.animatedObjects.get(0).getStatistics();
    }

    public synchronized void play() {
        this.status = AnimationStatus.RUNNING;
        notifyAll();
        for (int i = 0; i < this.animatedObjects.size() ; i++) {
            this.animatedObjects.get(i).setStatus(AnimatedObjectStatus.RUNNING);
        }
    }

    public synchronized void pause() {
        this.status = AnimationStatus.PAUSED;
        for (int i = 0; i < this.animatedObjects.size() ; i++) {
            this.animatedObjects.get(i).setStatus(AnimatedObjectStatus.PAUSED);
        }
    }

    public void start() {
        this.animatedObjects = new ArrayList<>();
        for (int i = 0; i < this.maxObjectsAlive ; i++) {
            this.addNewObject();
        }
        this.play();
    }

    public synchronized void setStatus(AnimationStatus status) {this.status = status;}

    public void setController(AnimationController controller) {this.animationController = controller;}

    public void setMinObjectsAlive(Integer minObjectsAlive) {
        this.minObjectsAlive = minObjectsAlive;
    }

    public void setMaxObjectsAlive(Integer maxObjectsAlive) {
        this.maxObjectsAlive = maxObjectsAlive;
    }

    @Override
    public void run() {
        while (this.status == AnimationStatus.RUNNING) {
            for (int i = 0; i < this.getObjects().size(); i++) {
                if(this.getObjects().get(i).getStatus() == AnimatedObjectStatus.DEAD || this.getObjects().get(i).getStatus() == AnimatedObjectStatus.STOPPED) {
                    this.getObjects().remove(i);
                }
            }
            if(this.getObjects().size() < this.minObjectsAlive) {
                this.addNewObject();
            }
        }
    }
}
