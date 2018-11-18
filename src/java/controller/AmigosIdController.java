package controller;

import java.util.Iterator;
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
            session.saveOrUpdate(amigos);
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
    
    public void deleteAmigosId(AmigosId amigos){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(amigos);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllAmigosId(){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List amigosId = getAllAmigosId();
            for (Iterator it = amigosId.iterator(); it.hasNext();) {
                AmigosId amigo =(AmigosId)it.next();
                session.delete(amigo);
                session.getTransaction().commit();
            }
            session.close();
        } catch (HibernateException e) {
        }
    }
}
