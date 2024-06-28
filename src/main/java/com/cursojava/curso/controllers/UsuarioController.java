package com.cursojava.curso.controllers;
import  com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController  {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value="api/usuarios", method = RequestMethod.GET)
    public List <Usuario> getUsuarios() {
        return  usuarioDao.getUsuarios();
    }

    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void  eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }
    @RequestMapping(value="api/usuario/{id}")
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

    @RequestMapping(value="api/usuario12")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setTelefono("0416-123.4567");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setPassword("123456");
        return usuario;
    }
    @RequestMapping(value="api/usuario56")
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
