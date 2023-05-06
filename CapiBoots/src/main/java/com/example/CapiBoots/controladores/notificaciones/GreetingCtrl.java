package com.example.CapiBoots.controladores.notificaciones;

import com.example.CapiBoots.modelos.notificaciones.Greeting;
import com.example.CapiBoots.modelos.notificaciones.HelloMessage;
import com.example.CapiBoots.modelos.notificaciones.Notificacion;
import com.example.CapiBoots.modelos.notificaciones.PrivateMessage;
import com.example.CapiBoots.repositorios.NotificacionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * The type Greeting controller.
 */
@Controller
@Log4j2
public class GreetingCtrl {

    /**
     * The Simp messaging template.
     */
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    NotificacionRepository notificacionRepository;


    /**
     * Greeting greeting.
     *
     * @param message the message
     * @return the greeting
     * @throws Exception the exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {

        Thread.sleep(2000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");

    }

    /**
     * Send to specific user.
     *
     * @param message the message
     */
    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload PrivateMessage message) {

        Notificacion notificacion = new Notificacion();
        notificacion.setFrom(message.getFrom());
        notificacion.setFrom(message.getTo());
        notificacion.setMensaje(message.getText());
        notificacion.setEstado("pendiente");
        log.info("Recibida petición de mensaje privado");
        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/specific", message);

    }
}

