package com.bolsadeideas.springboot.web.app.controllers;


import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index","/","/home",""})
    public String index(ModelMap model){

        //variable th titulo
        model.addAttribute("titulo","hola Spring framework");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil (Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Andrés");
        usuario.setApellido("Guzman");
        usuario.setEmail("pepe@gmail.com");


        model.addAttribute("titulo","Perfil del usuario: ".concat(usuario.getNombre()));
        //variables que luego usamos en el th(usuario comillas" y luego la instancia del usuario
        model.addAttribute("usuario",usuario);


        return "perfil";
    }
    @RequestMapping("/listar")
    public String listar (Model model){

        List<Usuario> usuarios = new ArrayList<>();

        model.addAttribute("titulo","Lista de usuarios: ");
        model.addAttribute("usuarios", usuarios);


        return "listar";
    }

}
