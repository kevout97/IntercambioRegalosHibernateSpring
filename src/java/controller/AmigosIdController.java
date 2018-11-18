package controller;

import java.util.List;
import model.AmigosId;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class AmigosIdController {
    public void setAmigosId(AmigosId amigos){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(amigos);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public void updateAmigosId(AmigosId amigos){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(amigos);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public AmigosId getAmigosId(String correoUsuario){
        AmigosId amigosId = new AmigosId();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            amigosId = (AmigosId) session.get(AmigosId.class, correoUsuario);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return amigosId;
        
    }
    
    public List getAllAmigosId(){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from AmigosId").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
}
