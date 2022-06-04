package com.tallertornofumero.erp.service.impl;

import com.tallertornofumero.erp.model.Usuario;
import com.tallertornofumero.erp.repository.UsuarioRepository;
import com.tallertornofumero.erp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> listUsuariosById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> listUsuariosByNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    @Override
    public List<Usuario> listUsuariosByHabilitado(Boolean habilitado){
        return usuarioRepository.findByHabilitado(habilitado);
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario replaceUsuario(Usuario usuario, long id) {
        return listUsuariosById(id)
                .map(user -> {
                    user.setNombre(usuario.getNombre());
                    user.setPassword(usuario.getPassword());
                    user.setHabilitado(usuario.isHabilitado());
                    return crear(user);
                })
                .orElseGet(()->{
                    usuario.setId(id);
                    return crear(usuario);
                });
    }
}
