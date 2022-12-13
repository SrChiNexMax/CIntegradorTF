package com.utp.integrador.IntegradorFinal.services;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

    public void enviarEmailSinAdjunto(String emailTo,String asunto, String mensaje);

    public void enviarEmailConAdjunto(String emailTo,String asunto, String mensaje, MultipartFile file);
}
