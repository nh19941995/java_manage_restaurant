package view.Tool;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    public Grid() {
        setLayout(new GridBagLayout());
    }

    public void GridAdd(Component element, int x, int y){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
//        JPanel panel = new JPanel(new BorderLayout()); // Tạo lớp trung gian
//        panel.add(element); // Thêm thành phần vào lớp trung gian
        add(element, gbc); // Thêm lớp trung gian vào JPanel
    }

    public void GridAdd(Component element, int x, int y,int left,int right,int topBot){
        Insets paddingInput = new Insets(topBot, left, topBot, right);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = paddingInput;
        gbc.gridx = x;
        gbc.gridy = y;

//        JPanel panel = new JPanel(new BorderLayout()); // Tạo lớp trung gian
//        panel.add(element); // Thêm thành phần vào lớp trung gian

        add(element, gbc); // Thêm lớp trung gian vào JPanel
        // Đặt padding về giá trị mặc định
        gbc.insets = new Insets(0, 0, 0, 0);
    }
}

