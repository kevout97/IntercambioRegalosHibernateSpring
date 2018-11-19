package controller.view;

import controller.IntercambioController;
import controller.UsuarioController;
import model.Intercambio;
import model.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class FormularioInicio {
    
    @RequestMapping("inicioSesion")
    public ModelAndView inicioSesion(@RequestParam("correo") String correo, @RequestParam("contrasenia")String contrasenia){//Este metodo valida que el usuario este registrado
        ModelAndView model = new ModelAndView();
        Usuario usuario = (new UsuarioController().existsUsuario(correo,contrasenia))?(new UsuarioController().getUsuario(correo,contrasenia)):new Usuario();
        model.setViewName((new UsuarioController().existsUsuario(correo,contrasenia))?"paginaInicio":"usuarioNotFound");
        model.addObject("usuario",usuario);
        return model;
    }
    
    @RequestMapping("verIntercambio")
    public ModelAndView searchIntercambio(@RequestParam("idIntercambio") Integer idIntercambio){//Este metodo valida que el usuario exista
        ModelAndView model = new ModelAndView();
        Intercambio intercambio = (new IntercambioController().existsIntercambio(idIntercambio))?(new IntercambioController()).getIntercambio(idIntercambio):new Intercambio();
        model.setViewName((new IntercambioController().existsIntercambio(idIntercambio))?"descripcionIntercambio":"intercambioNotFound");
        model.addObject("intercambio",intercambio);
        return model;
    }
}
