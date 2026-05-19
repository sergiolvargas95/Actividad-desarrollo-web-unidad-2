package com.udc.desarrolloweb.controllers;

import com.udc.desarrolloweb.models.Biblioteca;
import com.udc.desarrolloweb.services.IBibliotecaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/bibliotecas")
public class ControladorBiblioteca {

    @Autowired
    IBibliotecaService bibliotecaService;

    @GetMapping
    public String listar(Model modelo) {
        List<Biblioteca> lista = bibliotecaService.listarBibliotecas();
        modelo.addAttribute("bibliotecas", lista);
        log.info("Listando bibliotecas");
        return "biblioteca/index";
    }

    @GetMapping("/agregar")
    public String agregar(Biblioteca biblioteca) {
        return "biblioteca/modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Biblioteca biblioteca, Errors errores) {
        if (errores.hasErrors()) {
            return "biblioteca/modificar";
        }
        bibliotecaService.guardar(biblioteca);
        return "redirect:/bibliotecas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo) {
        log.info("Editando biblioteca con id: {}", id);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(id);
        biblioteca = bibliotecaService.buscar(biblioteca);
        modelo.addAttribute("biblioteca", biblioteca);
        return "biblioteca/modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(id);
        bibliotecaService.eliminar(biblioteca);
        return "redirect:/bibliotecas";
    }
}
