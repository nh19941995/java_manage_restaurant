import dao.DishEntityDAO;
import dao.DishTypeEntityDAO;
import model.DishEntity;
import model.DishTypeEntity;

import java.util.List;

public class Test_DishTypeEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        DishTypeEntityDAO.getInstance().insert(new DishTypeEntity("test",1));

//        lấy ra toàn bộ bảng và tả về List
        List<DishTypeEntity> dishTypes = DishTypeEntityDAO.getInstance().getAll();
        for (DishTypeEntity item: dishTypes){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+DishTypeEntityDAO.getInstance().getById(2).toString());

    }
}
