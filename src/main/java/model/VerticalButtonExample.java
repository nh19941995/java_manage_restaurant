package model;

import javax.swing.*;
import java.awt.*;

public class VerticalButtonExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Tạo một JFrame
            JFrame frame = new JFrame("Vertical Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);

            // Tạo một JPanel
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            // Tạo một JButton với văn bản nằm dọc
            JButton button = new JButton("Vertical Button");
            button.setUI(new VerticalButtonUI());

            // Thêm nút vào JPanel
            panel.add(button, BorderLayout.CENTER);

            // Thêm JPanel vào JFrame
            frame.add(panel);

            // Hiển thị JFrame
            frame.setVisible(true);
        });
    }

    // Lớp UI tùy chỉnh để vẽ nút theo hướng dọc
    static class VerticalButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();

            // Xoay góc 90 độ
            g2.rotate(Math.toRadians(90), c.getWidth() / 2, c.getHeight() / 2);

            // Vẽ nút
            super.paint(g2, c);

            g2.dispose();
        }
    }
}

