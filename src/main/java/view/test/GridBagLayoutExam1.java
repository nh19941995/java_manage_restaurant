package view.test;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GridBagLayoutExam1 {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public GridBagLayoutExam1() {
        prepareGUI();
    }

    public static void main(String[] args) {
        GridBagLayoutExam1 demo = new GridBagLayoutExam1();
        demo.showGridBagLayoutDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame();
//        xác định kích thước cửa sổ giao diện người dùng khi nó được hiển thị.
        mainFrame.setSize(400, 400);
//        Dòng mã này đặt Layout Manager của JFrame thành GridLayout với 3 dòng và 1 cột.
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setBackground(Color.GREEN);
//        JLabel là một thành phần giao diện người dùng trong Swing để hiển thị văn bản hoặc hình ảnh không tương tác.
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setBackground(Color.BLUE);



        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(Color.CYAN);
//        thêm các phần tử vào
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);

//        tùy chỉnh hiển thị và đóng chơng trình
        mainFrame.setVisible(true);
        mainFrame.setTitle("Ví dụ GridBagLayout trong Java Swing");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void showGridBagLayoutDemo() {
//        được sử dụng để thiết lập văn bản của một JLabel có tên là headerLabel.
        headerLabel.setText("Layout in action: GridBagLayout");

//        JPanel là một container có khả năng chứa và sắp xếp các thành phần giao diện người dùng.
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setSize(500, 300);
//        Layout Manager của JPanel thành GridBagLayout.
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);


        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL; // Thuộc tính fill xác định cách các thành phần bên trong ô của lưới GridBagLayout sẽ được lấp đầy nếu có không gian dư thừa
        gbc.gridx = 0; //Thuộc tính gridx xác định chỉ số cột của ô trong lưới GridBagLayout mà thành phần hiện tại sẽ được đặt.
        gbc.gridy = 0;
        panel.add(new JButton("Button 1"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JButton("Button 3"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JButton("Button 4"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 5"), gbc);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }


}
