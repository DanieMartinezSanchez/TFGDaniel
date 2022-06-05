/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DaniV7.Aplicacion.service.IUsuarioService;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/private")
public class PrivateController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/pagina-principal")
    public String paginaPrincipal() {

        return "pagina-principal";

    }

    @GetMapping("/series")
    public String series() {

        return "series";

    }

}
