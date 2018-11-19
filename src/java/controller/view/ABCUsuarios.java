package controller.view;

import controller.UsuarioController;
import model.Usuario;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCUsuarios extends UsuarioController{//Altas Bajas y Cambios de un usuario
    @RequestMapping("altaUsuario")
    public ModelAndView altaUsuario(@ModelAttribute("usuario")Usuario usuario){
        ModelAndView model = new ModelAndView("paginaInicio");
        setUsuario(usuario);
        model.addObject("usuario",usuario);
        return model;
    }
    
    @RequestMapping("bajaUsuario")
    public ModelAndView bajaUsuario(@ModelAttribute("usuario")Usuario usuario){
        ModelAndView model = new ModelAndView("paginaInicio");
        deleteUsuario(usuario);
        model.addObject(usuario);
        return model;
    }
    
    @RequestMapping("cambioUsuario")
    public ModelAndView cambioUsuario(@ModelAttribute("usuario")Usuario usuario){
        ModelAndView model = new ModelAndView("paginaInicio");
        setUsuario(usuario);
        model.addObject(usuario);
        return model;
    }
}
