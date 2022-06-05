/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "juego")
@XmlRootElement

public class Juego implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Integer idJuego;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "genero")
    private String genero;
    @Column(name = "clasificacion")
    private String clasificacion;
    @Column(name = "productora")
    private String productora;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valoracion")
    private BigDecimal valoracion;
    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;
    @Column(name = "horas_de_juego_medias")
    private Integer horasDeJuegoMedias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akJuego")
    private Collection<ListaJuegos> listaJuegosCollection;

    public Juego() {
    }

    public Juego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValoracion() {
        return valoracion;
    }

    public void setValoracion(BigDecimal valoracion) {
        this.valoracion = valoracion;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Integer getHorasDeJuegoMedias() {
        return horasDeJuegoMedias;
    }

    public void setHorasDeJuegoMedias(Integer horasDeJuegoMedias) {
        this.horasDeJuegoMedias = horasDeJuegoMedias;
    }

    @XmlTransient
    public Collection<ListaJuegos> getListaJuegosCollection() {
        return listaJuegosCollection;
    }

    public void setListaJuegosCollection(Collection<ListaJuegos> listaJuegosCollection) {
        this.listaJuegosCollection = listaJuegosCollection;
    }

    private static final long serialVersionUID = 1L;

}
