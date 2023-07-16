import dao.TableTypeEntityDAO;
import dao.TransactionsEntityDAO;
import model.TableTypeEntity;
import model.TransactionsEntity;

import java.util.List;

public class Test_TransactionsEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        TransactionsEntityDAO.getInstance().insert(new TransactionsEntity(1,2,3,"bàn tròn", "2023-07-13 06:09:37","2023-07-13 06:09:37", 1));

//        lấy ra toàn bộ bảng và tả về List
        List<TransactionsEntity> transactions = TransactionsEntityDAO.getInstance().getAll();
        for (TransactionsEntity item: transactions){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+TransactionsEntityDAO.getInstance().getById(2).toString());
//        update
        TransactionsEntityDAO.getInstance().update(2,new TransactionsEntity(1,2,3,"bàn tròn có múa cột", "2023-07-13 06:09:37","2023-07-13 06:09:37", 1));
    }
}
