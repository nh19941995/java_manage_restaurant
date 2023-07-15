package dao;

import model.TableTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class TableTypeEntityDAO implements DAOInterface <TableTypeEntity,TableTypeEntity>{
    public static TableTypeEntityDAO getInstance(){
        return new TableTypeEntityDAO();
    }

    @Override
    public boolean insert(TableTypeEntity tableType) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(tableType);
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
    public int update(int id, TableTypeEntity tableType) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            TableTypeEntity oldObject = session.get(TableTypeEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setName(tableType.getName());
            oldObject.setComment(tableType.getComment());
            oldObject.setFlag(tableType.getFlag());

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
    public ArrayList<TableTypeEntity> getAll() {
        ArrayList<TableTypeEntity> tableType = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM TableTypeEntity";
            Query<TableTypeEntity> query = session.createQuery(hql, TableTypeEntity.class);
            tableType = (ArrayList<TableTypeEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return tableType;
    }

    @Override
    public TableTypeEntity getById(int tableTypeIndex) {
        Session session = null;
        TableTypeEntity tableType = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tableType = session.get(TableTypeEntity.class, tableTypeIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tableType;
    }
}
