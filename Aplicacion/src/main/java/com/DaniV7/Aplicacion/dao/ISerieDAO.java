/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.dao;

import com.DaniV7.Aplicacion.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface ISerieDAO extends JpaRepository<Serie, Integer>{
    /**
    @Query("Select s.* from Serie s where s.nombre like :'%nomb%'")
    public List<Serie> serieNombre (@Param("nomb") String nomb);

    @Query("Select j.* from Serie j order by nombre asc")
    public List<Serie> seriesAlfabeticamente();

    @Query("Select j.* from Serie j order by valoracion asc")
    public List<Serie> juegosValoracion();

    @Query("Select j.* from Serie j where fecha_estreno = :fecha order by fecha_estreno asc")
    public List<Serie> serieFecha(@Param("fecha") Date fecha);

    @Query("Select j.* from Serie j where clasificacion = :clasificacion")
    public List<Serie> serieCalificacion(@Param("clasificacion") String clasificacion);
    
     @Query("Select j.* from Serie j where genero = :genero")
    public List<Serie> serieGenero(@Param("genero") String genero);

    @Query("Select j.* from Serie j where estado = :estado")
    public List<Serie> serieEstado();

*/
}
