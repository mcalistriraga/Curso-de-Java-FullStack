package com.cursojava.curso.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UsarioController {

    @RequestMapping(value="prueba")
    public String prueba() {
        return "Prueba!! desde class UsuarioController";

    }

}
