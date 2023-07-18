package view.test;

import javax.swing.*;
import java.awt.*;
//import com.formdev.flatlaf.FlatLaf;

public class test_jpanel extends JFrame {
    public test_jpanel(){
        //        khung ngoài phần mềm-----------------------------------------------------------------------------------
//        tiêu đề cho form
        this.setTitle("Register");
//        đặt kích thước của nó là 300 pixel chiều rộng và 600 pixel chiều cao.
        this.setSize(600,400);
//        đặt vị trí của cửa sổ JFrame ở giữa màn hình.
        this.setLocationRelativeTo(null);

//        tạo layout con
        JPanel SearchBar_Panel = new JPanel();
        // Tạo Boxlayout với hằng số X_AXIS
        BoxLayout boxlayout = new BoxLayout(SearchBar_Panel, BoxLayout.X_AXIS);
        SearchBar_Panel.setLayout(boxlayout);
        SearchBar_Panel.setBackground(Color.CYAN);
        // Tạo các Button
        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        // Thêm Button vào Panel
        SearchBar_Panel.add(jb1);
        SearchBar_Panel.add(jb2);

        JPanel table_Panel = new JPanel();
        BoxLayout boxlayout2 = new BoxLayout(table_Panel, BoxLayout.X_AXIS);
        table_Panel.setLayout(boxlayout2);
        table_Panel.setBackground(Color.BLUE);
        // Tạo các Button
        JButton jb3 = new JButton("Button 3");
        JButton jb4 = new JButton("Button 4");
        // Thêm Button vào Panel
        table_Panel.add(jb3);
        table_Panel.add(jb4);

//        layout của lớp
        this.setLayout(new BorderLayout());
//        hiển thị phần mềm--------------------------------------------------------------------------------------------------------------
//        khi người dùng đóng cửa sổ, ứng dụng sẽ kết thúc và thoát khỏi chương trình.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(SearchBar_Panel,BorderLayout.NORTH);
        this.add(table_Panel,BorderLayout.CENTER);
//        được sử dụng để hiển thị cửa sổ JFrame trên màn hình. Khi bạn gọi phương thức này với giá trị true, cửa sổ sẽ trở nên hiển thị.
        this.setVisible(true);



    }

    public static void main(String[] args) {

        new test_jpanel();

    }
}
