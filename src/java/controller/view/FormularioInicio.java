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
        UsuarioController uc = new UsuarioController();
        ModelAndView model = new ModelAndView();
        Usuario usuario = (uc.existsUsuario(correo,contrasenia))?(uc.getUsuario(correo,contrasenia)):new Usuario();
        model.setViewName((uc.existsUsuario(correo,contrasenia))?"paginaInicio":"usuarioNotFound");
        model.addObject("usuario",usuario);
        uc.closeSession();
        return model;
    }
    
    @RequestMapping("verIntercambio")
    public ModelAndView searchIntercambio(@RequestParam("idIntercambio") Integer idIntercambio){//Este metodo valida que el usuario exista
        IntercambioController ic = new IntercambioController();
        ModelAndView model = new ModelAndView();
        Intercambio intercambio = (ic.existsIntercambio(idIntercambio))?ic.getIntercambio(idIntercambio):new Intercambio();
        model.setViewName((ic.existsIntercambio(idIntercambio))?"descripcionIntercambio":"intercambioNotFound");
        model.addObject("intercambio",intercambio);
        ic.closeSession();
        return model;
    }
}
