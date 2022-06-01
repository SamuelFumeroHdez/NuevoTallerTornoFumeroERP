package com.tallertornofumero.erp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "HABILITADO", nullable = false)
    private boolean habilitado;

}
