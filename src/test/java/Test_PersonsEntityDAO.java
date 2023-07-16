import dao.PersonsEntityDAO;
import model.PersonsEntity;

import java.util.List;

public class Test_PersonsEntityDAO {
    public static void main(String[] args) {
//        thêm mới đối tượng vào bảng (không truyền id vào đối tượng nếu không sẽ bị lỗi, bảng sẽ tự thêm id)
        PersonsEntityDAO.getInstance().insert(new PersonsEntity("sssssssss","2023-07-13","Hà Nội","hieudeptra","1234567",1,"nguyenvasssna@example.com", "2023-07-13 06:09:37", "2023-07-13 06:09:37", 1));

//        lấy ra toàn bộ bảng và tả về List
        List<PersonsEntity> persons  = PersonsEntityDAO.getInstance().getAll();
        for (PersonsEntity item: persons){
            System.out.println(item.toString());
        }

//        lấy ra đối tượng qua id
        System.out.println("phần tử có id = 2 là: "+PersonsEntityDAO.getInstance().getById(2).toString());
//        update
        PersonsEntityDAO.getInstance().update(8,new PersonsEntity("ssssssss","2023-07-13","Hà Nội","hieudefsdsdfsdfptra","123sdfdf4567",1,"nguyensdfsdfvasssna@example.com", "2023-07-13 06:09:37", "2023-07-13 06:09:37", 1));
    }
}
