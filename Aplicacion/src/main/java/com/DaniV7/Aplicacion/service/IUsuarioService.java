/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.service;

import com.DaniV7.Aplicacion.entity.Usuario;

/**
 *
 * @author Usuario
 */
public interface IUsuarioService {

    public Usuario findByAlias(String alias);

    public Usuario registrarUsuario(Usuario usuario);
}
