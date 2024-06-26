package com.cursojava.curso.dao; // Define el paquete al que pertenece esta clase

import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao { // Implementa la interfaz UsuarioDao
    @PersistenceContext
    private EntityManager entityManager;  // Declara el EntityManager
    @Override
    public List<Usuario> getUsuarios() { // consulta a la BBDD
        if (entityManager == null) {
            System.out.println("EntityManager is null");
        } else {
            System.out.println("EntityManager is injected successfully");
        }
        String query = "FROM Usuario";  // Define una consulta JPQL para obtener todos los objetos Usuario
        return entityManager.createQuery(query, Usuario.class).getResultList();
        //return "hola";
    }
    /*public List<Usuario> getUsuarios() { // consulta a la BBDD
        String query = "FROM Usuario";  // Define una consulta JPQL para obtener todos los objetos Usuario
        //return entityManager.createQuery(query, Usuario.class).getResultList();
        return "hola";
    }*/
}
