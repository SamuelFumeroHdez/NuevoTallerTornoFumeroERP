package com.tallertornofumero.erp.controller;

import com.tallertornofumero.erp.model.Usuario;
import com.tallertornofumero.erp.service.EmailService;
import com.tallertornofumero.erp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TemplateEngine templateEngine;

    @RequestMapping(value = "/sendemail")
    public String sendEmail(Model model) throws MessagingException, IOException {
        List<Usuario> listaUsuarios = usuarioService.listUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        Context context = new Context();
        String htmlContext = templateEngine.process("index", context);

        context.setVariable("usuarios", listaUsuarios);

        emailService.sendEmail(htmlContext);
        return "Email sent successfully";
    }
}
