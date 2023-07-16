import dao.MenuNameEntityDAO;
import dao.PermissionsEntityDAO;
import model.MenuNameEntity;
import model.PermissionsEntity;

import java.sql.Timestamp;
import java.util.List;

public class Test_PermissionsEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
//        PermissionsEntityDAO.getInstance().insert(new PermissionsEntity("test", "2023-07-13 06:09:37", "2023-07-13 06:09:37", 1));

//        lấy ra toàn bộ bảng và tả về List
//        List<PermissionsEntity> menuName = PermissionsEntityDAO.getInstance().getAll();
//        for (PermissionsEntity item: menuName){
//            System.out.println(item.toString());
//        }

//        lấy ra đối tượng qua id
//        System.out.println("phần tử có id = 2 là: "+PermissionsEntityDAO.getInstance().getById(2).toString());
//        update
        PermissionsEntityDAO.getInstance().update(8,new PermissionsEntity("death", "2023-07-13 06:09:37", "2023-07-13 06:09:37", 1));
    }
}
