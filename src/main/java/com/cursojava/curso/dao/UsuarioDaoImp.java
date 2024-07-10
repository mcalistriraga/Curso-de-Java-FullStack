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
    public List<Usuario> getUsuarios() { // LISTA USUARIOS: consulta a la BBDD
        if (entityManager == null) {
            System.out.println("EntityManager is null");
        } else {
            System.out.println("EntityManager is injected successfully");
        }
        String query = "FROM Usuario";  // Define una consulta JPQL para obtener todos los objetos Usuario
        return entityManager.createQuery(query, Usuario.class).getResultList();
    }

    @Override
    public void eliminar(Long id) { // ELIMINA UN USUARIO
        Usuario usuario= entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override   // REGISTRA UN USUARIO
    public Usuario registrar(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    @Override
    public boolean  verificarCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";
        List <Usuario> lista = entityManager.createQuery(query, Usuario.class)
                .setParameter("email",    usuario.getEmail())
                .setParameter("password", usuario.getPassword())
                .getResultList();
        return !lista.isEmpty();
    }

}
