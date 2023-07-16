import dao.PermissionsEntityDAO;
import dao.SalariesEntityDAO;
import model.PermissionsEntity;
import model.SalariesEntity;

import java.util.List;

public class Test_SalariesEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        SalariesEntityDAO.getInstance().insert(new SalariesEntity(5, 99999999, "2023-07-13 06:09:37", 1));

//        lấy ra toàn bộ bảng và tả về List
        List<SalariesEntity> Salaries = SalariesEntityDAO.getInstance().getAll();
        for (SalariesEntity item: Salaries){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+SalariesEntityDAO.getInstance().getById(2).toString());
//        update
        SalariesEntityDAO.getInstance().update(2,new SalariesEntity(2, 333333, "2023-07-13 06:09:37", 1));
    }
}
