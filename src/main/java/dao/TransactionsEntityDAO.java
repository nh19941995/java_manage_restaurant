package dao;

import model.TableTypeEntity;
import model.TransactionsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class TransactionsEntityDAO implements DAOInterface<TransactionsEntity,TransactionsEntity> {
    public static TransactionsEntityDAO getInstance(){
        return new TransactionsEntityDAO();
    }

    @Override
    public boolean insert(TransactionsEntity transaction) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(transaction);
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
    public int update(int id, TransactionsEntity transactions) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            TransactionsEntity oldObject = session.get(TransactionsEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setPersonId(transactions.getPersonId());
            oldObject.setType(transactions.getType());
            oldObject.setQuantity(transactions.getQuantity());
            oldObject.setComment(transactions.getComment());
            oldObject.setDateCreat(transactions.getDateCreat());
            oldObject.setDateUpdate(transactions.getDateUpdate());
            oldObject.setFlag(transactions.getFlag());

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
    public ArrayList<TransactionsEntity> getAll() {
        ArrayList<TransactionsEntity> transactions = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM TransactionsEntity";
            Query<TransactionsEntity> query = session.createQuery(hql, TransactionsEntity.class);
            transactions = (ArrayList<TransactionsEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return transactions;
    }

    @Override
    public TransactionsEntity getById(int transactionIndex) {
        Session session = null;
        TransactionsEntity transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.get(TransactionsEntity.class, transactionIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return transaction;
    }
}
