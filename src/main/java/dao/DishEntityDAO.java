package dao;

import model.BookingsInfoEntity;
import model.DishEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class DishEntityDAO implements DAOInterface<DishEntity,DishEntity>{
    public static DishEntityDAO getInstance(){
        return new DishEntityDAO();
    }
    @Override
    public boolean insert(DishEntity Dish) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(Dish);
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
    public int update(int id, DishEntity newObject) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            DishEntity oldObject = session.get(DishEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setDishName(newObject.getDishName());
            oldObject.setDateCreat(newObject.getDateCreat());
            oldObject.setPrice(newObject.getPrice());
            oldObject.setDateUpdate(newObject.getDateUpdate());
            oldObject.setDishTypeId(newObject.getDishTypeId());
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
        ArrayList<DishEntity> dishs = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM DishEntity";
            Query<DishEntity> query = session.createQuery(hql, DishEntity.class);
            dishs = (ArrayList<DishEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return dishs;
    }

    @Override
    public DishEntity getById(int dishIndex) {
        Session session = null;
        DishEntity dish = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            dish = session.get(DishEntity.class, dishIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return dish;
    }
}
