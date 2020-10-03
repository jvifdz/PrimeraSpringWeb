package com.bolsadeideas.springboot.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/string/{texto}")
    public String variables (@PathVariable String texto, Model model){

        model.addAttribute("titulo","Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado","El texto enviado en la ruta es : "+texto);

        return "variables/ver";

    }


}
