import dao.TableTypeEntityDAO;
import dao.TablesEntityDAO;
import model.TableTypeEntity;
import model.TablesEntity;

import java.util.List;

public class Test_TableTypeEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        TableTypeEntityDAO.getInstance().insert(new TableTypeEntity("bàn tròn", "hahaha", 1));

//        lấy ra toàn bộ bảng và tả về List
        List<TableTypeEntity> tableTypes = TableTypeEntityDAO.getInstance().getAll();
        for (TableTypeEntity item: tableTypes){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+TableTypeEntityDAO.getInstance().getById(2).toString());
//        update
        TableTypeEntityDAO.getInstance().update(2,new TableTypeEntity("bàn chữ nhật", "hohohoh", 1));
    }
}
