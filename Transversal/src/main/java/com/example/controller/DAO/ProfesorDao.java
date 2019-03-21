package com.example.controller.DAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.HibernateUtil;
import com.example.model.Profesor;

public class ProfesorDao {
	public static void saveProfesor(Profesor profesor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(profesor);
            transaction.commit();
            System.out.println("profesor insertado");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void deleteProfesor(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Profesor profesor = session.get(Profesor.class, id);
            if (profesor != null) {
                session.delete(profesor);
                System.out.println("profesor is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateProfesor(Profesor profesor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(profesor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get all Instructors
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Profesor> getAllProfesor() {
        Transaction transaction = null;
        List<Profesor> listOfProfesor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfProfesor = session.createQuery("from Profesor").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfProfesor;
    }
}
