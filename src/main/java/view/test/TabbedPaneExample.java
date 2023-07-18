package view.test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class TabbedPaneExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tabbed Pane Example");


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

            JPanel tab1 = new JPanel();
            JPanel tab2 = new JPanel();
            JPanel tab3 = new JPanel();

            tabbedPane.addTab("Tab 1", tab1);
            tabbedPane.addTab("Tab 2", tab2);
            tabbedPane.addTab("Tab 3", tab3);

            frame.getContentPane().add(tabbedPane);

            frame.pack();
            frame.setVisible(true);
        });
    }
}


