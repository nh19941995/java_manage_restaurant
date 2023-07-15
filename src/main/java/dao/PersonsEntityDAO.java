package dao;

import model.PermissionsEntity;
import model.PersonsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;

public class PersonsEntityDAO implements DAOInterface<PersonsEntity,PersonsEntity>{
    public static PersonsEntityDAO getInstance(){
        return new PersonsEntityDAO();
    }
    @Override
    public boolean insert(PersonsEntity person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(person);
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
    public int update(int id, PersonsEntity person) {
        Session session = null;
        try {
//            lấy ra qua id
            session = HibernateUtil.getSessionFactory().openSession();
            PersonsEntity oldObject = session.get(PersonsEntity.class, id);
//            gán thay đổi
            Transaction tx = session.beginTransaction();

            oldObject.setName(person.getName());
            oldObject.setDateOfBirth(person.getDateOfBirth());
            oldObject.setAddress(person.getAddress());
            oldObject.setUsername(person.getUsername());
            oldObject.setPassword(person.getPassword());
            oldObject.setPermission(person.getPermission());
            oldObject.setEmail(person.getEmail());
            oldObject.setDateCreat(person.getDateCreat());
            oldObject.setDateUpdate(person.getDateUpdate());
            oldObject.setFlag(person.getFlag());

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
    public ArrayList<PersonsEntity> getAll() {
        ArrayList<PersonsEntity> Persons = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            final String hql = "FROM PersonsEntity";
            Query<PersonsEntity> query = session.createQuery(hql, PersonsEntity.class);
            Persons = (ArrayList<PersonsEntity>) query.list();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return Persons;
    }

    @Override
    public PersonsEntity getById(int index) {
        Session session = null;
        PersonsEntity person = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            person = session.get(PersonsEntity.class, index);
        } catch (Exception e) {
            e.printStackTrace(); // In thông tin ngoại lệ
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi xử lý ngoại lệ
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return person;
    }
}
