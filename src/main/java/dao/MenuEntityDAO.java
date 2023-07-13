package dao;

import model.DishTypeEntity;
import model.MenuEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class MenuEntityDAO implements DAOInterface{
    public static MenuEntityDAO getInstance(){
        return new MenuEntityDAO();
    }

    @Override
    public boolean insert(Object menu) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(menu);
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
        ArrayList<MenuEntity> menus = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM MenuEntity";
            Query<MenuEntity> query = session.createQuery(hql, MenuEntity.class);
            menus = (ArrayList<MenuEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return menus;
    }

    @Override
    public Object getById(int menuIndex) {
        Session session = null;
        MenuEntity menu = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            menu = session.get(MenuEntity.class, menuIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return menu;
    }
}
