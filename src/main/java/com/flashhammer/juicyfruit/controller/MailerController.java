package com.flashhammer.juicyfruit.controller;

import com.flashhammer.juicyfruit.model.Mail;
import com.flashhammer.juicyfruit.model.Message;
import com.flashhammer.juicyfruit.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;

@Controller
public class MailerController {

    @Autowired
    private MailerService mailerService;

    public Message sendEmail(Message messageReceived) {
        if (messageReceived != null && messageReceived.getId() != null) {
            Mail mail = new Mail();
            mail.setMailFrom("${spring.mail.username}" + "${email.server}");
            mail.setMailTo(messageReceived.getSourceEmail());
            mail.setMailBcc("${email.emailcco}");
            mail.setMailSubject("Mensaje recibido desde " + "${email.sendername}");
            mail.setMailContent(
                    "Gracias por contactarse con " + "${email.sendername}" + ", le responderemos a la brevedad. Su codigo de contacto es: "
                            + messageReceived.getId()
            );
            try {
                mailerService.sendEmail(mail);
                messageReceived.setProcessed("si");
            } catch (MessagingException e) {
                System.out.println(e.getMessage());
            }
        }
        return messageReceived;
    }

}
