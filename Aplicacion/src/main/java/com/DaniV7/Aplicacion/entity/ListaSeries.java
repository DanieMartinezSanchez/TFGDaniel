/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaniV7.Aplicacion.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "lista_series")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaSeries.findAll", query = "SELECT l FROM ListaSeries l"),
    @NamedQuery(name = "ListaSeries.findByIdLista", query = "SELECT l FROM ListaSeries l WHERE l.idLista = :idLista"),
    @NamedQuery(name = "ListaSeries.findByNombreLista", query = "SELECT l FROM ListaSeries l WHERE l.nombreLista = :nombreLista")})
public class ListaSeries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lista")
    private Integer idLista;
    @Column(name = "nombre_lista")
    private String nombreLista;
    @JoinColumn(name = "ak_serie", referencedColumnName = "id_serie")
    @ManyToOne(optional = false)
    private Serie akSerie;

    public ListaSeries() {
    }

    public ListaSeries(Integer idLista) {
        this.idLista = idLista;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public Serie getAkSerie() {
        return akSerie;
    }

    public void setAkSerie(Serie akSerie) {
        this.akSerie = akSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaSeries)) {
            return false;
        }
        ListaSeries other = (ListaSeries) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.DaniV7.Aplicacion.entity.ListaSeries[ idLista=" + idLista + " ]";
    }
    
}
