package dao;

import model.MenuNameEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class MenuNameEntityDAO implements DAOInterface<MenuNameEntity,MenuNameEntity>{
    public static MenuNameEntityDAO getInstance(){
        return new MenuNameEntityDAO();
    }

    @Override
    public boolean insert(MenuNameEntity menuName) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(menuName);
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
    public int update(int id, MenuNameEntity newObject) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            MenuNameEntity oldObject = session.get(MenuNameEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setName(newObject.getName());
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
        ArrayList<MenuNameEntity> menuNames = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM MenuNameEntity";
            Query<MenuNameEntity> query = session.createQuery(hql, MenuNameEntity.class);
            menuNames = (ArrayList<MenuNameEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return menuNames;
    }

    @Override
    public MenuNameEntity getById(int menuNameIndex) {
        Session session = null;
        MenuNameEntity menuName = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            menuName = session.get(MenuNameEntity.class, menuNameIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return menuName;
    }
}
