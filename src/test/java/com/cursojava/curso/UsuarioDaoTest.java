package com.cursojava.curso;

import com.cursojava.curso.dao.UsuarioDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UsuarioDaoTest {

    @Autowired
    private UsuarioDao usuarioDao;

    @Test
    public void testEntityManager() {
        assertNotNull(usuarioDao.getUsuarios(), "EntityManager is null");
    }
}

