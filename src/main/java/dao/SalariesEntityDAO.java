package dao;

import model.PersonsEntity;
import model.SalariesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class SalariesEntityDAO implements DAOInterface<SalariesEntity,SalariesEntity>{
    public static SalariesEntityDAO getInstance(){
        return new SalariesEntityDAO();
    }

    @Override
    public boolean insert(SalariesEntity salary) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(salary);
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
    public int update(int id, SalariesEntity salary) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            SalariesEntity oldObject = session.get(SalariesEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setPersonId(salary.getPersonId());
            oldObject.setSalaryAmount(salary.getSalaryAmount());
            oldObject.setEffectiveDate(salary.getEffectiveDate());
            oldObject.setFlag(salary.getFlag());

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
    public ArrayList<SalariesEntity> getAll() {
        ArrayList<SalariesEntity> salaries = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM SalariesEntity";
            Query<SalariesEntity> query = session.createQuery(hql, SalariesEntity.class);
            salaries = (ArrayList<SalariesEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return salaries;
    }

    @Override
    public SalariesEntity getById(int salaryIndex) {
        Session session = null;
        SalariesEntity salary = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            salary = session.get(SalariesEntity.class, salaryIndex);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return salary;
    }
}
