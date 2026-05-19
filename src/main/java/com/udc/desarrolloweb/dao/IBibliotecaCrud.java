package com.udc.desarrolloweb.dao;

import com.udc.desarrolloweb.models.Biblioteca;
import org.springframework.data.repository.CrudRepository;

public interface IBibliotecaCrud extends CrudRepository<Biblioteca, Long> {
}
