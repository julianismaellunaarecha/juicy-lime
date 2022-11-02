package com.flashhammer.juicyfruit.service;

import com.flashhammer.juicyfruit.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailerServiceImpl implements MailerService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject(mail.getMailSubject());
        mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
        mimeMessageHelper.setTo(mail.getMailTo());
        mimeMessageHelper.setBcc(mail.getMailBcc());
        mimeMessageHelper.setText(mail.getMailContent());
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }

}