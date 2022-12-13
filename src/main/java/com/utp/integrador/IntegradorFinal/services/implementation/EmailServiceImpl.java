package com.utp.integrador.IntegradorFinal.services.implementation;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utp.integrador.IntegradorFinal.services.EmailService;


@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String email;

    @Override
    public void enviarEmailSinAdjunto(String emailTo,String asunto, String mensaje) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(email);
            helper.setTo(emailTo);
            helper.setSubject(asunto);
            helper.setText(mensaje);
            javaMailSender.send(message);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void enviarEmailConAdjunto(String emailTo,String asunto, String mensaje, MultipartFile file) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            InputStreamSource archivo = new EncodedResource(file.getResource());
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(email);
            helper.setTo(emailTo);
            helper.setSubject(asunto);
            helper.setText(mensaje);
            helper.addAttachment(file.getOriginalFilename(), archivo);
            javaMailSender.send(message);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


}
