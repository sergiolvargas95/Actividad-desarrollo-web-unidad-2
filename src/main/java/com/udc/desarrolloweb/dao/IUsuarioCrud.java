package com.udc.desarrolloweb.dao;

import com.udc.desarrolloweb.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioCrud extends CrudRepository<Usuario, String> {
}
