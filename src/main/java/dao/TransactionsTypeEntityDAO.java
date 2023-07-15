package dao;

import model.PermissionsEntity;
import model.TransactionsTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class TransactionsTypeEntityDAO implements DAOInterface<TransactionsTypeEntity,TransactionsTypeEntity>{

    public static TransactionsTypeEntityDAO getInstance(){
        return new TransactionsTypeEntityDAO();
    }

    @Override
    public boolean insert(TransactionsTypeEntity type) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(type);
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
    public int update(int id, TransactionsTypeEntity newObject) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            TransactionsTypeEntity oldObject = session.get(TransactionsTypeEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setType(newObject.getType());
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
    public ArrayList<TransactionsTypeEntity> getAll() {
        ArrayList<TransactionsTypeEntity> types = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM TransactionsTypeEntity";
            Query<TransactionsTypeEntity> query = session.createQuery(hql, TransactionsTypeEntity.class);
            types = (ArrayList<TransactionsTypeEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return types;
    }

    @Override
    public TransactionsTypeEntity getById(int typeID) {
        Session session = null;
        TransactionsTypeEntity type = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            type = session.get(TransactionsTypeEntity.class, typeID);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return type;
    }

}

