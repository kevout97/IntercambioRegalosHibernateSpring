package controller.view;

import controller.AmigosController;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import model.Amigos;
import model.AmigosId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */

public class ABCAmigos {//Altas, Bajas y Cambios de amigos
    
    @RequestMapping("altaAmigos")
    public ModelAndView altaAmigos(@RequestParam("correoAmigo")String correoAmigo, @RequestParam("correo")String correo){
        AmigosController ac = new AmigosController();
        ModelAndView mav = new ModelAndView("listaAmigos");
        ac.setAmigos(new Amigos(new AmigosId(correo,correoAmigo)));
        mav.addObject("amigos",new AmigosController().getAllAmigosByEmail(correo));
        mav.addObject("correo",correo);
        ac.closeSession();
        return mav;
    }
    
    @RequestMapping("bajaAmigos")
    public ModelAndView bajaAmigos(@RequestParam("correoAmigo")String correoAmigo, @RequestParam("correo")String correo){
        AmigosController ac = new AmigosController();
        ModelAndView mav = new ModelAndView("listaAmigos");
        ac.deleteAmigos(new Amigos(new AmigosId(correo,correoAmigo)));
        mav.addObject("amigos",new AmigosController().getAllAmigosByEmail(correo));
        mav.addObject("correo",correo);
        ac.closeSession();
        return mav;
    }
    
    @RequestMapping("cambioAmigos")
    public ModelAndView cambioAmigos(@RequestParam("correoAmigo")String correoAmigo, @RequestParam("correo")String correo){
        AmigosController ac = new AmigosController();
        ModelAndView mav = new ModelAndView("listaAmigos");
        ac.setAmigos(new Amigos(new AmigosId(correo,correoAmigo)));
        mav.addObject("amigos",new AmigosController().getAllAmigosByEmail(correo));
        mav.addObject("correo",correo);
        ac.closeSession();
        return mav;
    }
}
