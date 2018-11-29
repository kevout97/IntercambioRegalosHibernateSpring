package controller;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import model.UsuarioIntercambio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class AdministracionIntercambios {//Esta clase se emparejar a los usuarios en cada intercambio
    
    @RequestMapping("agregarUsuario")
    public ModelAndView agregarUsuario(@RequestParam("idIntercambio")Integer idIntercambio,@RequestParam("correo")String correo){//Este metodo agrega un usuario a un intercambio y los revuelve nuevamente     
        UsuarioController uc = new UsuarioController();
        TemaController tc = new TemaController();
        IntercambioController ic = new IntercambioController();
        UsuarioIntercambio ui = new UsuarioIntercambio(ic.getIntercambio(idIntercambio),
                                                        uc.getUsuario(correo),
                                                        true,
                                                        correo,
                                                        false,
                                                        false);
        UsuarioIntercambioController uic = new UsuarioIntercambioController();
        uic.setUsuarioIntercambio(ui);
        ModelAndView mav = new ModelAndView("listaIntercambios");
        mav.addObject("correo",correo);
        mav.addObject("usuarios",uc.getAllUsuario());
        mav.addObject("usuarioIntercambios", uic.getAllMisIntercambios(correo));
        mav.addObject("temas", tc.getAllTema());
        mav.addObject("intercambios",ic.getAllIntercambio());
        uic.closeSession();
        uc.closeSession();
        tc.closeSession();
        ic.closeSession();
        return mav;
        
    }
    
    @RequestMapping("realizarSorteo")
    public ModelAndView realizarSorteo(@RequestParam("idIntercambio")Integer idIntercambio,@RequestParam("correo")String correo){
        UsuarioIntercambioController uic = new UsuarioIntercambioController();
        UsuarioController uc = new UsuarioController();
        TemaController tc = new TemaController();
        IntercambioController ic = new IntercambioController();
        UsuarioIntercambio ui = new UsuarioIntercambio( uic.getUsuarioIntercambio(correo,idIntercambio).getIdUsuarioIntercambio(),
                                                        ic.getIntercambio(idIntercambio),
                                                        uc.getUsuario(correo),
                                                        true,
                                                        uic.getUsuarioIntercambio(correo,idIntercambio).getIdIntercambiar(),
                                                        true,
                                                        true);
        UsuarioIntercambioController uic2 = new UsuarioIntercambioController();
        uic2.setUsuarioIntercambio(ui);
        uic2.closeSession();
        ModelAndView mav = new ModelAndView("listaIntercambios");
        List usuariosIntercambiosOld = uic.getAllUsuarioIntercambioByIdIntercambio(idIntercambio);
        List usuariosIntercambiosNew = uic.getAllUsuarioIntercambioByIdIntercambio(idIntercambio);
        int random = (int)(Math.random() * (usuariosIntercambiosOld.size()-1))+1;
        for (int i = 0; i < usuariosIntercambiosOld.size(); i++) {
            if (random >= usuariosIntercambiosOld.size()) {
                random = 0;
            }
            ((UsuarioIntercambio)usuariosIntercambiosNew.get(i)).setIdIntercambiar(((UsuarioIntercambio)usuariosIntercambiosOld.get(random)).getUsuario().getCorreo());
            random ++;
        }
        
        for (Iterator it = usuariosIntercambiosNew.iterator(); it.hasNext();) {
            UsuarioIntercambioController uic3 = new UsuarioIntercambioController();
            uic3.setUsuarioIntercambio((UsuarioIntercambio)it.next());
            uic3.closeSession();
        }
        mav.addObject("correo",correo);
        mav.addObject("usuarios",uc.getAllUsuario());
        mav.addObject("usuarioIntercambios", uic.getAllMisIntercambios(correo));
        mav.addObject("usuarioIntercambiosAll", uic.getAllUsuarioIntercambio());
        mav.addObject("temas", tc.getAllTema());
        mav.addObject("intercambios",ic.getAllIntercambio());
        uic.closeSession();
        uc.closeSession();
        ic.closeSession();
        return mav;
    }
    
    public void iniciarIntercambio(int idIntercambio,String correo){//Este metodo inicializa el intercambio
        UsuarioIntercambioController uic = new UsuarioIntercambioController();
        IntercambioController ic = new IntercambioController();
        UsuarioController uc = new UsuarioController();
        UsuarioIntercambio ui = new UsuarioIntercambio(ic.getIntercambio(idIntercambio),
                                                        uc.getUsuario(correo),
                                                        true,
                                                        correo,
                                                        true,
                                                        false);
        uic.setUsuarioIntercambio(ui);        
        uic.closeSession();
        ic.closeSession();
        uc.closeSession();
    }
    
}
