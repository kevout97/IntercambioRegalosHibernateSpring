package controller.view;

import controller.IntercambioController;
import model.Intercambio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCIntercambios extends IntercambioController{//Altas, Bajas y Cambios de un intercambio
    @RequestMapping("/altaIntercambio")
    public ModelAndView altaIntercambio(Intercambio intercambio){
        ModelAndView model = new ModelAndView("paginaInicio");
        setIntercambio(intercambio);
        model.addObject(intercambio);
        return model;
    }
    
    @RequestMapping("/bajaIntercambio")
    public ModelAndView bajaIntercambio(Intercambio intercambio){
        ModelAndView model = new ModelAndView("paginaInicio");
        deleteIntercambio(intercambio);
        model.addObject(intercambio);
        return model;
    }
    
    @RequestMapping("/cambioIntercambio")
    public ModelAndView cambioIntercambio(Intercambio intercambio){
        ModelAndView model = new ModelAndView("paginaInicio");
        setIntercambio(intercambio);
        model.addObject(intercambio);
        return model;
    }
}
