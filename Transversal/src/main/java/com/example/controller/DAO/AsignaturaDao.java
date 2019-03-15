package com.example.controller.DAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.HibernateUtil;
import com.example.model.Asignatura;

public class AsignaturaDao {
	public void saveAsignatura(Asignatura asignatura) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(asignatura);
            transaction.commit();
            System.out.println("Asignatura insertada");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAsignatura(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Asignatura asignatura = session.get(Asignatura.class, id);
            if (asignatura != null) {
                session.delete(asignatura);
                System.out.println("Asignatura is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateAsignatura(Asignatura asignatura) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(asignatura);
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
    public static List<Asignatura> getAllAsignaturas() {
        Transaction transaction = null;
        List<Asignatura> listOfAsignatura = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfAsignatura = session.createQuery("from Asignatura").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfAsignatura;
    }
}
