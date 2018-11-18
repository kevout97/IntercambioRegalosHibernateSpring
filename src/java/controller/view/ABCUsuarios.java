package controller.view;

import controller.UsuarioController;
import model.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCUsuarios extends UsuarioController{//Altas Bajas y Cambios de un usuario
    @RequestMapping("/altaUsuario")
    public ModelAndView altaUsuario(Usuario usuario){
        ModelAndView model = new ModelAndView("paginaInicio");
        setUsuario(usuario);
        model.addObject(usuario);
        return model;
    }
    
    @RequestMapping("/bajaUsuario")
    public ModelAndView bajaUsuario(Usuario usuario){
        ModelAndView model = new ModelAndView("paginaInicio");
        deleteUsuario(usuario);
        model.addObject(usuario);
        return model;
    }
    
    @RequestMapping("/cambioUsuario")
    public ModelAndView cambioUsuario(Usuario usuario){
        ModelAndView model = new ModelAndView("paginaInicio");
        setUsuario(usuario);
        model.addObject(usuario);
        return model;
    }
}
