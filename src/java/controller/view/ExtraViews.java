/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view;

import controller.TemaController;
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
    public ModelAndView listaAmigos(){
        return new ModelAndView("listaAmigos");
    }
    
    @RequestMapping("registroUsuario")
    public ModelAndView registroUsuario(){
        return new ModelAndView("registroUsuario").addObject("usuario", new Usuario());
    }
    
    @RequestMapping("registroIntercambio")
    public ModelAndView registroIntercambio(@RequestParam("correo")String correo){
        ModelAndView mav = new ModelAndView("registroIntercambio");
        Intercambio intercambio = new Intercambio();
        intercambio.setTema((Tema)(new TemaController().getAllTema().get(0)));
        mav.addObject("intercambio", intercambio);
        mav.addObject("temas", new TemaController().getAllTema());
        mav.addObject("usuario", new Usuario(correo));
        return mav;
    }
    
}
