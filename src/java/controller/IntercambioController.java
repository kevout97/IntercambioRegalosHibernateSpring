package controller;

import java.util.List;
import model.Intercambio;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class IntercambioController {
    public void setIntercambio(Intercambio intercambio){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(intercambio);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public void updateIntercambio(Intercambio intercambio){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(intercambio);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public Intercambio getIntercambio(int idIntercambio){
        Intercambio intercambio = new Intercambio();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            intercambio = (Intercambio) session.get(Intercambio.class, idIntercambio);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return intercambio;
        
    }
    
    public List getAllIntercambio(){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from Intercambio").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
}
