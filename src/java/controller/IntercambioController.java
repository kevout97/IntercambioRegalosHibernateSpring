package controller;

import java.util.Iterator;
import java.util.List;
import model.Intercambio;
import model.Usuario;
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
            session.saveOrUpdate(intercambio);
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
    
    public void deleteIntercambio(Intercambio intercambio){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(intercambio);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllIntercambio(){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List intercambios = getAllIntercambio();
            for (Iterator it = intercambios.iterator(); it.hasNext();) {
                Intercambio intercambio =(Intercambio)it.next();
                session.delete(intercambio);
                session.getTransaction().commit();
            }
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public boolean existsIntercambio(Intercambio intercambio){
        boolean flag = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            flag = !(session.createQuery("from Intercambio where id ="+intercambio.getId()).list().isEmpty());
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return flag;
    }
    
    public boolean existsIntercambio(int id){
        boolean flag = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            flag = !(session.createQuery("from Intercambio where id ="+id).list().isEmpty());
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return flag;
    }
    
}
