package controller;

import java.util.List;
import model.Tema;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class TemaController {
    private Session session;
    public TemaController(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public List getAllTema(){
        List result = null;
        try {
            
            session.beginTransaction();
            result = session.createQuery("from Tema").list();
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public Tema getTemaByNombre(String nombre){
        Tema tema = null;
        try {
            
            session.beginTransaction();
            tema = (Tema)session.createQuery("from Tema where nombre_tema='"+nombre+"'").list().get(0);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return tema;
    }
    public void closeSession(){
        try {
            
        } catch (HibernateException e) {
        }
    }
}
