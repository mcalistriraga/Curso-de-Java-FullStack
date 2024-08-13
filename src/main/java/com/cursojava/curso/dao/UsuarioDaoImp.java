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

    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        final String query = "FROM Usuario WHERE email = :email";
        final List<Usuario> lista = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", usuario.getEmail())
                .setMaxResults(1)
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        final Usuario usuarioBBDD = lista.get(0);

        final Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if (argon2.verify(usuarioBBDD.getPassword(), usuario.getPassword()) ) {
            return usuarioBBDD;
        }
        return null;

    }


}
