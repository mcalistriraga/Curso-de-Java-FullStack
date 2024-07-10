package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();
    void eliminar(Long id);
    Usuario registrar(Usuario usuario);
    boolean  verificarCredenciales(Usuario usuario);
}
