package controller.view;

import controller.AmigosController;
import java.util.Iterator;
import java.util.List;
import model.Amigos;
import model.AmigosId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCAmigos extends AmigosController{//Altas, Bajas y Cambios de amigos
    @RequestMapping("altaAmigos")
    public ModelAndView altaAmigos(@RequestParam("correoAmigo")String correoAmigo, @RequestParam("correo")String correo){
        ModelAndView mav = new ModelAndView("listaAmigos");
        setAmigos(new Amigos(new AmigosId(correo,correoAmigo)));
        mav.addObject("amigos",new AmigosController().getAllAmigosByEmail(correo));
        mav.addObject("correo",correo);
        return mav;
    }
    
    @RequestMapping("bajaAmigos")
    public ModelAndView bajaAmigos(@RequestParam("correoAmigo")String correoAmigo, @RequestParam("correo")String correo){
        ModelAndView mav = new ModelAndView("listaAmigos");
        deleteAmigos(new Amigos(new AmigosId(correo,correoAmigo)));
        mav.addObject("amigos",new AmigosController().getAllAmigosByEmail(correo));
        mav.addObject("correo",correo);
        return mav;
    }
    
    @RequestMapping("cambioAmigos")
    public ModelAndView cambioAmigos(@RequestParam("correoAmigo")String correoAmigo, @RequestParam("correo")String correo){
        ModelAndView mav = new ModelAndView("listaAmigos");
        setAmigos(new Amigos(new AmigosId(correo,correoAmigo)));
        mav.addObject("amigos",new AmigosController().getAllAmigosByEmail(correo));
        mav.addObject("correo",correo);
        return mav;
    }
}
