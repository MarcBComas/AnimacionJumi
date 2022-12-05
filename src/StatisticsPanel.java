import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StatisticsPanel extends JScrollPane {

    private JTable tabla;
    private DefaultTableModel dtm;
    private AnimationView view;

    public StatisticsPanel() {
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        Object[] columnNames = {"", "Running", "Paused", "Stopped", "Dead"};
        Object[][] data = new Object[][] {
                {"Zombie" , 0, 0, 0, 0},
                {"Alien"  , 0, 0, 0, 0},
                {"Soldier", 0, 0, 0, 0},
                {"Dog"    , 0, 0, 0, 0}
        };
        tabla = new JTable();
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setDataVector(data, columnNames);
        tabla.setModel(dtm);
        tabla.getColumn("").setPreferredWidth(1);
        tabla.getColumn("Running").setPreferredWidth(10);
        tabla.getColumn("Paused").setPreferredWidth(10);
        tabla.getColumn("Stopped").setPreferredWidth(10);
        tabla.getColumn("Dead").setPreferredWidth(10);
        setViewportView(tabla);
    }

    public void setStatistics(Integer[][] statistics) {
        for(int i=0; i<statistics.length; ++i) {
            for(int j=0; j<statistics[i].length; ++j) {
                dtm.setValueAt(statistics[i][j], i, j+1);
            }
        }
    }
}
