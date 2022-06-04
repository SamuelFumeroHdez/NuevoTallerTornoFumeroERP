package com.tallertornofumero.erp.service.impl;

import com.tallertornofumero.erp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void sendEmail(String htmlContext) throws MessagingException, IOException {
        //simpleTextMessage();
        System.out.println("Llega");
        fileTextMessage(htmlContext);
    }

    public void simpleTextMessage(){
        SimpleMailMessage simpleMailMessage = getBasicSimpleMailMessage();
        javaMailSender.send(simpleMailMessage);
    }

    public void fileTextMessage(String htmlContext) throws MessagingException {

        String bodyMessage = "Esto es un correo de prueba ID=" + UUID.randomUUID();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        mimeMessageHelper.setFrom("samuelfumerohdez@gmail.com");
        mimeMessageHelper.setTo("samuelfumerohdez@gmail.com");
        mimeMessageHelper.addAttachment("image.jpg", new File("src/main/resources/static/spring-boot.png"));
        mimeMessageHelper.setSubject("Correo con archivo de prueba");
        mimeMessageHelper.setText(htmlContext, true);
        System.out.println(htmlContext);

        javaMailSender.send(mimeMessage);

    }

    public SimpleMailMessage getBasicSimpleMailMessage(){
        String bodyMessage = "Esto es un correo de prueba ID=" + UUID.randomUUID();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("samuelfumerohdez@gmail.com");
        simpleMailMessage.setTo("samuelfumerohdez@gmail.com");
        simpleMailMessage.setSubject("Correo de prueba");
        simpleMailMessage.setText(bodyMessage);

        return simpleMailMessage;
    }
}
