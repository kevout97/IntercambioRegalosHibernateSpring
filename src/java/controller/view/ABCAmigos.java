package controller.view;

import controller.AmigosController;
import java.util.Iterator;
import java.util.List;
import model.Amigos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCAmigos extends AmigosController{//Altas, Bajas y Cambios de amigos
    @RequestMapping("altaAmigos")
    public ModelAndView altaAmigos(Amigos amigos){
        ModelAndView model = new ModelAndView("listaAmigos");
        for(Iterator it = getAllAmigosByEmail(amigos.getId().getCorreoUsuario()).iterator();it.hasNext();){
            model.addObject((Amigos)it.next());
        }
        return model;
    }
    
    @RequestMapping("bajaAmigos")
    public ModelAndView bajaAmigos(Amigos amigos){
        ModelAndView model = new ModelAndView("listaAmigos");
        deleteAmigos(amigos);
        for(Iterator it = getAllAmigosByEmail(amigos.getId().getCorreoUsuario()).iterator();it.hasNext();){
            model.addObject((Amigos)it.next());
        }
        return model;
    }
    
    @RequestMapping("cambioAmigos")
    public ModelAndView cambioAmigos(Amigos amigos){
        ModelAndView model = new ModelAndView("listaAmigos");
        setAmigos(amigos);
        for(Iterator it = getAllAmigosByEmail(amigos.getId().getCorreoUsuario()).iterator();it.hasNext();){
            model.addObject((Amigos)it.next());
        }
        return model;
    }
    
}
