package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.UsuarioIntercambio;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class UsuarioIntercambioController {
    private Session session;
    public UsuarioIntercambioController(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }
    public void setUsuarioIntercambio(UsuarioIntercambio usuarioIntercambio){
        try {
            
            
            session.saveOrUpdate(usuarioIntercambio);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        
    }
    
    public void updateUsuarioIntercambio(UsuarioIntercambio usuarioIntercambio){
        try {
            
            session.update(usuarioIntercambio);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        
    }
    
    public UsuarioIntercambio getUsuarioIntercambio(String correoUsuario,int idIntercambio){
        UsuarioIntercambio usuarioIntercambio = new UsuarioIntercambio();
        try {
            
            usuarioIntercambio = (UsuarioIntercambio) session.createQuery("from UsuarioIntercambio where id_usuario = '"+correoUsuario+"' and id_intercambio = "+idIntercambio).list().get(0);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return usuarioIntercambio;
        
    }
    
    public List getAllUsuarioIntercambio(){
        List result = null;
        try {
            
            result = session.createQuery("from UsuarioIntercambio").list();
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public List getAllUsuarioIntercambioByEmail(String correo){
        List result = null;
        try {
            
            result = session.createQuery("from UsuarioIntercambio where id_usuario = '"+correo+"'").list();
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public List getAllMisIntercambios(String correo){
        List result = null;
        try {
            
            result = session.createQuery("from UsuarioIntercambio where id_usuario = '"+correo+"'").list();
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public List getAllUsuarioIntercambioByIdIntercambio(int id_intercambio){
        List result = null;
        try {
            result = session.createQuery("from UsuarioIntercambio where id_intercambio = "+id_intercambio).list();
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public void deleteUsuarioItercambio(UsuarioIntercambio usuarioIntercambio){
        try {
            
            session.delete(usuarioIntercambio);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllUsuarioIntercambio(){
        try {
            
            List usuariosIntercambios = getAllUsuarioIntercambio();
            for (Iterator it = usuariosIntercambios.iterator(); it.hasNext();) {
                UsuarioIntercambio usuarioIntercambio =(UsuarioIntercambio)it.next();
                session.delete(usuarioIntercambio);
                session.getTransaction().commit();
            }
            
        } catch (HibernateException e) {
        }
    }
    
    public void closeSession(){
        try {
            session.close();
        } catch (HibernateException e) {
        }
    }
}
