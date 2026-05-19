package com.udc.desarrolloweb.services;

import com.udc.desarrolloweb.models.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listarUsuarios();
    public void guardar(Usuario user);
    public void eliminar (Usuario user);
    public Usuario buscar (Usuario user);
}
