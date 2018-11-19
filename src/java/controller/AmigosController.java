package controller;

import java.util.Iterator;
import java.util.List;
import model.Amigos;
import model.AmigosId;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class AmigosController {
    public void setAmigos(Amigos amigos){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(amigos);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public Amigos getAmigos(AmigosId amigosId){
        Amigos amigos = new Amigos();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            amigos = (Amigos) (session.get(Amigos.class,amigosId));
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return amigos;
        
    }
    
    public List getAllAmigos(){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from Amigos").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public List getAllAmigosByEmail(String correo){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from Amigos where correo_usuario='"+correo+"'").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public void deleteAmigos(Amigos amigos){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(amigos);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllAmigos(){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List amigosId = getAllAmigos();
            for (Iterator it = amigosId.iterator(); it.hasNext();) {
                AmigosId amigo =(AmigosId)it.next();
                session.delete(amigo);
                session.getTransaction().commit();
            }
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public boolean existsAmigos(Amigos amigos){
        boolean flag = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            flag = !(session.createQuery("from Usuario where correo_usuario ='"+amigos.getId().getCorreoUsuario()+"' and correo_amigo = '"+amigos.getId().getCorreoAmigo()+"'").list().isEmpty());
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return flag;
    }
}
