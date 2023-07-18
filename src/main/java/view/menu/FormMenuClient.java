package view.menu;

import com.formdev.flatlaf.FlatLightLaf;
import dao.PersonsEntityDAO;
import view.Tool.Boder;
import view.Tool.Grid;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class FormMenuClient extends JFrame {
    public FormMenuClient(){
//        khung ngoài phần mềm------------------------------------------------------------------------------------------
        setTitle("Register");             //        tiêu đề cho form
        // Tạo panel chính, mainPanel là một JPanel chứa toàn bộ giao diện của ứng dụng
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        //        mainPanel.setBackground(Color.gray);

//        Phần tìm kiếm-------------------------------------------------------------------------------------------------
        JButton searchByNameBTN = new JButton("Submit");
        JButton searchByPhoneBTN = new JButton("Submit");
        JTextField searchByName = new JTextField("Enter name",15);
        JTextField searchByPhone = new JTextField("Enter phone number",15);
        //        layout chính cho phần tìm kiếm
        JPanel containerSearchPanel = new JPanel();
        //        containerSearchPanel.setBackground(Color.ORANGE);
        containerSearchPanel.setLayout(new BorderLayout());
        //        layout phụ cho phần tìm kiếm
        JPanel searchPanel = new JPanel();
        //        searchPanel.setBackground(Color.yellow);
        //        tạo đối tượng cho layout GridBagLayout
        GridBagLayout gridBagLayout   = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        //        Tạo đối tượng Insets để định nghĩa padding
        Insets paddingInput = new Insets(10, 20, 10, 10);
        Insets paddingBTN = new Insets(10, 10, 10, 10);
        searchPanel.setLayout(gridBagLayout);
        //        padding cho tất cả các phần tử ở sau
        gbc.insets = paddingInput;
        //        đặt tọa độ cho phần tử
        gbc.gridx = 0;
        gbc.gridy = 0;
        searchPanel.add(searchByName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        searchPanel.add(searchByPhone, gbc);
        gbc.insets = paddingBTN;
        gbc.gridx = 1;
        gbc.gridy = 0;
        searchPanel.add(searchByNameBTN, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        searchPanel.add(searchByPhoneBTN, gbc);
        containerSearchPanel.setLayout(new BorderLayout());
        containerSearchPanel.add(searchPanel,BorderLayout.WEST);
        mainPanel.add(containerSearchPanel, BorderLayout.CENTER);

//        phần thêm client----------------------------------------------------------------------------------------------
        JLabel  firstNameLabel = new JLabel ("First name");
        JLabel  lastNameLabel = new JLabel ("Last Name");
        JLabel  DOBLabel = new JLabel ("Date of birth");
        JLabel  phoneLabel = new JLabel ("Phone number");
        JLabel  emailLabel = new JLabel ("Email");
        JLabel  addressLabel = new JLabel ("Address");

        JTextField firstNameInput = new JTextField("Enter first name",25);
        JTextField lastNameInput= new JTextField("Enter last Name",25);
        JTextField DOBInput = new JTextField("Enter date of birth",25);
        JTextField phoneInput = new JTextField("Enter phone number",25);
        JTextField emailInput= new JTextField("Enter email",25);
        JTextField addressInput = new JTextField("Enter address",25);
        JButton addNewClientBTN = new JButton("Submit");
        //        thêm phần tử vào panel và xác định vị trí
        Grid jpaneAddClient = new Grid();

        jpaneAddClient.GridAdd(firstNameLabel,0,0,30,50,20);
        jpaneAddClient.GridAdd(lastNameLabel,0,1,30,50,20);
        jpaneAddClient.GridAdd(DOBLabel,0,2,30,50,20);
        jpaneAddClient.GridAdd(phoneLabel,0,3,30,50,20);
        jpaneAddClient.GridAdd(emailLabel,0,4,30,50,20);
        jpaneAddClient.GridAdd(addressLabel,0,5,30,50,20);

        jpaneAddClient.GridAdd(firstNameInput,1,0,30,50,20);
        jpaneAddClient.GridAdd(lastNameInput,1,1,30,50,20);
        jpaneAddClient.GridAdd(DOBInput,1,2,30,50,20);
        jpaneAddClient.GridAdd(phoneInput,1,3,30,50,20);
        jpaneAddClient.GridAdd(emailInput,1,4,30,50,20);
        jpaneAddClient.GridAdd(addressInput,1,5,30,50,20);
        jpaneAddClient.GridAdd(addNewClientBTN,1,6,250,50,40);

        //        Tạo panel container
        Boder containerJpaneAddClient = new Boder();
        containerJpaneAddClient.add(jpaneAddClient,BorderLayout.CENTER);
//        containerJpaneAddClient.add(addNewClientBTN,BorderLayout.SOUTH);






//        Phần bảng ----------------------------------------------------------------------------------------------------
        JPanel table_Panel = new JPanel();
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
        //        Tạo một JTable với dữ liệu và tiêu đề cột
        JTable table = new JTable(data, columnNames);
        //        căn giữa chữ trong bảng
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        // Thiết lập chiều rộng cho các cột
        table.getColumnModel().getColumn(0).setMinWidth(30); // Cột ID
        table.getColumnModel().getColumn(0).setMaxWidth(50); // Cột ID

        table.getColumnModel().getColumn(1).setMinWidth(150); // Cột Name
        table.getColumnModel().getColumn(1).setMaxWidth(200); // Cột Name

        table.getColumnModel().getColumn(2).setMinWidth(100); // Cột ngày sinh
        table.getColumnModel().getColumn(2).setMaxWidth(150); // Cột ngày sinh

        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(150);

        table.getColumnModel().getColumn(4).setMinWidth(100);
        table.getColumnModel().getColumn(4).setMaxWidth(150);
        //        Tạo một JScrollPane để chứa bảng (thanh cuộn trang)
        JScrollPane scrollPane = new JScrollPane(table);
        //        Đặt layout cho table_Panel là BorderLayout
        table_Panel.setLayout(new BorderLayout());
        table_Panel.add(scrollPane, BorderLayout.CENTER);

//        phần tab chuyển đổi-------------------------------------------------------------------------------------------
        //        tạo đối tượng tab
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        JPanel tab1 = new JPanel();
        JPanel tab2 = new JPanel();
        JButton submitSelectClient = new JButton("Submit");
        tabbedPane.addTab("Select menu", tab1);
        tabbedPane.addTab("Add new", tab2);
        //        đặt layout cho tab
        tab1.setLayout(new BorderLayout());
        tab2.setLayout(new BorderLayout());
        //        thêm các phần tử cho từng tab
        // thêm toàn bộ phần tìm kiếm vào tab 1
        tab1.add(containerSearchPanel,BorderLayout.NORTH);
        // thêm bảng vào tab 1
        tab1.add(table_Panel,BorderLayout.CENTER);
        // thêm nút bấm vào tab 1
        tab1.add(submitSelectClient,BorderLayout.SOUTH);
        tab2.add(containerJpaneAddClient,BorderLayout.CENTER);
        // thêm toàn bộ phần tab vao trung tâm Jframe
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
            FormMenuClient menuClient = new FormMenuClient();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
