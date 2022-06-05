/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.dao;

import com.DaniV7.Aplicacion.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface IJuegoDAO extends JpaRepository<Juego, Integer> {
    /*
    @Query("Select j.* from Juego j where j.nombre like :'%nomb%'")
    public List<Juego> juegosNombre(@Param("nomb") String nomb);
    
    
    @Query("Select j.* from Juego j order by nombre asc")
    public List<Juego> juegosAlfabeticamente();

    @Query("Select j.* from Juego j order by valoracion asc")
    public List<Juego> juegosValoracion();

    @Query("Select j.* from Juego j order by fecha_estreno asc")
    public List<Juego> juegosFecha();

    @Query("Select j.* from Juego j where clasificacion")
    public List<Juego> juegosCalificacion();

    @Query("Select j.* from Juego j where genero ")
    public List<Juego> juegosGenero();

    @Query("Select j.* from Juego j where categoria = :categoia ")
    public List<Juego> juegosCategoria();

    @Query("Select j.* from Juego j where estado = :estado")
    public List<Juego> juegosEstado();

    @Query("Select j.* from Juego j where horas > :horas")
    public List<Juego> juegosHoras();
    * 
    * **/
}
