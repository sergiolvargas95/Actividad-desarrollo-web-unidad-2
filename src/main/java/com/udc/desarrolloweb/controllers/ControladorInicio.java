package com.udc.desarrolloweb.controllers;

import com.udc.desarrolloweb.dao.IUsuarioCrud;
import com.udc.desarrolloweb.models.Usuario;
import com.udc.desarrolloweb.services.IUsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    IUsuarioService userService;
    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUusarios = (List<Usuario>) userService.listarUsuarios();
        modelo.addAttribute("usuarios", listaUusarios);
        log.info("Ejecutando el controlador Inicio MVC");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, Errors errores) {
        if(errores.hasErrors()) {
            return "modificar";
        }
        userService.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{cedula}")
    public String editar(Usuario usuario, Model modelo) {
        log.info("Invocando el método EDITAR");
        usuario = userService.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminar(Usuario usuario) {
        userService.eliminar(usuario);
        return "redirect:/";
    }
}
