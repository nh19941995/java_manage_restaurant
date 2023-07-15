package dao;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public interface DAOInterface <T, U>{

    public boolean insert(T t);
    public int update(int id,U u);
    public ArrayList<T> getAll();
    public T getById(int t);


}
