package view.menu;

import com.formdev.flatlaf.FlatLightLaf;
import dao.*;
import model.BookingsEntity;
import view.Tool.Boder;
import view.Tool.Grid;
import java.util.List;

import javax.swing.*;
import java.awt.*;


public class FormBooking extends JFrame {
//    JTable table;

    public void setTable() {
        List<BookingsEntity> menuNameEntities = BookingsEntityDAO.getInstance().getAll();
        //        Tiêu đề cột
//        Object[] columnNames = {"Booking ID", "Reservation Name", "Phone number","Menu name","Table Type","Capacity","Start","End", "Deposit"};
        Object[] columnNames = {"Booking ID", "Infor ID", "Table ID","Menu name ID","Flag"};
        Object[][] data = menuNameEntities.stream().map(
                s->new Object[]{
                        s.getId(),
                        s.getInfoId(),
                        s.getTableId(),
                        s.getMenuNameId(),
                        s.getFlag()
                }
        ).toArray(Object[][]::new);
    }

    public FormBooking(){
//        khung ngoài phần mềm------------------------------------------------------------------------------------------
        setTitle("Register");             //        tiêu đề cho form
        // Tạo panel chính, mainPanel là một JPanel chứa toàn bộ giao diện của ứng dụng
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.decode("#293740"));
//        nội dung cho phần booking-------------------------------------------------------------------------------------
        Boder mainContentBooking = new Boder();
        mainContentBooking.setBackground(Color.decode("#EB5454"));
        // phần infomartion---------------------------------------------------------
        // phần tiêu đề
        JLabel labelTitle = new JLabel ("BOOKING INFORMATION");
        Grid jpaneBookingInfoTitle = new Grid();
        jpaneBookingInfoTitle.GridAdd(labelTitle,0,0,0,0,20);
        // phần bảng----------------------------------------------------------------
        // stream lấy đữ liệu

//        Boder boderTable = new Boder();

        List<BookingsEntity> menuNameEntities = BookingsEntityDAO.getInstance().getAll();


        Object[][] data = menuNameEntities.stream().map(
                s->new Object[]{
                        s.getId(),
                        s.getMenuNameId(),

                }
        ).toArray(Object[][]::new);


















//        phần tab chuyển-----------------------------------------------------------------------------------------------
        //        tạo đối tượng tab
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        JPanel tab1 = new JPanel();
        JPanel tab2 = new JPanel();
        JPanel tab3 = new JPanel();
        JPanel tab4 = new JPanel();
        JPanel tab5 = new JPanel();
        tabbedPane.addTab("Employee", tab1);
        tabbedPane.addTab("Transaction", tab2);
        tabbedPane.addTab("Booking", tab3);
        tabbedPane.addTab("Manage", tab4);
        tabbedPane.addTab("Menu", tab5);
        tab3.add(mainContentBooking,BorderLayout.CENTER);
        tabbedPane.setTabComponentAt(0, new JLabel("Employee"));
        tabbedPane.setTabComponentAt(1, new JLabel("Transaction"));
        tabbedPane.setTabComponentAt(2, new JLabel("Booking"));
        tabbedPane.setTabComponentAt(3, new JLabel("Manage"));
        tabbedPane.setTabComponentAt(4, new JLabel("Menu"));
        // Tạo mảng chứa kích thước mới cho các tab
        Dimension[] tabSizes = {new Dimension(100, 50),
                new Dimension(150, 50),
                new Dimension(100, 50),
                new Dimension(100, 50),
                new Dimension(100, 50)};
        // Đặt kích thước mới cho tab
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            Component tabComponent = tabbedPane.getTabComponentAt(i);
            if (tabComponent instanceof JLabel) {
                JLabel tabLabel = (JLabel) tabComponent;
                tabLabel.setPreferredSize(tabSizes[i]);
            }
        }
        // Đặt kích thước phông chữ cho tất cả các tab
        Font tabFont = new Font("MyFont", Font.BOLD, 14);
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            Component tabComponent = tabbedPane.getTabComponentAt(i);
            if (tabComponent instanceof JLabel) {
                JLabel tabLabel = (JLabel) tabComponent;
                tabLabel.setFont(tabFont);
            }
        }
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            Component tabComponent = tabbedPane.getTabComponentAt(i);
            if (tabComponent instanceof JLabel) {
                JLabel tabLabel = (JLabel) tabComponent;
                tabLabel.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa chữ trong tab
            }
        }
        // thay đổi màu chữ trong tab
        Color tabTextColor = Color.decode("#FFEFD7"); // Thay đổi màu chữ ở đây

        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            Component tabComponent = tabbedPane.getTabComponentAt(i);
            if (tabComponent instanceof JLabel) {
                JLabel tabLabel = (JLabel) tabComponent;
                tabLabel.setForeground(tabTextColor); // Đặt màu chữ cho tất cả các tab
            }
        }
        // thay đổi màu nền của tab
        tabbedPane.setBackground(Color.decode("#293740"));

        // thêm các tab vào layout chính
        mainPanel.add(tabbedPane, BorderLayout.CENTER);














//        Đảm bảo các thành phần giao diện được hiển thị----------------------------------------------------------------
        //        thêm mainPanel vào cửa sổ JFrame
        add(mainPanel);
        revalidate();
        repaint();
        setSize(1500, 900);
        setLocationRelativeTo(null);
        //        setBackground(Color.BLUE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
//            chuyển giao diện sang giống ios
            UIManager.setLookAndFeel(new FlatLightLaf());
            new FormBooking();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
