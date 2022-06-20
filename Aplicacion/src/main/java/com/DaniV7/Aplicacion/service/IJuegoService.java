/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.service;

import com.DaniV7.Aplicacion.entity.Juego;
import com.DaniV7.Aplicacion.entity.Serie;

/**
 *
 * @author Usuario
 */
public interface IJuegoService {
    
      public Juego findByNombre(String nomrbe);
}
