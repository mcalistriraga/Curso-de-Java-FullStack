package com.cursojava.curso.controllers;
import  com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController  {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value="usuarios")
    public List <Usuario> getUsuarios() {
        return  usuarioDao.getUsuarios();
    }

    @RequestMapping(value="usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setTelefono("0416-123.4567");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setPassword("123456");
        return usuario;
    }

    @RequestMapping(value="usuario12")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setTelefono("0416-123.4567");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setPassword("123456");
        return usuario;
    }
    @RequestMapping(value="usuario34")
    public Usuario eliminar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setTelefono("0416-123.4567");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setPassword("123456");
        return usuario;
    }
    @RequestMapping(value="usuario56")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setTelefono("0416-123.4567");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setPassword("123456");
        return usuario;
    }

}
