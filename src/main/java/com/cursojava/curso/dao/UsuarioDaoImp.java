package com.cursojava.curso.dao; // Define el paquete al que pertenece esta clase

import com.cursojava.curso.models.Usuario; // Importa la clase Usuario desde el paquete de modelos
import org.springframework.stereotype.Repository; // Importa la anotación Repository para indicar que esta clase es un repositorio
import org.springframework.transaction.annotation.Transactional;  // Importa la anotación Transactional para la gestión de transacciones

import javax.persistence.EntityManager; // Importa la clase EntityManager para la gestión de entidades
import javax.persistence.PersistenceContext; // Importa la anotación PersistenceContext para inyectar el EntityManager

import java.util.List; // Importa la interfaz List para el manejo de listas
@Repository // Indica que esta clase es un repositorio y se encargará de interactuar con la base de datos
@Transactional // Indica que los métodos de esta clase deben ser gestionados dentro de una transacción
public class UsuarioDaoImp implements UsuarioDao { // Implementa la interfaz UsuarioDao
    @PersistenceContext // Inyecta una instancia de EntityManager
    private EntityManager entityManager;  // Declara el EntityManager que se utilizará para interactuar con la base de datos
    @Override
    public List<Usuario> getUsuarios() { // consulta a la BBDD, Implementa el método getUsuarios definido en la interfaz UsuarioDao
        String query = "FROM Usuario";  // Define una consulta JPQL para obtener todos los objetos Usuario
        return entityManager.createQuery(query).getResultList(); // Ejecuta la consulta y retorna el resultado
    }
}
