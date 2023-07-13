import dao.BookingsEntityDAO;
import dao.BookingsInfoEntityDAO;
import model.BookingsEntity;
import model.BookingsInfoEntity;

import java.util.List;

public class Test_BookingsInfoEntity {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        BookingsInfoEntityDAO.getInstance().insert(new BookingsInfoEntity(2,"bay lắc","2023-07-13 06:33:47","2023-07-13 06:33:47","2023-07-13 06:33:47",100000,1));

//        lấy ra toàn bộ bảng và tả về List
        List<BookingsInfoEntity> bookingsInfo = BookingsInfoEntityDAO.getInstance().getAll();
        for (BookingsInfoEntity item: bookingsInfo){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+BookingsInfoEntityDAO.getInstance().getById(2).toString());

    }
}
