package controller.view;

import controller.AmigosController;
import model.Amigos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCAmigos extends AmigosController{//Altas, Bajas y Cambios de amigos
    @RequestMapping("/altaAmigosId")
    public ModelAndView altaAmigos(Amigos amigos){
        ModelAndView model = new ModelAndView("listaAmigos");
        setAmigos(amigos);
        model.addObject(amigos);
        return model;
    }
    
    @RequestMapping("/bajaAmigosId")
    public ModelAndView bajaAmigosId(Amigos amigos){
        ModelAndView model = new ModelAndView("listaAmigos");
        deleteAmigos(amigos);
        model.addObject(amigos);
        return model;
    }
    
    @RequestMapping("/cambioAmigosId")
    public ModelAndView cambioAmigos(Amigos amigos){
        ModelAndView model = new ModelAndView("listaAmigos");
        setAmigos(amigos);
        model.addObject(amigos);
        return model;
    }
    
}
