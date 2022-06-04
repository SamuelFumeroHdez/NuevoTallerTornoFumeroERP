package com.tallertornofumero.erp.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@Service
public interface EmailService {

    void sendEmail(String htmlContext) throws MessagingException, IOException;

}
