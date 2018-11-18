package controller;

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
            session.save(usuario);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public void updateUsuario(Usuario usuario){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(usuario);
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
    
}
