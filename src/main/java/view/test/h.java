package view.test;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.UIManager;
import dao.PersonsEntityDAO;
import model.PersonsEntity;
import javax.swing.*;
import java.awt.*;
public class h {
    private JPanel panel1;
    private JTabbedPane menu;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JEditorPane editorPane1;
    private JTabbedPane tabbedPane1;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            new h();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void createUIComponents() {

        // TODO: place custom component creation code here
    }
}
