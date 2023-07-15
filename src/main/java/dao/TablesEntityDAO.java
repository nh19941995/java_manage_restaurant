package dao;

import model.SalariesEntity;
import model.TablesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class TablesEntityDAO implements DAOInterface <TablesEntity,TablesEntity>{
    public static TablesEntityDAO getInstance(){
        return new TablesEntityDAO();
    }

    @Override
    public boolean insert(TablesEntity table) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(table);
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
    public int update(int id, TablesEntity table) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            TablesEntity oldObject = session.get(TablesEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setSeatingCapacity(table.getSeatingCapacity());
            oldObject.setType(table.getType());
            oldObject.setFlag(table.getFlag());

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
    public ArrayList<TablesEntity> getAll() {
        ArrayList<TablesEntity> tables = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM TablesEntity";
            Query<TablesEntity> query = session.createQuery(hql, TablesEntity.class);
            tables = (ArrayList<TablesEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return tables;
    }

    @Override
    public TablesEntity getById(int tableIndex) {
        Session session = null;
        TablesEntity table = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            table = session.get(TablesEntity.class, tableIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return table;
    }
}
