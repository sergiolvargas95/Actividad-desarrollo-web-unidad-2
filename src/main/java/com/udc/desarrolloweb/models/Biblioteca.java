package com.udc.desarrolloweb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "bibliotecas")
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotEmpty
    @Column(nullable = false, length = 200)
    private String direccion;

    @NotEmpty
    @Column(nullable = false, length = 100)
    private String ciudad;

    @NotEmpty
    @Column(nullable = false, length = 100)
    private String pais;

    @Column(length = 20)
    private String telefono;

    @Email
    @Column(length = 100)
    private String email;

    @Column(name = "horario_apertura")
    private LocalTime horarioApertura;

    @Column(name = "horario_cierre")
    private LocalTime horarioCierre;

    @PositiveOrZero
    @Column(name = "num_libros")
    private Integer numLibros;

    @PositiveOrZero
    @Column(name = "num_usuarios")
    private Integer numUsuarios;

    @Column(name = "es_publica", nullable = false)
    private Boolean esPublica = false;

    @Column(length = 200)
    private String web;
}
