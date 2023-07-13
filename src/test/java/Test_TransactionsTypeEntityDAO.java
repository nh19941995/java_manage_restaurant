import dao.TransactionsTypeEntityDAO;
import model.TransactionsTypeEntity;

import java.util.List;

public class Test_TransactionsTypeEntityDAO{
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        TransactionsTypeEntityDAO.getInstance().insert(new TransactionsTypeEntity("ddddddddddd","2023-07-13 10:30:00","2023-07-13 10:30:00",1));

//        lấy ra toàn bộ bảng và tả về List
        List<TransactionsTypeEntity> types = TransactionsTypeEntityDAO.getInstance().getAll();
        for (TransactionsTypeEntity item: types){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 3 là: "+TransactionsTypeEntityDAO.getInstance().getById(3).toString());

    }
}
