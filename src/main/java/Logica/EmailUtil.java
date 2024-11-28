package Logica;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//ENVIAR MENSAJES
public class EmailUtil {

    public static void enviarCorreo(String destinatario, String asunto, String contenidoHtml) {
        // Configuración del servidor SMTP
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", "localhost"); // DevNull está en localhost
        propiedades.put("mail.smtp.port", "25");       // Puerto por defecto de DevNull
        propiedades.put("mail.smtp.auth", "false");    // DevNull no requiere autenticación
        propiedades.put("mail.smtp.starttls.enable", "false"); // No se requiere TLS

        // Crear sesión de correo
        Session sesion = Session.getInstance(propiedades);

        try {
            // Crear mensaje
            MimeMessage mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress("no-reply@espotify.com")); // Dirección remitente
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensaje.setSubject(asunto, "UTF-8"); // Asunto en UTF-8

            // Configurar cuerpo del mensaje en formato HTML y UTF-8
            mensaje.setContent(contenidoHtml, "text/html; charset=UTF-8");

            // Enviar el correo
            Transport.send(mensaje);

            System.out.println("Correo enviado correctamente a " + destinatario);
        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo a " + destinatario + ": " + e.getMessage());
            e.printStackTrace(); // Imprime la pila de errores para depuración
        }
    }
}


