package com.udc.desarrolloweb.services;

import com.udc.desarrolloweb.dao.IBibliotecaCrud;
import com.udc.desarrolloweb.models.Biblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BibliotecaServiceImp implements IBibliotecaService {

    @Autowired
    IBibliotecaCrud crudBiblioteca;

    @Transactional(readOnly = true)
    @Override
    public List<Biblioteca> listarBibliotecas() {
        return (List<Biblioteca>) crudBiblioteca.findAll();
    }

    @Transactional
    @Override
    public void guardar(Biblioteca biblioteca) {
        crudBiblioteca.save(biblioteca);
    }

    @Transactional
    @Override
    public void eliminar(Biblioteca biblioteca) {
        crudBiblioteca.delete(biblioteca);
    }

    @Transactional(readOnly = true)
    @Override
    public Biblioteca buscar(Biblioteca biblioteca) {
        return crudBiblioteca.findById(biblioteca.getId()).orElse(null);
    }
}
