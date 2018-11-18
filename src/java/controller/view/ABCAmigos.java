/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view;

import controller.AmigosIdController;
import model.AmigosId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCAmigos extends AmigosIdController{//Altas, Bajas y Cambios de amigos
    @RequestMapping("/altaAmigosId")
    public ModelAndView altaAmigosId(AmigosId amigosId){
        ModelAndView model = new ModelAndView("listaAmigos");
        setAmigosId(amigosId);
        model.addObject(amigosId);
        return model;
    }
    
    @RequestMapping("/bajaAmigosId")
    public ModelAndView bajaAmigosId(AmigosId amigosId){
        ModelAndView model = new ModelAndView("listaAmigos");
        deleteAmigosId(amigosId);
        model.addObject(amigosId);
        return model;
    }
    
    @RequestMapping("/cambioAmigosId")
    public ModelAndView cambioAmigosId(AmigosId amigosId){
        ModelAndView model = new ModelAndView("listaAmigos");
        setAmigosId(amigosId);
        model.addObject(amigosId);
        return model;
    }
    
}
