package controller.view;

import controller.AdministracionIntercambios;
import controller.AmigosController;
import controller.IntercambioController;
import controller.TemaController;
import controller.UsuarioController;
import controller.UsuarioIntercambioController;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import model.Intercambio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevout
 */
public class ABCIntercambios {//Altas, Bajas y Cambios de un intercambio
    @RequestMapping("altaIntercambio")
    public ModelAndView altaIntercambio(@RequestParam("correo") String correo,
                                        @RequestParam("nombre") String nombre,
                                        @RequestParam("tema") String tema,
                                        @RequestParam("montoMaximo") BigDecimal montoMaximo,
                                        @RequestParam("fechaLimite") String fechaLimite,
                                        @RequestParam("fechaIntercambio") String fechaIntercambio,
                                        @RequestParam("comentarios") String comentarios,
                                        @RequestParam("amigos")String[] amigosSeleccionados) throws ParseException{
        
        IntercambioController ic = new IntercambioController();
        UsuarioController uc = new UsuarioController();
        TemaController tc = new TemaController();
        AmigosController ac = new AmigosController();
        UsuarioIntercambioController uic = new UsuarioIntercambioController();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ModelAndView model = new ModelAndView("listaIntercambios");
        Intercambio intercambio = new Intercambio(tc.getTemaByNombre(tema),nombre,montoMaximo,sdf.parse(fechaLimite),sdf.parse(fechaIntercambio),comentarios);
        ic.setIntercambio(intercambio);
        sendEmail(amigosSeleccionados,intercambio.getId(),correo);
        new AdministracionIntercambios().iniciarIntercambio(intercambio.getId(), correo);
        model.addObject("correo",correo);
        model.addObject("usuarios",uc.getAllUsuario());
        model.addObject("usuarioIntercambios", uic.getAllMisIntercambios(correo));
        model.addObject("temas", tc.getAllTema());
        model.addObject("intercambios",ic.getAllIntercambio());
        model.addObject("amigos", ac.getAllAmigosByEmail(correo));
        uc.closeSession();
        tc.closeSession();
        ic.closeSession();
        ac.closeSession();
        return model;
    }
    
    @RequestMapping("bajaIntercambio")
    public ModelAndView bajaIntercambio(@RequestParam("idIntercambio")int idIntercambio,@RequestParam("correo") String correo){
        IntercambioController ic = new IntercambioController();
        UsuarioController uc = new UsuarioController();
        TemaController tc = new TemaController();
        UsuarioIntercambioController uic = new UsuarioIntercambioController();
        ModelAndView model = new ModelAndView("listaIntercambios");
        ic.deleteIntercambio(ic.getIntercambio(idIntercambio));
        model.addObject("correo",correo);
        model.addObject("usuarios",uc.getAllUsuario());
        model.addObject("usuarioIntercambios", uic.getAllMisIntercambios(correo));
        model.addObject("temas", tc.getAllTema());
        model.addObject("intercambios",ic.getAllIntercambio());
        model.addObject("usuarioIntercambiosAll", uic.getAllUsuarioIntercambio());
        uc.closeSession();
        tc.closeSession();
        ic.closeSession();
        System.out.println("Baja Intercambio");
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
        IntercambioController ic = new IntercambioController();
        UsuarioController uc = new UsuarioController();
        TemaController tc = new TemaController();
        UsuarioIntercambioController uic = new UsuarioIntercambioController();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ModelAndView model = new ModelAndView("listaIntercambios");
        Intercambio intercambio = new Intercambio(tc.getTemaByNombre(tema),nombre,montoMaximo,sdf.parse(fechaLimite),sdf.parse(fechaIntercambio),comentarios);
        intercambio.setId(idIntercambio);
        ic.setIntercambio(intercambio);
        model.addObject("correo",correo);
        model.addObject("usuarios",uc.getAllUsuario());
        model.addObject("usuarioIntercambios", uic.getAllMisIntercambios(correo));
        model.addObject("temas", tc.getAllTema());
        model.addObject("intercambios",ic.getAllIntercambio());
        model.addObject("usuarioIntercambiosAll", uic.getAllUsuarioIntercambio());
        uc.closeSession();
        tc.closeSession();
        ic.closeSession();
        return model;
    }
    
    public void sendEmail(String[] correos, int idIntercambio,String correoUsuarioCreador){
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "kev.gomez97@gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props, null);
            Transport t = session.getTransport("smtp");
            for(int i = 0; i < correos.length;i++){
                
            BodyPart texto = new MimeBodyPart();
            String correoRemitente = "kev.gomez97@gmail.com";
            String passwordRemitente = "kev20165997";
            String correoReceptor = correos[i];
            String asunto = "INTERCAMBIATRON";
            String msj = "Que onda que pex !!\nHas sido invitad@ al intercambio organizado por "+correoUsuarioCreador+"\n para mas información ingresa el código: "+idIntercambio+"\n en la siguiente dirección"
                    + "http://localhost:24878/IntercambioRegalos/index.htm \n ¡No olvides que es necesario contar con una cuenta ya registrada.!";
            texto.setText(msj);
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(correoRemitente));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            mensaje.setSubject(asunto);
            mensaje.setContent(m);
            
            
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            }
            
            t.close();
            

        } catch (MessagingException ex) {
            
        }
    }
}
