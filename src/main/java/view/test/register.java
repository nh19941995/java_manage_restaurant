package view.test;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class register extends JFrame {
//    khai báo thuộc tính là ô input
    private JTextField inputField;
    public register(){

//        khung ngoài phần mềm-----------------------------------------------------------------------------------
//        tiêu đề cho form
        this.setTitle("Register");
//        đặt kích thước của nó là 300 pixel chiều rộng và 600 pixel chiều cao.
        this.setSize(600,400);
//        đặt vị trí của cửa sổ JFrame ở giữa màn hình.
        this.setLocationRelativeTo(null);


//        các phần tử -----------------------------------------------------------------------------------------

//        khai báo các thành phần
        JButton Button_1 = new JButton("1");
        JButton Button_2 = new JButton("2");
        JButton Button_3 = new JButton("3");
        JButton Button_4 = new JButton("4");
        JButton Button_5 = new JButton("5");
        JButton Button_6 = new JButton("6");

//        // Đặt hiển thị viền
//        Button_1.setBorderPainted(true);
//        // Đặt kích thước cho JButton bằng setPreferredSize()
//        Button_1.setPreferredSize(new Dimension(150, 50));


//        thêm các thành phần cho layout FlowLayout và GridLayout
//        this.add(Button_1);
//        this.add(Button_2);
//        this.add(Button_3);
//        this.add(Button_4);
//        this.add(Button_5);
//        this.add(Button_6);


//        layout ---------------------------------------------------------------------------------------------

//        ++ FlowLayout dàn hàng ngang
        FlowLayout Layout_1 = new FlowLayout(); // để trống sẽ căn giưã
        FlowLayout Layout_2 = new FlowLayout(FlowLayout.LEFT);     //trái
        FlowLayout Layout_3 = new FlowLayout(FlowLayout.LEADING);  //căn trên - trái
        FlowLayout Layout_4 = new FlowLayout(FlowLayout.RIGHT);    //căn phải
        FlowLayout Layout_5 = new FlowLayout(FlowLayout.TRAILING); // trên - phải
        FlowLayout Layout_6 = new FlowLayout(FlowLayout.CENTER,30,30); // căn giưã và đặt khoảng cách
//        chạy đối tượng layout đó trên chương trình
//        this.setLayout(Layout_1);
//        this.setLayout(Layout_2);
//        this.setLayout(Layout_3);
//        this.setLayout(Layout_4);
//        this.setLayout(Layout_5);
//        this.setLayout(Layout_6);

//        ++ GridLayout dạng lưới
        GridLayout gridLayout_1 = new GridLayout();
        GridLayout gridLayout_2 = new GridLayout(3,3);
        GridLayout gridLayout_3 = new GridLayout(3,3,25,25);
//        chạy đối tượng layout đó trên chương trình
//        this.setLayout(gridLayout_1);
//        this.setLayout(gridLayout_2);
//        this.setLayout(gridLayout_3);



//        ++ dạng boder
        BorderLayout borderLayout_1 = new BorderLayout();
        BorderLayout borderLayout_2 = new BorderLayout(50, 50);
//        chạy đối tượng layout đó trên chương trình
//        this.setLayout(borderLayout_1);
        this.setLayout(borderLayout_2);

//        thêm các thành phần cho layout BorderLayout (bắt buộc thêm sau khi chọn layout)
        this.add(Button_1, BorderLayout.NORTH);
        this.add(Button_2,BorderLayout.SOUTH);
        this.add(Button_3, BorderLayout.WEST);
        this.add(Button_4, BorderLayout.EAST);
        this.add(Button_5, BorderLayout.CENTER);





















//        hiển thị phần mềm--------------------------------------------------------------------------------------------------------------
//        khi người dùng đóng cửa sổ, ứng dụng sẽ kết thúc và thoát khỏi chương trình.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        được sử dụng để hiển thị cửa sổ JFrame trên màn hình. Khi bạn gọi phương thức này với giá trị true, cửa sổ sẽ trở nên hiển thị.
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new register();
    }

}
