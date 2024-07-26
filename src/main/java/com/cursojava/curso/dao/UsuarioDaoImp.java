package com.cursojava.curso.dao; // Define el paquete al que pertenece esta clase

import com.cursojava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    public boolean verificarCredenciales(Usuario usuario) {
        final String query = "FROM Usuario WHERE email = :email";
        final List<Usuario> lista = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", usuario.getEmail())
                .setMaxResults(1)
                .getResultList();

        if (lista.isEmpty()) {
            return false;
        }

        final Usuario usuarioFromDb = lista.get(0);
        final String passwordHashed = usuarioFromDb.getPassword();

        final Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        try {
            return argon2.verify(passwordHashed, usuario.getPassword());
        } finally {
            argon2.wipeArray(usuario.getPassword().toCharArray());
        }
    }


}
