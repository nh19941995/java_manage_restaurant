package dao;

import model.TransactionsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public int update(int id, TransactionsEntity transactionsEntity) {
        return 0;
    }

    @Override
    public ArrayList<TransactionsEntity> getAll() {
        return null;
    }

    @Override
    public TransactionsEntity getById(int t) {
        return null;
    }
}
