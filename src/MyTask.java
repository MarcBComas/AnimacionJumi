public class MyTask {

    public static void main(String[] args) {
        AnimationController controller = new AnimationController();
        new Thread(controller.getModel()).start();
        new Thread(controller.getView()).start();
    }
}
