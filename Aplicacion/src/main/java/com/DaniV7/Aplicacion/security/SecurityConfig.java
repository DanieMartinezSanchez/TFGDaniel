package com.DaniV7.Aplicacion.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Usuario
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Inyeccion del servicio UserDetailsService
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Inyeccion del bean BCryptPasswordEncoder para poder encriptar las constraseñas de los usuarios
     * @return 
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    /**
     * Metodo configuure auth que permitira comparar
     * @param auth
     * @throws Exception 
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * Metodo configure http que define las rutas a las que tienen accseso los usuarios con credenciales y los que no las tienen
     * @param http
     * @throws Exception 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/auth/**","/series","/juegos", "/perfil").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth/login").defaultSuccessUrl("/index", true).failureUrl("/auth/login?error=true")
                .loginProcessingUrl("/auth/login-post").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
