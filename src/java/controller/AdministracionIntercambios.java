package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.UsuarioIntercambio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class AdministracionIntercambios extends UsuarioIntercambioController{//Esta clase se emparejar a los usuarios en cada intercambio
    
    @RequestMapping("agregarUsuario")
    public ModelAndView agregarUsuario(@RequestParam("idIntercambio")Integer idIntercambio,@RequestParam("correo")String correo){//Este metodo agrega un usuario a un intercambio y los revuelve nuevamente
        
        UsuarioIntercambio ui = new UsuarioIntercambio(new IntercambioController().getIntercambio(idIntercambio),
                                                        new UsuarioController().getUsuario(correo),
                                                        true,
                                                        correo,
                                                        false);
        setUsuarioIntercambio(ui);
        List usuariosIntercambiosOld = getAllUsuarioIntercambioByIdIntercambio(idIntercambio);
        List usuariosIntercambiosNew = getAllUsuarioIntercambioByIdIntercambio(idIntercambio);
        int random = (int)(Math.random() * (usuariosIntercambiosOld.size()-1))+1;
        for (int k = 0; k < usuariosIntercambiosOld.size() ; k++) {
            System.out.println("Usuario Old -->"+((UsuarioIntercambio)usuariosIntercambiosOld.get(k)).getUsuario().getCorreo());
            System.out.println("Intercambiar Old --> "+((UsuarioIntercambio)usuariosIntercambiosOld.get(k)).getIdIntercambiar());
        }
        for (int i = 0; i < usuariosIntercambiosOld.size(); i++) {
            if (random >= usuariosIntercambiosOld.size()) {
                random = 0;
            }
            ((UsuarioIntercambio)usuariosIntercambiosNew.get(i)).setIdIntercambiar(((UsuarioIntercambio)usuariosIntercambiosOld.get(random)).getUsuario().getCorreo());
            random ++;
        }
        
        for (Iterator it = usuariosIntercambiosNew.iterator(); it.hasNext();) {
            setUsuarioIntercambio((UsuarioIntercambio)it.next());
            
        }
        ModelAndView mav = new ModelAndView("listaIntercambios");
        mav.addObject("correo",correo);
        mav.addObject("usuarios",new UsuarioController().getAllUsuario());
        mav.addObject("usuarioIntercambios", new UsuarioIntercambioController().getAllMisIntercambios(correo));
        mav.addObject("temas", new TemaController().getAllTema());
        mav.addObject("intercambios",new IntercambioController().getAllIntercambio());
        return mav;
        
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
