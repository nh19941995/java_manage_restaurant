import dao.SalariesEntityDAO;
import dao.TablesEntityDAO;
import model.SalariesEntity;
import model.TablesEntity;

import java.util.List;

public class Test_TablesEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        TablesEntityDAO.getInstance().insert(new TablesEntity(10, 1, 1));

//        lấy ra toàn bộ bảng và tả về List
        List<TablesEntity> tables = TablesEntityDAO.getInstance().getAll();
            for (TablesEntity item: tables){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+TablesEntityDAO.getInstance().getById(2).toString());
//        update
        TablesEntityDAO.getInstance().update(2,new TablesEntity(10, 1, 9999));
    }
}
