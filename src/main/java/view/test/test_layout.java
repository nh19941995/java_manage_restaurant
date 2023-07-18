package view.test;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;


public class test_layout extends JFrame {
    public test_layout(){
//        khung ngoài phần mềm-----------------------------------------------------------------------------------
//        tiêu đề cho form
        this.setTitle("Register");
//        đặt kích thước của nó là 300 pixel chiều rộng và 600 pixel chiều cao.
        this.setSize(600,400);
//        đặt vị trí của cửa sổ JFrame ở giữa màn hình.
        this.setLocationRelativeTo(null);

        //        khai báo các thành phần
        JButton Button_1 = new JButton("1");
        JButton Button_2 = new JButton("2");
        JButton Button_3 = new JButton("3");
        JButton Button_4 = new JButton("4");
        JButton Button_5 = new JButton("5");
        JButton Button_6 = new JButton("6");

        //        thêm các thành phần cho layout FlowLayout và GridLayout
        this.add(Button_1);
        this.add(Button_2);
        this.add(Button_3);
        this.add(Button_4);
        this.add(Button_5);
        this.add(Button_6);

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JButton("Button1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 3"), gbc);













//        hiển thị phần mềm--------------------------------------------------------------------------------------------------------------
//        khi người dùng đóng cửa sổ, ứng dụng sẽ kết thúc và thoát khỏi chương trình.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        được sử dụng để hiển thị cửa sổ JFrame trên màn hình. Khi bạn gọi phương thức này với giá trị true, cửa sổ sẽ trở nên hiển thị.
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new test_layout();
    }
}
