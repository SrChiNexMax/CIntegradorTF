package com.utp.integrador.IntegradorFinal.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utp.integrador.IntegradorFinal.services.EmailService;


@Controller
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    @GetMapping("/email")
    public String emailMainPage(Model model){

        return "secciones/email";
    }

    @RequestMapping(value="/enviarEmail", method = RequestMethod.POST)
    public String enviarEmail(@RequestParam(name = "asunto") String asunto,@RequestParam(name = "mensaje") String mensaje,@RequestParam(name = "archivo") MultipartFile archivo,RedirectAttributes redirectAttributes){
        Long size= archivo.getSize();
        if(size==0){
            emailService.enviarEmailSinAdjunto("melgar10barca@gmail.com", asunto, mensaje);
        }else{
            emailService.enviarEmailConAdjunto("melgar10barca@gmail.com", asunto, mensaje, archivo);
        }
        
        redirectAttributes.addFlashAttribute("msg", "Se envio correctamente");
        
        return "redirect:/email";
    }

}
