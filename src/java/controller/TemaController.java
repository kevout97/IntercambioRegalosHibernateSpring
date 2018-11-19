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
    public List getAllTema(){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from Tema").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public Tema getTemaByNombre(String nombre){
        Tema tema = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            tema = (Tema)session.createQuery("from Tema where nombre_tema='"+nombre+"'").list().get(0);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return tema;
    }
}
