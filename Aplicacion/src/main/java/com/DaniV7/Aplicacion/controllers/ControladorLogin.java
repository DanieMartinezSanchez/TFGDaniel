/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.controllers;

import com.DaniV7.Aplicacion.dao.IJuegoDAO;
import com.DaniV7.Aplicacion.dao.ISerieDAO;
import com.DaniV7.Aplicacion.entity.Usuario;
import com.DaniV7.Aplicacion.service.IJuegoService;
import com.DaniV7.Aplicacion.service.ISerieService;
import com.DaniV7.Aplicacion.service.IUsuarioService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class ControladorLogin {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/")
    public String inicio() {
        return ("inicio");
    }

    @GetMapping("/auth/login")
    public String loginForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/auth/login")
    public String loginPost(@ModelAttribute("usuario") Usuario usuario) {

        return "index";
    }

    @GetMapping("/auth/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registroPost(@ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/auth/registro";
        } else {
            model.addAttribute("usuario", usuarioService.registrarUsuario(usuario));
        }
        return "redirect:/auth/login";
    }

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session) {

        String username = auth.getName();
        if (session.getAttribute("usuario") == null) {
            Usuario usuario = usuarioService.findByAlias(username);
            usuario.setContrasena(null);
            session.setAttribute("usuario", usuario);
        }
        return "index";
    }
}
