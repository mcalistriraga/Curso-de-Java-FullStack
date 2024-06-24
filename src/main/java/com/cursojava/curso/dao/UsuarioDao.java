package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();


}
