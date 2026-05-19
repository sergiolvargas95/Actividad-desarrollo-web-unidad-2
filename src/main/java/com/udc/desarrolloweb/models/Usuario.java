package com.udc.desarrolloweb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula", nullable = false, length = 15)
    private String cedula;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nombre;
    @Email
    private String email;
}
