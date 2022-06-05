/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.impl;

import com.DaniV7.Aplicacion.dao.IUsuarioDAO;
import com.DaniV7.Aplicacion.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.DaniV7.Aplicacion.service.IUsuarioService;

/**
 *
 * @author Usuario
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDao;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario findByAlias(String alias) {
        return usuarioDao.findByAlias(alias);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuario.setDesarrollador(Boolean.FALSE);
        usuarioDao.save(usuario);
        return usuario;
    }

}
