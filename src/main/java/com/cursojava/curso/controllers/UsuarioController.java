package com.cursojava.curso.controllers;
import  com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController  {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

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


    @RequestMapping(value="api/usuarios", method = RequestMethod.GET)   // LISTAR TODOS LOS USUARIOS
    public List <Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }
        return  usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token); // tambien mas adelante se puede  verif si el usr está en la BBDD
        return usuarioId != null; // boolean, true == ok
    }


    @RequestMapping(value="api/usuarios", method = RequestMethod.POST) // AGREGA UN usuario / seguridad:Argon2
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        return usuarioDao.registrar(usuario);
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
    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void  eliminar(@RequestHeader(value="Authorization") String token,
                          @PathVariable Long id) {
        if (!validarToken(token)) { return; } // podria agregrase si tiene permisos para eliminar usr
        usuarioDao.eliminar(id);
    }

}
