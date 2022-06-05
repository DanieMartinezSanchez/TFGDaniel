/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "temporada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporada.findAll", query = "SELECT t FROM Temporada t"),
    @NamedQuery(name = "Temporada.findByIdTemporada", query = "SELECT t FROM Temporada t WHERE t.idTemporada = :idTemporada"),
    @NamedQuery(name = "Temporada.findByNEpisodios", query = "SELECT t FROM Temporada t WHERE t.nEpisodios = :nEpisodios"),
    @NamedQuery(name = "Temporada.findByDescripcion", query = "SELECT t FROM Temporada t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Temporada.findByImagen", query = "SELECT t FROM Temporada t WHERE t.imagen = :imagen"),
    @NamedQuery(name = "Temporada.findByEstado", query = "SELECT t FROM Temporada t WHERE t.estado = :estado"),
    @NamedQuery(name = "Temporada.findByFechaEstreno", query = "SELECT t FROM Temporada t WHERE t.fechaEstreno = :fechaEstreno"),
    @NamedQuery(name = "Temporada.findByFechaFinal", query = "SELECT t FROM Temporada t WHERE t.fechaFinal = :fechaFinal")})
public class Temporada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_temporada")
    private Integer idTemporada;
    @Column(name = "nEpisodios")
    private Integer nEpisodios;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @JoinColumn(name = "id_serie", referencedColumnName = "id_serie")
    @ManyToOne(optional = false)
    private Serie idSerie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTemporada")
    private Collection<Episodios> episodiosCollection;

    public Temporada() {
    }

    public Temporada(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Integer getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Integer getNEpisodios() {
        return nEpisodios;
    }

    public void setNEpisodios(Integer nEpisodios) {
        this.nEpisodios = nEpisodios;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Serie getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }

    @XmlTransient
    public Collection<Episodios> getEpisodiosCollection() {
        return episodiosCollection;
    }

    public void setEpisodiosCollection(Collection<Episodios> episodiosCollection) {
        this.episodiosCollection = episodiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemporada != null ? idTemporada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporada)) {
            return false;
        }
        Temporada other = (Temporada) object;
        if ((this.idTemporada == null && other.idTemporada != null) || (this.idTemporada != null && !this.idTemporada.equals(other.idTemporada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DaniV7.Aplicacion.entity.Temporada[ idTemporada=" + idTemporada + " ]";
    }
    
}
