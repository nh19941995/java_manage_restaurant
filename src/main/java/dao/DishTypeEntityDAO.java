package dao;

import model.DishEntity;
import model.DishTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class DishTypeEntityDAO implements DAOInterface{
    public static DishTypeEntityDAO getInstance(){
        return new DishTypeEntityDAO();
    }

    @Override
    public boolean insert(Object dishType) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(dishType);
            session.getTransaction().commit();
            System.out.println("Done!");
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace(); // In thông tin ngoại lệ (có thể thay thế bằng xử lý thông báo lỗi khác)
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public int update(Object o, Object o2) {
        return 0;
    }

    @Override
    public ArrayList getAll() {
        ArrayList<DishTypeEntity> dishsType = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM DishTypeEntity";
            Query<DishTypeEntity> query = session.createQuery(hql, DishTypeEntity.class);
            dishsType = (ArrayList<DishTypeEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return dishsType;
    }

    @Override
    public Object getById(int dishTypeIndex) {
        Session session = null;
        DishTypeEntity dishType = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            dishType = session.get(DishTypeEntity.class, dishTypeIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return dishType;
    }
}
