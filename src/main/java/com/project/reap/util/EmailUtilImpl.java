package com.project.reap.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtilImpl implements EmailUtil {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(SimpleMailMessage mailMessage) {
        sender.send(mailMessage);
    }
}