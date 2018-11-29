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
    private Session session;
    public UsuarioController(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public void setUsuario(Usuario usuario){
        try {
            
            session.beginTransaction();
            session.saveOrUpdate(usuario);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        
    }
    
    public Usuario getUsuario(String correo){
        Usuario usuario = new Usuario();
        try {
            
            session.beginTransaction();
            usuario = (Usuario) session.get(Usuario.class, correo);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return usuario;
        
    }
    
    public Usuario getUsuario(String correo, String contrasenia){
        Usuario usuario = new Usuario();
        try {
            
            session.beginTransaction();
            usuario = (Usuario) session.createQuery("from Usuario u where u.correo ='"+correo+"' and u.contrasenia = '"+contrasenia+"'").list().get(0);
            session.getTransaction().commit();
            //
        } catch (HibernateException e) {
        }
        return usuario;
    }
    
    public List getAllUsuario(){
        List result = null;
        try {
            
            session.beginTransaction();
            result = session.createQuery("from Usuario").list();
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public void deleteUsuario(Usuario usuario){
        try {
            
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllUsuario(){
        try {
            
            session.beginTransaction();
            List usuarios = getAllUsuario();
            for (Iterator it = usuarios.iterator(); it.hasNext();) {
                Usuario usuario =(Usuario)it.next();
                session.delete(usuario);
                session.getTransaction().commit();
            }
            
        } catch (HibernateException e) {
        }
    }
    
    public boolean existsUsuario(Usuario usuario){
        boolean flag = false;
        try {
            
            session.beginTransaction();
            flag = !(session.createQuery("from Usuario u where u.correo ='"+usuario.getCorreo()+"'").list().isEmpty());
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return flag;
    }
    
    public boolean existsUsuario(String correo){
        boolean flag = false;
        try {
            
            session.beginTransaction();
            flag = !(session.createQuery("from Usuario where correo ='"+correo+"'").list().isEmpty());
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return flag;
    }
    
    public boolean existsUsuario(String correo, String contrasenia){
        boolean flag = false;
        try {
            
            session.beginTransaction();
            flag = !(session.createQuery("from Usuario u where u.correo ='"+correo+"' and u.contrasenia = '"+contrasenia+"'").list().isEmpty());
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
