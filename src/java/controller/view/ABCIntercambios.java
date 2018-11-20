package controller.view;

import controller.AdministracionIntercambios;
import controller.IntercambioController;
import controller.TemaController;
import controller.UsuarioController;
import controller.UsuarioIntercambioController;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Intercambio;
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
        model.addObject("correo",correo);
        model.addObject("usuarios",new UsuarioController().getAllUsuario());
        model.addObject("usuarioIntercambios", new UsuarioIntercambioController().getAllMisIntercambios(correo));
        model.addObject("temas", new TemaController().getAllTema());
        model.addObject("intercambios",new IntercambioController().getAllIntercambio());
        return model;
    }
    
    @RequestMapping("bajaIntercambio")
    public ModelAndView bajaIntercambio(@RequestParam("idIntercambio")int idIntercambio,@RequestParam("correo") String correo){
        ModelAndView model = new ModelAndView("listaIntercambios");
        deleteIntercambio(new IntercambioController().getIntercambio(idIntercambio));
        model.addObject("correo",correo);
        model.addObject("usuarios",new UsuarioController().getAllUsuario());
        model.addObject("usuarioIntercambios", new UsuarioIntercambioController().getAllMisIntercambios(correo));
        model.addObject("temas", new TemaController().getAllTema());
        model.addObject("intercambios",new IntercambioController().getAllIntercambio());
        return model;
    }
    
    @RequestMapping("cambioIntercambio")
    public ModelAndView cambioIntercambio(@RequestParam("correo") String correo,
                                        @RequestParam("nombre") String nombre,
                                        @RequestParam("tema") String tema,
                                        @RequestParam("montoMaximo") BigDecimal montoMaximo,
                                        @RequestParam("fechaLimite") String fechaLimite,
                                        @RequestParam("fechaIntercambio") String fechaIntercambio,
                                        @RequestParam("comentarios") String comentarios,
                                        @RequestParam("idIntercambio")Integer idIntercambio) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ModelAndView model = new ModelAndView("listaIntercambios");
        Intercambio intercambio = new Intercambio(new TemaController().getTemaByNombre(tema),nombre,montoMaximo,sdf.parse(fechaLimite),sdf.parse(fechaIntercambio),comentarios);
        intercambio.setId(idIntercambio);
        setIntercambio(intercambio);
        model.addObject("correo",correo);
        model.addObject("usuarios",new UsuarioController().getAllUsuario());
        model.addObject("usuarioIntercambios", new UsuarioIntercambioController().getAllMisIntercambios(correo));
        model.addObject("temas", new TemaController().getAllTema());
        model.addObject("intercambios",new IntercambioController().getAllIntercambio());
        return model;
    }
}
