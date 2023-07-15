package dao;

import model.DishEntity;
import model.DishTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class DishTypeEntityDAO implements DAOInterface<DishTypeEntity,DishTypeEntity>{
    public static DishTypeEntityDAO getInstance(){
        return new DishTypeEntityDAO();
    }

    @Override
    public boolean insert(DishTypeEntity dishType) {
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
    public int update(int id, DishTypeEntity newObject) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            DishTypeEntity oldObject = session.get(DishTypeEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setType(newObject.getType());
            oldObject.setFlag(newObject.getFlag());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
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
    public DishTypeEntity getById(int dishTypeIndex) {
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
