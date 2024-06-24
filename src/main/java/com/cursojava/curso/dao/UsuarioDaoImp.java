package com.cursojava.curso.dao; // Define el paquete al que pertenece esta clase

import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao { // Implementa la interfaz UsuarioDao
    @PersistenceContext
    private EntityManager entityManager;  // Declara el EntityManager que se utilizará para interactuar con la base de datos
    @Override
    public List<Usuario> getUsuarios() { // consulta a la BBDD
        String query = "FROM Usuario";  // Define una consulta JPQL para obtener todos los objetos Usuario
        return entityManager.createQuery(query, Usuario.class).getResultList();
    }
}
