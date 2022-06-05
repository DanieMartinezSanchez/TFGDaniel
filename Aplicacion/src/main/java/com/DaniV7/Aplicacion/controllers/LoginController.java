/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.controllers;

import com.DaniV7.Aplicacion.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.DaniV7.Aplicacion.service.IUsuarioService;

/**
 *
 * @author Usuario
 */
@Controller
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/auth/login")
    public String loginForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @GetMapping("/auth/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/auth/registro";
        } else {
            model.addAttribute("usuario", usuarioService.registrarUsuario(usuario));
        }
        return "redirect:/auth/login";
    }

}
