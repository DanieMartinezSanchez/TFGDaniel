/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.impl;

import com.DaniV7.Aplicacion.dao.IJuegoDAO;
import com.DaniV7.Aplicacion.entity.Juego;
import com.DaniV7.Aplicacion.service.IJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class JuegoServiceImpl implements IJuegoService {

    @Autowired
    private IJuegoDAO juegoDao;

    @Override
    public Juego findByNombre(String nombre) {

        return juegoDao.findByNombre(nombre);
    }
}
