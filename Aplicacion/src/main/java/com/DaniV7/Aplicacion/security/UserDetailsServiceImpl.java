package com.DaniV7.Aplicacion.security;

import com.DaniV7.Aplicacion.dao.IUsuarioDAO;
import com.DaniV7.Aplicacion.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * Inyeccion de la interfaz IUsuarioDAO
     */
    @Autowired
    private IUsuarioDAO usuarioDao;

    /**
     * Metodo loaduserByUsername que comprueba el nombre del usuario y en caso de no econtrar ninguna coincidencia devuelve una excepcion
     * @param username
     * @return
     * @throws UsernameNotFoundException 
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByAlias(username);
        UserBuilder builder = null;
        if (usuario != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(usuario.getContrasena());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("usuario no econtrado");
        }

        return builder.build();
    }

}
