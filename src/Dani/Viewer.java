package Dani;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Viewer extends Canvas implements Runnable {
    // Veremos una imagen
    private BufferedImage imagen;

    public Viewer() {
        try {
            this.imagen = ImageIO.read(new File("dog.jpg"));
        } catch (IOException e) {
            System.out.println("No hay imagen");
        }
    }

    public void paint() throws InterruptedException {
        int x = 0;
        int y = 0;
        Random r = new Random();
        Graphics g = this.getGraphics();
        int anchoVisor = getWidth();
        int altoVisor = getHeight();
        int anchoImg = this.imagen.getWidth();
        int altoImg = this.imagen.getHeight();
        boolean cambio = false;

//        if (g == null) {
//            System.out.println("No se ha podido pintar");
//        } else {
//            while(true) {
//                try {
//                    Thread.sleep(10);
//                    this.update(g);
//                    if (x <= 0) {
//                        x++;
//                        g.drawImage(this.imagen,x,y,null);
//                    }
//                    if (y <= 0) {
//                        y++;
//                        g.drawImage(this.imagen,x,y,null);
//                    }
//                    if (x >= altoVisor){
//                        x--;
//                        g.drawImage(this.imagen,x,y,null);
//                    }
//                    if (y >= anchoVisor) {
//                        y--;
//                        g.drawImage(this.imagen,x,y,null);
//                    }
//                    if (x < altoVisor/2) {
//                        x++;
//                        g.drawImage(this.imagen,x,y,null);
//                    }
//                    if (y < anchoVisor/2) {
//                        y++;
//                        g.drawImage(this.imagen,x,y,null);
//                    }
//                    switch(r.nextInt(4)) {
//                        case 0:
//                            x++;
//                            g.drawImage(this.imagen,x,y,null);
//                            break;
//                        case 1:
//                            x--;
//                            g.drawImage(this.imagen,x,y,null);
//                            break;
//                        case 2:
//                            y++;
//                            g.drawImage(this.imagen,x,y,null);
//                            break;
//                        case 3:
//                            y--;
//                            g.drawImage(this.imagen,x,y,null);
//                            break;
//                    }
//                } catch (InterruptedException e) {
//                    System.out.println(e.fillInStackTrace());
//                }
//            }
//        }

        /* if (g == null) {
            System.out.println("No se ha pintado");
        } else {
            while (true) {
                try {
                    Thread.sleep(50);
                    this.update(g);
                    if (x < alto && cambio) {
                        g.drawImage(this.imagen, x, y, null);
                        x++;
                    } else {
                        if (y < ancho && cambio) {
                            g.drawImage(this.imagen, x, y, null);
                            y++;
                        } else {
                            cambio = false;
                        }
                    }
                    if (x > 0 && cambio == false) {
                        g.drawImage(this.imagen, x, y, null);
                        x--;
                    } else {
                        if (y > 0 && cambio == false) {
                            g.drawImage(this.imagen, x, y, null);
                            y--;
                        } else {
                            cambio = true;
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } */
    }
    @Override
    public void update(Graphics g){
        super.paint(g);
    }


    @Override
    public void run() {
        try {
            paint();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
