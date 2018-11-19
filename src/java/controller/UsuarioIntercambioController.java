package controller;

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
    public void setUsuarioIntercambio(UsuarioIntercambio usuarioIntercambio){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(usuarioIntercambio);
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
    
    public List getAllUsuarioIntercambioByEmail(String correo){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from UsuarioIntercambio where id_usuario = '"+correo+"'").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public List getAllMisIntercambios(String correo){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("select i.id, i.nombre, t.nombreTema, i.monto_maximo, i.fecha_limite, i.fecha_intercambio, i.comentarios, (select us.nombre from Usuario us where us.correo = ui.id_intercambiar) as intercambiar"
                                       + "from Intercambio i, UsuarioIntercambio ui, Tema t where ui.id_intercambio = i.id"
                                        +" and ui.id_usuario = '"+correo+"' and t.id = i.id_tema").list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public List getAllUsuarioIntercambioByIdIntercambio(int id_intercambio){
        List result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.createQuery("from UsuarioIntercambio where id_intercambio = "+id_intercambio).list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
        return result;
    }
    
    public void deleteUsuarioItercambio(UsuarioIntercambio usuarioIntercambio){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuarioIntercambio);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
        }
    }
    
    public void deleteAllUsuarioIntercambio(){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List usuariosIntercambios = getAllUsuarioIntercambio();
            for (Iterator it = usuariosIntercambios.iterator(); it.hasNext();) {
                UsuarioIntercambio usuarioIntercambio =(UsuarioIntercambio)it.next();
                session.delete(usuarioIntercambio);
                session.getTransaction().commit();
            }
            session.close();
        } catch (HibernateException e) {
        }
    }
}
