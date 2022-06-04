package com.tallertornofumero.erp.repository;

import com.tallertornofumero.erp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByHabilitado(Boolean habilitado);

}
