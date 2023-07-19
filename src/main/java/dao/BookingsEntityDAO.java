package dao;

import model.BookingsEntity;
import model.TransactionsTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class BookingsEntityDAO implements DAOInterface <BookingsEntity, BookingsEntity>{
    public static BookingsEntityDAO getInstance(){
        return new BookingsEntityDAO();
    }
    @Override
    public boolean insert(BookingsEntity Booking) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(Booking);
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
    public int update(int Id, BookingsEntity newBooking) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            BookingsEntity oldObject = session.get(BookingsEntity.class, Id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();
            oldObject.setInfoId(newBooking.getInfoId());
            oldObject.setTableId(newBooking.getTableId());
            oldObject.setMenuNameId(newBooking.getMenuNameId());
            oldObject.setFlag(newBooking.getFlag());
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
        ArrayList<BookingsEntity> bookingsEntities = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM BookingsEntity";
            Query<BookingsEntity> query = session.createQuery(hql, BookingsEntity.class);
            bookingsEntities = (ArrayList<BookingsEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return bookingsEntities;
    }

    @Override
    public BookingsEntity getById(int indexBooking) {
        Session session = null;
        BookingsEntity booking = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            booking = session.get(BookingsEntity.class, indexBooking);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return booking;
    }
}
