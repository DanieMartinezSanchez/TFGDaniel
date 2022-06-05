/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "episodios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episodios.findAll", query = "SELECT e FROM Episodios e"),
    @NamedQuery(name = "Episodios.findByIdEpisodio", query = "SELECT e FROM Episodios e WHERE e.idEpisodio = :idEpisodio"),
    @NamedQuery(name = "Episodios.findByNombre", query = "SELECT e FROM Episodios e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Episodios.findByDuracion", query = "SELECT e FROM Episodios e WHERE e.duracion = :duracion"),
    @NamedQuery(name = "Episodios.findByDescripcion", query = "SELECT e FROM Episodios e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Episodios.findByImagen", query = "SELECT e FROM Episodios e WHERE e.imagen = :imagen"),
    @NamedQuery(name = "Episodios.findByFechaEstreno", query = "SELECT e FROM Episodios e WHERE e.fechaEstreno = :fechaEstreno")})
public class Episodios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_episodio")
    private Integer idEpisodio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "duracion")
    private Integer duracion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;
    @JoinColumn(name = "id_temporada", referencedColumnName = "id_temporada")
    @ManyToOne(optional = false)
    private Temporada idTemporada;

    public Episodios() {
    }

    public Episodios(Integer idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public Integer getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Integer idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Temporada getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Temporada idTemporada) {
        this.idTemporada = idTemporada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEpisodio != null ? idEpisodio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Episodios)) {
            return false;
        }
        Episodios other = (Episodios) object;
        if ((this.idEpisodio == null && other.idEpisodio != null) || (this.idEpisodio != null && !this.idEpisodio.equals(other.idEpisodio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DaniV7.Aplicacion.entity.Episodios[ idEpisodio=" + idEpisodio + " ]";
    }
    
}
