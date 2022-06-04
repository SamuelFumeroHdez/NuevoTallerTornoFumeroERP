package com.tallertornofumero.erp.controller;

import com.tallertornofumero.erp.model.Usuario;
import com.tallertornofumero.erp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/form")
    public String usuarios(Model model){
        model.addAttribute("title", "Usuarios");
        return "usuarios";
    }

    @GetMapping("/getall")
    public List<Usuario> getAll(){
        List<Usuario> lista = usuarioService.listUsuarios();
        return usuarioService.listUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUser(@PathVariable Long id){
        return usuarioService.listUsuariosById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Usuario> getUserByNombre(@PathVariable String nombre){
        System.out.println(nombre);
        return usuarioService.listUsuariosByNombre(nombre);
    }

    @GetMapping("/habilitado/{habilitado}")
    public List<Usuario> getUserByHabilitado(@PathVariable Boolean habilitado){
        return usuarioService.listUsuariosByHabilitado(habilitado);
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario usuario){
        Usuario usuarioCreado = usuarioService.crear(usuario);
        return new ResponseEntity(usuarioCreado, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Usuario replaceUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
        return usuarioService.replaceUsuario(usuario, id);
    }

}
