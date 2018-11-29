/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view;

import controller.AmigosController;
import controller.IntercambioController;
import controller.TemaController;
import controller.UsuarioController;
import controller.UsuarioIntercambioController;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import model.Intercambio;
import model.Tema;
import model.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ExtraViews {
    
    @RequestMapping("usuarioNotFound")
    public ModelAndView usuarioNotFound(){
        return new ModelAndView("usuarioNotFound");
    }
    
    @RequestMapping("listaAmigos")
    public ModelAndView listaAmigos(@RequestParam("correo")String correo){
        AmigosController ac = new AmigosController();
        ModelAndView mav = new ModelAndView("listaAmigos");
        mav.addObject("amigos",ac.getAllAmigosByEmail(correo));
        mav.addObject("correo",correo);
        ac.closeSession();
        System.out.println("Lista Amigos extra view");
        return mav;
    }
    
    @RequestMapping("registroUsuario")
    public ModelAndView registroUsuario(){
        return new ModelAndView("registroUsuario").addObject("usuario", new Usuario());
    }
    
    @RequestMapping("registroIntercambio")
    public ModelAndView registroIntercambio(@RequestParam("correo")String correo){
        TemaController tc = new TemaController();
        AmigosController ac = new AmigosController();
        ModelAndView mav = new ModelAndView("registroIntercambio");
        Intercambio intercambio = new Intercambio();
        intercambio.setTema((Tema)(tc.getAllTema().get(0)));
        mav.addObject("intercambio", intercambio);
        mav.addObject("temas", tc.getAllTema());
        mav.addObject("usuario", new Usuario(correo));
        mav.addObject("amigos", ac.getAllAmigosByEmail(correo));
        tc.closeSession();
        return mav;
    }
    
    @RequestMapping("editarIntercambio")
    public ModelAndView editarIntercambio(@RequestParam("idIntercambio")Integer idIntercambio,@RequestParam("correo")String correo){
        IntercambioController ic = new IntercambioController();
        TemaController tc = new TemaController();
        ModelAndView mav = new ModelAndView("editarIntercambio");
        mav.addObject("intercambio", ic.getIntercambio(idIntercambio));
        mav.addObject("usuario", new Usuario(correo));
        mav.addObject("temas", tc.getAllTema());
        ic.closeSession();
        tc.closeSession();
        return mav;
    }
    
    @RequestMapping("listaIntercambios")
    public ModelAndView listaIntercambio(@RequestParam("correo")String correo){
        IntercambioController ic = new IntercambioController();
        UsuarioController uc = new UsuarioController();
        TemaController tc = new TemaController();
        UsuarioIntercambioController uic = new UsuarioIntercambioController();
        ModelAndView mav = new ModelAndView("listaIntercambios");
        mav.addObject("correo",correo);
        mav.addObject("usuarios",uc.getAllUsuario());
        mav.addObject("usuarioIntercambios", uic.getAllMisIntercambios(correo));
        mav.addObject("temas", tc.getAllTema());
        mav.addObject("intercambios",ic.getAllIntercambio());
        mav.addObject("usuarioIntercambiosAll", uic.getAllUsuarioIntercambio());
        ic.closeSession();
        tc.closeSession();
        uic.closeSession();
        uc.closeSession();
        return mav;
    }
    
    @RequestMapping("descripcionIntercambio")
    public ModelAndView descripcionIntercambio(@RequestParam("correo")String correo,@RequestParam("idIntercambio")Integer idIntercambio){
        IntercambioController ic = new IntercambioController();
        ModelAndView mav = new ModelAndView("descripcionIntercambio");
        mav.addObject("correo",correo);
        mav.addObject("intercambio",ic.getIntercambio(idIntercambio));
        ic.closeSession();
        return mav;
    }
    
    @RequestMapping("paginaBienvenida")
    public ModelAndView paginaBienvenida(@RequestParam("correo")String correo){
        UsuarioController uc = new UsuarioController();
        ModelAndView mav = new ModelAndView("paginaInicio");
        mav.addObject("correo",correo);
        mav.addObject("usuario",uc.getUsuario(correo));
        uc.closeSession();
        return mav;
    }
    
}
