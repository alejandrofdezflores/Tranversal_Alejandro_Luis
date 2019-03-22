package com.example.controller.DAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.HibernateUtil;
import com.example.model.Clase;

public class ClaseDao {
	public static void saveClase(Clase clase) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(clase);
            transaction.commit();
            System.out.println("clase insertada");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void deleteClase(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Clase clase = session.get(Clase.class, id);
            if (clase != null) {
                session.delete(clase);
                System.out.println("clase is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void updateClase(Clase clase) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(clase);
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
    public static List<Clase> getAllClases() {
        Transaction transaction = null;
        List<Clase> listOfClase = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfClase = session.createQuery("from Clase").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfClase;
    }
    
    public static List<Clase> getAllClasesOrderByNombre() {
        Transaction transaction = null;
        List<Clase> listOfClase = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfClase = session.createQuery("from Clase order by nombre").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfClase;
    }
    
    public static Clase buscarClaseById(int id) {
        Transaction transaction = null;
        Clase clase = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {   
            clase = session.get(Clase.class, id);
            return clase;
        } catch (Exception e) {
            System.out.println("Error: la transacción no ha sido posible");
            }     
		return clase;
    }
}
