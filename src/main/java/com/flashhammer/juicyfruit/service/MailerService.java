package com.flashhammer.juicyfruit.service;

import com.flashhammer.juicyfruit.model.Mail;

import javax.mail.MessagingException;

public interface MailerService
{
    public void sendEmail(Mail mail) throws MessagingException;
}
