import java.awt.*;

public interface VisualObject {
    public void drawObject(Graphics g);
    public Coordinates getPosition();
    private void setPosition(Coordinates c) {};

}
