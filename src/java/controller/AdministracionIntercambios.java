package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.UsuarioIntercambio;

/**
 *
 * @author kevout
 */
public class AdministracionIntercambios extends UsuarioIntercambioController{//Esta clase se emparejar a los usuarios en cada intercambio
    
    public void agregarUsuario(int idIntercambio,String correo){//Este metodo agrega un usuario a un intercambio y los revuelve nuevamente
        UsuarioIntercambio ui = new UsuarioIntercambio(new IntercambioController().getIntercambio(idIntercambio),
                                                        new UsuarioController().getUsuario(correo),
                                                        true,
                                                        correo,
                                                        false);
        setUsuarioIntercambio(ui);
        List usuariosIntercambiosOld = getAllUsuarioIntercambioByIdIntercambio(idIntercambio);
        List usuariosIntercambiosNew = new ArrayList();
        int random = (int)(Math.random() * (usuariosIntercambiosOld.size()-1));
        int i = 0;
        do{
            if(random == usuariosIntercambiosOld.size()){
                UsuarioIntercambio uit = (UsuarioIntercambio) usuariosIntercambiosOld.get(random);
                uit.setIdIntercambiar(((UsuarioIntercambio) usuariosIntercambiosOld.get(i)).getUsuario().getCorreo());
                usuariosIntercambiosNew.add(uit);
                random = 0;
            }else{
                UsuarioIntercambio uit = (UsuarioIntercambio) usuariosIntercambiosOld.get(random);
                uit.setIdIntercambiar(((UsuarioIntercambio) usuariosIntercambiosOld.get(i)).getUsuario().getCorreo());
                usuariosIntercambiosNew.add(uit);
                random ++;
            }
            i++;
        }while(i<usuariosIntercambiosOld.size());
        
        for (Iterator it = usuariosIntercambiosNew.iterator(); it.hasNext();) {
            setUsuarioIntercambio((UsuarioIntercambio)it.next());
            
        }
        
    }
    
    public void iniciarIntercambio(int idIntercambio,String correo){//Este metodo inicializa el intercambio
        UsuarioIntercambio ui = new UsuarioIntercambio(new IntercambioController().getIntercambio(idIntercambio),
                                                        new UsuarioController().getUsuario(correo),
                                                        true,
                                                        correo,
                                                        true);
        setUsuarioIntercambio(ui);        
    }
    
}
