package com.bolsadeideas.springboot.web.app.controllers;


import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;


    @GetMapping({"/index", "/", "/home", ""})
    public String index(ModelMap model) {

        //variable th titulo
        //model.addAttribute("titulo", "hola Spring framework");
        //manera con el value
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Andrés");
        usuario.setApellido("Guzman");
        usuario.setEmail("pepe@gmail.com");

            //manera con el value
            /* model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));*/
            model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

        //variables que luego usamos en el th(usuario comillas" y luego la instancia del usuario
        model.addAttribute("usuario", usuario);


        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {

        //model.addAttribute("titulo", "Lista de usuarios: ");
        //manera con el value
        model.addAttribute("titulo", textoListar);
        //Uso el model Atrribute para generalizar el añadido a la lista
        /*List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Andres", "Guzman", "andres@correo.com"));
        usuarios.add(new Usuario("John", "Doe", "john@correo.com"));
        usuarios.add(new Usuario("Jane", "Doe", "jane@correo.com"));

        //otra manera con la clase Arrays y metodo asList nos ahorramos la creacion del arrayList es lo mismo

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Andres", "Guzman", "andres@correo.com"),
                new Usuario("John", "Doe", "john@correo.com"),
                new Usuario("Jane", "Doe", "jane@correo.com"),
                new Usuario("Tornado", "Roe", "tornado@correo.com"));*/

        // ya no hace falta que esta en el listar
        //model.addAttribute("usuarios", usuarios);


        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Andres", "Guzman", "andres@correo.com"),
                new Usuario("John", "Doe", "john@correo.com"),
                new Usuario("Jane", "Doe", "jane@correo.com"),
                new Usuario("Tornado", "Roe", "tornado@correo.com"));
        return usuarios;
    }

}
