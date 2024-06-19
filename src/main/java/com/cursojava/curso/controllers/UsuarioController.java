package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
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

    @RequestMapping(value="usuarios")
    public List <Usuario> getUsuarios() {

        List <Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(111L);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setTelefono("0416-11111111");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setPassword("111111");

        Usuario usuario2 = new Usuario();
        usuario2.setId(222L);
        usuario2.setNombre("María");
        usuario2.setApellido("Gonzalez");
        usuario2.setTelefono("0416-2222222");
        usuario2.setEmail("mariagonzalez@hotmail.com");
        usuario2.setPassword("2222222");

        Usuario usuario3 = new Usuario();
        usuario3.setId(333L);
        usuario3.setNombre("Gariel");
        usuario3.setApellido("Aliaga");
        usuario3.setTelefono("0416-333333");
        usuario3.setEmail("gabrielaliaga@hotmail.com");
        usuario3.setPassword("3333333");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
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
