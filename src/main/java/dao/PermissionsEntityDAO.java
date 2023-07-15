package dao;

import model.MenuNameEntity;
import model.PermissionsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class PermissionsEntityDAO implements DAOInterface<PermissionsEntity,PermissionsEntity>{
    public static PermissionsEntityDAO getInstance(){
        return new PermissionsEntityDAO();
    }

    @Override
    public boolean insert(PermissionsEntity permission) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(permission);
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
    public int update(int id, PermissionsEntity newObject) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            PermissionsEntity oldObject = session.get(PermissionsEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setPermissionName(newObject.getPermissionName());
            oldObject.setDateCreat(newObject.getDateCreat());
            oldObject.setDateUpdate(newObject.getDateUpdate());
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
        ArrayList<PermissionsEntity> permissions = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM PermissionsEntity";
            Query<PermissionsEntity> query = session.createQuery(hql, PermissionsEntity.class);
            permissions = (ArrayList<PermissionsEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return permissions;
    }

    @Override
    public PermissionsEntity getById(int permissionIndex) {
        Session session = null;
        PermissionsEntity permission = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            permission = session.get(PermissionsEntity.class, permissionIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return permission;
    }
}
