/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.controllers;

import com.DaniV7.Aplicacion.dao.IJuegoDAO;
import com.DaniV7.Aplicacion.dao.ISerieDAO;
import com.DaniV7.Aplicacion.entity.Juego;
import com.DaniV7.Aplicacion.entity.Serie;
import com.DaniV7.Aplicacion.service.IJuegoService;
import com.DaniV7.Aplicacion.service.ISerieService;
import com.DaniV7.Aplicacion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class Controlador {

    /**
     * Inyeccion de las interfaces necesarias para la clase
     */
    @Autowired
    private ISerieDAO serieDao;
    @Autowired
    private IJuegoDAO juegoDao;
    @Autowired
    private ISerieService serieService;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IJuegoService juegoService;

    /**
     * Metodo que permite que veamos todas las series en la pestaña de series
     *
     * @param model
     * @param serie
     * @return
     */
    @GetMapping("/series")
    public String seriesForm(Model model, Serie serie) {
        model.addAttribute("series", serieDao.findAll());
        return "series";
    }

    /**
     * Metodo que permite que veamos todos los juegos en la pestaña de juegos
     *
     * @param model
     * @param juego
     * @return
     */
    @GetMapping("/juegos")
    public String juegosForm(Model model, Juego juego) {
        model.addAttribute("juegos", juegoDao.findAll());
        return "juegos";
    }

}
