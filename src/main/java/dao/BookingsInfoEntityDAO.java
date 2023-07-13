package dao;

import model.BookingsEntity;
import model.BookingsInfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class BookingsInfoEntityDAO implements DAOInterface{
    public static BookingsInfoEntityDAO getInstance(){
        return new BookingsInfoEntityDAO();
    }
    @Override
    public boolean insert(Object bookingInfo) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(bookingInfo);
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
        ArrayList<BookingsInfoEntity> bookingInfos = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM BookingsInfoEntity";
            Query<BookingsInfoEntity> query = session.createQuery(hql, BookingsInfoEntity.class);
            bookingInfos = (ArrayList<BookingsInfoEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return bookingInfos;
    }

    @Override
    public Object getById(int indexBookingInfo) {
        Session session = null;
        BookingsInfoEntity bookingInfo = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            bookingInfo = session.get(BookingsInfoEntity.class, indexBookingInfo);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bookingInfo;
    }
}
