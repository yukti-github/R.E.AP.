package com.project.reap.util;
import org.springframework.mail.SimpleMailMessage;

public interface EmailUtil {

    // void sendEmail(String toAddress,String subject,String body);
    void sendEmail(SimpleMailMessage mail);
}