package controller.view;

import controller.AdministracionIntercambios;
import controller.IntercambioController;
import controller.TemaController;
import controller.UsuarioIntercambioController;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.Intercambio;
import model.Tema;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCIntercambios extends IntercambioController{//Altas, Bajas y Cambios de un intercambio
    @RequestMapping("altaIntercambio")
    public ModelAndView altaIntercambio(@RequestParam("correo") String correo,
                                        @RequestParam("nombre") String nombre,
                                        @RequestParam("tema") String tema,
                                        @RequestParam("montoMaximo") BigDecimal montoMaximo,
                                        @RequestParam("fechaLimite") String fechaLimite,
                                        @RequestParam("fechaIntercambio") String fechaIntercambio,
                                        @RequestParam("comentarios") String comentarios) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ModelAndView model = new ModelAndView("listaIntercambios");
        Intercambio intercambio = new Intercambio(new TemaController().getTemaByNombre(tema),nombre,montoMaximo,sdf.parse(fechaLimite),sdf.parse(fechaIntercambio),comentarios);
        setIntercambio(intercambio);
        new AdministracionIntercambios().iniciarIntercambio(intercambio.getId(), correo);
        model.addObject("intercambios", new UsuarioIntercambioController().getAllMisIntercambios(correo));
        return model;
    }
    
    @RequestMapping("bajaIntercambio")
    public ModelAndView bajaIntercambio(@RequestParam("idIntercambio")int idIntercambio,@RequestParam("correo") String correo){
        ModelAndView model = new ModelAndView("listaIntercambios");
        deleteIntercambio(new IntercambioController().getIntercambio(idIntercambio));
        model.addObject("intercambios",new UsuarioIntercambioController().getAllMisIntercambios(correo));
        return model;
    }
    
    @RequestMapping("cambioIntercambio")
    public ModelAndView cambioIntercambio(@RequestParam("correo") String correo,
                                        @RequestParam("nombre") String nombre,
                                        @RequestParam("tema") String tema,
                                        @RequestParam("montoMaximo") BigDecimal montoMaximo,
                                        @RequestParam("fechaLimite") String fechaLimite,
                                        @RequestParam("fechaIntercambio") String fechaIntercambio,
                                        @RequestParam("comentarios") String comentarios) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ModelAndView model = new ModelAndView("listaIntercambios");
        setIntercambio(new Intercambio(new TemaController().getTemaByNombre(tema),nombre,montoMaximo,sdf.parse(fechaLimite),sdf.parse(fechaIntercambio),comentarios));
        model.addObject("intercambios",new UsuarioIntercambioController().getAllMisIntercambios(correo));
        return model;
    }
}
