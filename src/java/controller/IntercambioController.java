package controller;

import java.util.Iterator;
import java.util.List;
import model.Intercambio;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class IntercambioController {
    private Session session;
    public IntercambioController(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public void setIntercambio(Intercambio intercambio){
        try {
            
            session.beginTransaction();
            session.saveOrUpdate(intercambio);
            session.getTransaction().commit();

        } catch (HibernateException e) {
        }
        
    }
    
    public Intercambio getIntercambio(int idIntercambio){
        Intercambio intercambio = new Intercambio();
        try {
            
            session.beginTransaction();
            intercambio = (Intercambio) session.get(Intercambio.class, idIntercambio);
            session.getTransaction().commit();

        } catch (HibernateException e) {
        }
        return intercambio;
        
    }
    
    public List getAllIntercambio(){
        List result = null;
        try {
            
            session.beginTransaction();
            result = session.createQuery("from Intercambio").list();
            session.getTransaction().commit();

        } catch (HibernateException e) {
        }
        return result;
    }
    
    public void deleteIntercambio(Intercambio intercambio){
        try {
            
            session.beginTransaction();
            session.delete(intercambio);
            session.getTransaction().commit();

        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllIntercambio(){
        try {
            
            session.beginTransaction();
            List intercambios = getAllIntercambio();
            for (Iterator it = intercambios.iterator(); it.hasNext();) {
                Intercambio intercambio =(Intercambio)it.next();
                session.delete(intercambio);
                session.getTransaction().commit();
            }
            //
        } catch (HibernateException e) {
        }
    }
    
    public boolean existsIntercambio(Intercambio intercambio){
        boolean flag = false;
        try {
            
            session.beginTransaction();
            flag = !(session.createQuery("from Intercambio where id ="+intercambio.getId()).list().isEmpty());
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return flag;
    }
    
    public boolean existsIntercambio(int id){
        boolean flag = false;
        try {
            
            session.beginTransaction();
            flag = !(session.createQuery("from Intercambio where id ="+id).list().isEmpty());
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return flag;
    }
    
    public void closeSession(){
        try {
            
        } catch (HibernateException e) {
        }
    }
    
}
