import dao.MenuEntityDAO;
import dao.MenuNameEntityDAO;
import model.MenuEntity;
import model.MenuNameEntity;

import java.util.List;

public class Test_MenuNameEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
//        MenuNameEntityDAO.getInstance().insert(new MenuNameEntity("Liên hoan cuối năm 12a6",1));

//        lấy ra toàn bộ bảng và tả về List
//        List<MenuNameEntity> menuName = MenuNameEntityDAO.getInstance().getAll();
//        for (MenuNameEntity item: menuName){
//            System.out.println(item.toString());
//        }

//        lấy ra đối tượng qua id
//        System.out.println("phần tử có id = 2 là: "+MenuNameEntityDAO.getInstance().getById(2).toString());
//        update
        MenuNameEntityDAO.getInstance().update(4,new MenuNameEntity("--------------------",1));
    }
}
