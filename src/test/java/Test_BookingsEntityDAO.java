import dao.BookingsEntityDAO;
import dao.TransactionsTypeEntityDAO;
import model.BookingsEntity;
import model.TransactionsTypeEntity;

import java.util.List;

public class Test_BookingsEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        BookingsEntityDAO.getInstance().insert(new BookingsEntity(2,2,2,2));

//        lấy ra toàn bộ bảng và tả về List
        List<BookingsEntity> bookings = BookingsEntityDAO.getInstance().getAll();
        for (BookingsEntity item: bookings){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+BookingsEntityDAO.getInstance().getById(2).toString());
//        update đối tượng
        BookingsEntityDAO.getInstance().update(1,new BookingsEntity(1,1,1,1));

    }
}
