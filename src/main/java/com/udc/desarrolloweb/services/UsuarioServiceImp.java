package com.udc.desarrolloweb.services;

import com.udc.desarrolloweb.dao.IUsuarioCrud;
import com.udc.desarrolloweb.models.Usuario;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements IUsuarioService {
    @Autowired
    IUsuarioCrud crudUser;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) crudUser.findAll();
    }

    @Transactional
    @Override
    public void guardar(Usuario user) {
        crudUser.save(user);
    }

    @Transactional
    @Override
    public void eliminar(Usuario user) {
        crudUser.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscar(Usuario user) {
        return crudUser.findById(user.getCedula()).orElse(null);
    }
}
