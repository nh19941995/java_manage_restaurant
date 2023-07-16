import dao.BookingsEntityDAO;
import dao.DishEntityDAO;
import model.BookingsEntity;
import model.DishEntity;

import java.util.List;

public class Test_DishEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
//        DishEntityDAO.getInstance().insert(new DishEntity("munber one",12,"2023-07-12 10:58:47","2023-07-12 10:58:47",1,1));

//        lấy ra toàn bộ bảng và tả về List
//        List<DishEntity> dishs = DishEntityDAO.getInstance().getAll();
//        for (DishEntity item: dishs){
//            System.out.println(item.toString());
//        }

//        lấy ra đối tượng qua id
//        System.out.println("phần tử có id = 2 là: "+DishEntityDAO.getInstance().getById(2).toString());
//        update
        DishEntityDAO.getInstance().update(12,new DishEntity("munber one vàng",12,"2023-07-12 10:58:47","2023-07-12 10:58:47",1,1));
    }
}
