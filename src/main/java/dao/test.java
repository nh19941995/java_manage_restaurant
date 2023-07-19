package dao;

import model.BookingsEntity;
import java.util.ArrayList;

public class test implements DAOInterface<BookingsEntity, BookingsEntity>{
    @Override
    public boolean insert(BookingsEntity o) {
        return false;
    }

    @Override
    public int update(int id, BookingsEntity o) {
        return 0;
    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public BookingsEntity getById(int t) {
        return null;
    }
}
