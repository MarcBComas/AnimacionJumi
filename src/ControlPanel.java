import javax.swing.*;

public class ControlPanel extends JPanel {
    public JButton bPlay = new JButton("Play");
    public JButton bPause = new JButton("Pause");
    public JTextField minObjectsAlive = new JTextField("4");
    public JTextField maxObjectsAlive = new JTextField("6");
    public AnimationView view;

    public ControlPanel(AnimationView view) {
        this.view = view;
        bPlay.addActionListener(e -> view.play());
        bPause.addActionListener(e -> view.pause());
        this.add(bPlay);
        this.add(bPause);
        this.add(minObjectsAlive);
        this.add(maxObjectsAlive);
    }

}
