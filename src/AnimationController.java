import java.util.ArrayList;

public class AnimationController {

    private AnimationModel model = new AnimationModel(this);
    private AnimationView view = new AnimationView(this);


    public AnimationController() {
    }

    public void setView(AnimationView view) {
        this.view = view;
    }

    public void setModel(AnimationModel model) {
        this.model = model;
    }

    public AnimationView getView() {
        return view;
    }

    public AnimationModel getModel() {
        return model;
    }

    public ArrayList<AnimatedObject> getObjects() {
        return this.model.getObjects();
    }

    public Integer[][] getStatistic() {
        return AnimatedObject.getStatistics();
    }

    public AnimationStatus getAnimationStatus() {
        return this.model.getStatus();
    }

    public void pause() {
        this.model.pause();
    }

    public void play() {
        this.model.play();
    }
}
