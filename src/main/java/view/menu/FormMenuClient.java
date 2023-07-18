package view.menu;
import javax.swing.UIManager;
import dao.PersonsEntityDAO;
import model.PersonsEntity;
import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JTabbedPane;

public class FormMenuClient extends JFrame {
    PersonsEntity persons = new PersonsEntity();
    public FormMenuClient(){
//        khung ngoài phần mềm-----------------------------------------------------------------------------------
        this.setTitle("Register");          //        tiêu đề cho form
        this.setSize(600,400);  //        đặt kích thước của nó là 300 pixel chiều rộng và 600 pixel chiều cao.
        this.setLocationRelativeTo(null);   //        đặt vị trí của cửa sổ JFrame ở giữa màn hình.
        JFrame frame = new JFrame();

//        tạo layout phần tìm kiếm-------------------------------------------------------------------------------
        JPanel searchBar_Panel = new JPanel();

        GridBagLayout layout   = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();



        BoxLayout boxlayout = new BoxLayout(searchBar_Panel, BoxLayout.X_AXIS); // Tạo Boxlayout với hằng số X_AXIS

        searchBar_Panel.setLayout(boxlayout);
//        Tạo các Button
        JTextField searchByName = new JTextField(50);
        JTextField searchByPhone = new JTextField(50);
//        Thêm Button vào Panel
        searchBar_Panel.add(searchByName);
        searchBar_Panel.add(searchByPhone);

//        tạo layout phần bảng-------------------------------------------------------------------------------------
        JPanel table_Panel = new JPanel();
//        table_Panel.setBackground(Color.GREEN);
//         Tạo dữ liệu cho bảng
        Object[][] data = PersonsEntityDAO.getInstance().getAll().stream().map(
                s->new Object[]{
                        s.getId(),
                        s.getName(),
                        s.getDateOfBirth(),
                        s.getPhone(),
                        s.getUsername(),
                        s.getEmail(),
                        s.getDateCreat(),
                        s.getDateUpdate(),
                        s.getFlag()
                }
        ).toArray(Object[][]::new);
//        Tiêu đề cột
        Object[] columnNames = {"ID", "Name", "Date of brith","Phone number","Username","Email","Date creat","Date update"};

//        Tạo JFrame và thêm JScrollPane chứa bảng vào
//        Tạo một JTable với dữ liệu và tiêu đề cột
        JTable table = new JTable(data, columnNames);

//        Tạo một JScrollPane để chứa bảng
        JScrollPane scrollPane = new JScrollPane(table);
//         Đặt cài đặt cuộn theo yêu cầu cho JScrollPane
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//        Đặt layout cho table_Panel là BorderLayout
        table_Panel.setLayout(new BorderLayout());
        table_Panel.add(scrollPane, BorderLayout.CENTER);

//        layout chuyển tab --------------------------------------------------------------------------------------------------------------

//        tạo các tab
        JPanel tab_Panel = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        JPanel tab1 = new JPanel();
        JPanel tab2 = new JPanel();
        tabbedPane.addTab("Select menu", tab1);
        tabbedPane.addTab("Add new", tab2);

//        ++++++++++++++++ tab select menu +++++++++++++++
        JButton submitSelectClient = new JButton("Submit");
//        đặt layout cho tab
        tab1.setLayout(new BorderLayout());
//        thêm các phần tử cho tab
        tab1.add(searchBar_Panel,BorderLayout.NORTH);
        tab1.add(table_Panel,BorderLayout.CENTER);
        tab1.add(submitSelectClient,BorderLayout.SOUTH);


//        tab2.add(table_Panel,BorderLayout.CENTER);
        frame.getContentPane().add(tabbedPane);

        frame.pack();
        frame.setVisible(true);























//        hiển thị phần mềm--------------------------------------------------------------------------------------------------------------

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //        khi người dùng đóng cửa sổ, ứng dụng sẽ kết thúc và thoát khỏi chương trình.
        frame.setVisible(true);                               //        được sử dụng để hiển thị cửa sổ JFrame trên màn hình. Khi bạn gọi phương thức này với giá trị true, cửa sổ sẽ trở nên hiển thị.

    }



    public static void main(String[] args) {
        try {
//            chuyển giao diện sang giống ios
            UIManager.setLookAndFeel(new FlatLightLaf());
            new FormMenuClient();
        }catch (Exception e){

        }
    }
}
