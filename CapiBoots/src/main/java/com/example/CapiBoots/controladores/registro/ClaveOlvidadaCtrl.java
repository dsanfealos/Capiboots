package com.example.CapiBoots.controladores.registro;

import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.servicios.UsuarioSrvcImpls;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class ClaveOlvidadaCtrl {


    private JavaMailSender mailSender;

    @Autowired
    private UsuarioSrvcImpls userService;


    //Muestra el formulario de clave olvidada
    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "forgot_password_form";
    }


    //Se activa al rellenar el formulario de Clave Olvidada
    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        //Preparamos un token (código aleatorio de 30 dígitos) y un correo al que enviarlo
        String email = request.getParameter("email");
        String token  = RandomStringUtils.randomAlphanumeric(30);

        //Se manda al correo un enlace con una url que contiene el token en la parte final
        try {
            userService.updateResetPasswordToken(token, email);
            //Url = Url base + url departamento + token
            String resetPasswordLink =  "http://localhost:8080" + "/reset_password?token=" + token;
            //Se manda el correo con ambos parámetros
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");

        } catch (UsernameNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        } catch (UnsupportedEncodingException | MessagingException e) {
            model.addAttribute("error", "Error while sending email");
        }

        return "forgot_password_form";
    }


    //Método para mandar un email con los parámetros email y link a enviar
    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        //Declaramos el remitente
        helper.setFrom("capiboots.soporte@gmail.com", "Soporte Capiboots");
        //Aplicamos la dirección del destinatario
        helper.setTo(recipientEmail);

        //Asunto del email
        String subject = "Link para restaurar la contraseña";

        //Contenido con el link
        String content = "<p>Hola,</p>"
                + "<p>Has solicitado una restauración de contraseña de tu cuenta.</p>"
                + "<p>Pulsa en el siguiente link para cambiarla :</p>"
                + "<p><a href=\"" + link + "\">Cambiar Password</a></p>"
                + "<br>"
                + "<p>Si no has solicitado esto, ignora este mensaje.</p>";

        //Aplicamos lo declarado
        helper.setSubject(subject);

        helper.setText(content, true);

        //Enviamos el correo
        mailSender.send(message);
    }


    //Comprobación del token antes de reenviarse al formulario correspondiente
    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        //Encuentra al usuario por el token
        Usuario user = userService.getByRestaurarContra(token);
        model.addAttribute("token", token);

        //Si no existe un usuario asociado al token, manda un mensaje
        if (user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }

        //Si se cumplen las condiciones, redirecciona al formulario de reseteo de clave
        return "reset_password_form";
    }


    //Al realizar el formulario, se activa esta url
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        //Creamos los parámetros de token y nueva contraseña requeridos, que se piden en el html
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        //Llamamos al usuario asociado al token
        Usuario user = userService.getByRestaurarContra(token);
        model.addAttribute("title", "Reset your password");

        //Si no hay usuario asociado, se manda mensaje. Si lo hay, se
        // activa el método de actualización de clave
        if (user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        } else {
            userService.updatePassword(user, password);
            model.addAttribute("message", "You have successfully changed your password.");
        }

        return "message";
    }

}
