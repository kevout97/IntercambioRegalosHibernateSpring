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
public class ABCUsuarios{//Altas Bajas y Cambios de un usuario
    @RequestMapping("altaUsuario")
    public ModelAndView altaUsuario(@ModelAttribute("usuario")Usuario usuario){
        UsuarioController uc = new UsuarioController();
        ModelAndView model = new ModelAndView("paginaInicio");
        uc.setUsuario(usuario);
        model.addObject("usuario",usuario);
        uc.closeSession();
        return model;
    }
    
    @RequestMapping("bajaUsuario")
    public ModelAndView bajaUsuario(@ModelAttribute("usuario")Usuario usuario){
        UsuarioController uc = new UsuarioController();
        ModelAndView model = new ModelAndView("paginaInicio");
        uc.deleteUsuario(usuario);
        model.addObject(usuario);
        uc.closeSession();
        return model;
    }
    
    @RequestMapping("cambioUsuario")
    public ModelAndView cambioUsuario(@ModelAttribute("usuario")Usuario usuario){
        UsuarioController uc = new UsuarioController();
        ModelAndView model = new ModelAndView("paginaInicio");
        uc.setUsuario(usuario);
        model.addObject(usuario);
        uc.closeSession();
        return model;
    }
}
