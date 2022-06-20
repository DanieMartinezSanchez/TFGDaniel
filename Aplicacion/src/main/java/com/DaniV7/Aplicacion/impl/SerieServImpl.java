/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.impl;

import com.DaniV7.Aplicacion.dao.ISerieDAO;
import com.DaniV7.Aplicacion.entity.Serie;
import com.DaniV7.Aplicacion.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class SerieServImpl implements ISerieService {

    /**
     * Inyeccion de la intefaz ISerieDAO
     */
    @Autowired
    private ISerieDAO serieDao;

    /**
     * Metodo para encontrar las series por nombre
     * @param nombre
     * @return 
     */
    @Override
    public Serie findByNombre(String nombre) {

        return serieDao.findByNombre(nombre);
    }

}
