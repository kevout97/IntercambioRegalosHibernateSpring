package controller;

import java.util.List;
import model.UsuarioIntercambio;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author kevout
 */
public class UsuarioIntercambioController {
    public void setUsuarioIntercambio(UsuarioIntercambio usuarioIntercambio){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuarioIntercambio);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public void updateUsuarioIntercambio(UsuarioIntercambio usuarioIntercambio){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(usuarioIntercambio);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        
    }
    
    public UsuarioIntercambio getUsuarioIntercambio(String correoUsuario,int idIntercambio){
        UsuarioIntercambio usuarioIntercambio = new UsuarioIntercambio();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            usuarioIntercambio = (UsuarioIntercambio) session.createSQLQuery("from UsuarioIntercambio where id_usuario = '"+correoUsuario+"' and id_intercambio = "+idIntercambio).list().get(0);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return usuarioIntercambio;
        
    }
    
    public List getAllUsuarioIntercambio(){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from UsuarioIntercambio").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
}
