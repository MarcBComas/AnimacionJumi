import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AnimationView extends JFrame implements ActionListener, Runnable {
    public Integer refreshMillis = 50;
    private final StatisticsPanel statisticPanel;
    private final ControlPanel controlPanel;
    private AnimationController animationController;
    private final Viewer viewer = new Viewer(this);

    public AnimationView(AnimationController controller) {
        this.setController(controller);
        this.statisticPanel = new StatisticsPanel();
        this.controlPanel = new ControlPanel(this);
        this.setName("Animacion");
        this.setVisible(true);
        this.setSize(new Dimension(1800, 700));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(statisticPanel, c);

        c.gridy = 1;
        c.weighty = 0;
        add(controlPanel, c);

        c.gridheight = 2;
        c.weightx = 2;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        add(viewer, c);
        pack();
    }


    public void refresh() {
        viewer.getGraphics().drawImage(viewer.getBG(), 0, 0, null);
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (!(this.getObjects().get(i).getStatus() == AnimatedObjectStatus.DEAD || this.getObjects().get(i).getStatus() == AnimatedObjectStatus.STOPPED)) {
                this.getObjects().get(i).drawObject(viewer.getGraphics());
            }
        }
        this.statisticPanel.setStatistics(getStatistics());
   }

    public Integer[][] getStatistics() {return this.animationController.getStatistic();}

    public void setController(AnimationController controller) {this.animationController = controller;}

    public void setRefreshMillis(Integer Mils) {
        this.refreshMillis = Mils;
    }

    public ArrayList<AnimatedObject> getObjects() {
        return this.animationController.getObjects();
    }

    public void play() {
        this.animationController.getModel().setMinObjectsAlive(Integer.valueOf(this.controlPanel.minObjectsAlive.getText()));
        this.animationController.getModel().setMaxObjectsAlive(Integer.valueOf(this.controlPanel.maxObjectsAlive.getText()));
        this.animationController.play();
    }

    public void pause() {
        this.animationController.pause();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                refresh();
                Thread.sleep(refreshMillis);
            } catch (InterruptedException e) {
                System.out.println(e.fillInStackTrace());
            }
        }
    }
}
