package com.udc.desarrolloweb.services;

import com.udc.desarrolloweb.models.Biblioteca;

import java.util.List;

public interface IBibliotecaService {
    public List<Biblioteca> listarBibliotecas();
    public void guardar(Biblioteca biblioteca);
    public void eliminar(Biblioteca biblioteca);
    public Biblioteca buscar(Biblioteca biblioteca);
}
