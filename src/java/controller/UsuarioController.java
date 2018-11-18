package controller;

import java.util.Iterator;
import java.util.List;
import model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class UsuarioController {
    public void setUsuario(Usuario usuario){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(usuario);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public Usuario getUsuario(String correo){
        Usuario usuario = new Usuario();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            usuario = (Usuario) session.get(Usuario.class, correo);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return usuario;
        
    }
    
    public List getAllUsuario(){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from Usuario").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public void deleteUsuario(Usuario usuario){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllUsuario(){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List usuarios = getAllUsuario();
            for (Iterator it = usuarios.iterator(); it.hasNext();) {
                Usuario usuario =(Usuario)it.next();
                session.delete(usuario);
                session.getTransaction().commit();
            }
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public boolean existsUsuario(Usuario usuario){
        boolean flag = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            flag = !(session.createQuery("from Usuario where correo ='"+usuario.getCorreo()+"'").list().isEmpty());
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return flag;
    }
    
    public boolean existsUsuario(String correo){
        boolean flag = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            flag = !(session.createQuery("from Usuario where correo ='"+correo+"'").list().isEmpty());
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return flag;
    }
}
