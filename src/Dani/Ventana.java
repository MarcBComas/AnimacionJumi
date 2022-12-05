package Dani;
import javax.swing.*;
public class Ventana extends JFrame {
    Viewer miVisor = new Viewer();
    public Ventana() {
        CrearVentana();
    }

    public void CrearVentana() {
        setSize(800,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(miVisor);
        setResizable(true);
        setVisible(true);
        miVisor.run();
    }
}
