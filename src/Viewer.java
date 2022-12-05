import javax.imageio.ImageIO;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Viewer extends Canvas {
    private Image background;
    private AnimationView view;

    public Image getBG() {
        return this.background;
    }

    public Viewer(AnimationView view) {
        this.view = view;
        drawBackground();
    }

    public void drawBackground() {
        try {
            this.background = ImageIO.read(new File("espacio.jpg"));
        } catch (IOException e) {
            System.out.println("Img error");
        }
    }

    @Override
    public void paint(Graphics g) {
    }
}
