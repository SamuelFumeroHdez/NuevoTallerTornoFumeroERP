package com.tallertornofumero.erp.service;

import com.tallertornofumero.erp.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService{

    List<Usuario> listUsuarios();
    Optional<Usuario> listUsuariosById(long id);
    List<Usuario> listUsuariosByNombre(String nombre);
    List<Usuario> listUsuariosByHabilitado(Boolean habilitado);
    Usuario crear(Usuario usuario);
    void eliminar(Long id);
    Usuario replaceUsuario(Usuario usuario, long id);
}
