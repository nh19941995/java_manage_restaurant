import dao.DishTypeEntityDAO;
import dao.MenuEntityDAO;
import model.DishTypeEntity;
import model.MenuEntity;

import java.util.List;

public class Test_MenuEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
//        MenuEntityDAO.getInstance().insert(new MenuEntity(1,9,10,1,"2023-07-13 06:58:56",1));

//        lấy ra toàn bộ bảng và tả về List
//        List<MenuEntity> dishTypes = MenuEntityDAO.getInstance().getAll();
//        for (MenuEntity item: dishTypes){
//            System.out.println(item.toString());
//        }

//        lấy ra đối tượng qua id
//        System.out.println("phần tử có id = 2 là: "+MenuEntityDAO.getInstance().getById(2).toString());
//        update
        MenuEntityDAO.getInstance().update(7,new MenuEntity(1,9,10,9999,"2023-07-13 06:58:56",1));
    }
}
