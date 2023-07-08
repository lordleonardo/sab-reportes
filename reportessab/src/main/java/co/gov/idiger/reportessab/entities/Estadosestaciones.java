/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ESTADOSESTACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadosestaciones.findAll", query = "SELECT e FROM Estadosestaciones e"),
    @NamedQuery(name = "Estadosestaciones.findByIdestadoestacion", query = "SELECT e FROM Estadosestaciones e WHERE e.idestadoestacion = :idestadoestacion"),
    @NamedQuery(name = "Estadosestaciones.findByEstadoestacion", query = "SELECT e FROM Estadosestaciones e WHERE e.estadoestacion = :estadoestacion")})
public class Estadosestaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDESTADOESTACION")
    private BigDecimal idestadoestacion;
    @Size(max = 100)
    @Column(name = "ESTADOESTACION")
    private String estadoestacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoestacion")
    private Collection<Estaciones> estacionesCollection;

    public Estadosestaciones() {
    }

    public Estadosestaciones(BigDecimal idestadoestacion) {
        this.idestadoestacion = idestadoestacion;
    }

    public BigDecimal getIdestadoestacion() {
        return idestadoestacion;
    }

    public void setIdestadoestacion(BigDecimal idestadoestacion) {
        this.idestadoestacion = idestadoestacion;
    }

    public String getEstadoestacion() {
        return estadoestacion;
    }

    public void setEstadoestacion(String estadoestacion) {
        this.estadoestacion = estadoestacion;
    }

    @XmlTransient
    public Collection<Estaciones> getEstacionesCollection() {
        return estacionesCollection;
    }

    public void setEstacionesCollection(Collection<Estaciones> estacionesCollection) {
        this.estacionesCollection = estacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoestacion != null ? idestadoestacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadosestaciones)) {
            return false;
        }
        Estadosestaciones other = (Estadosestaciones) object;
        if ((this.idestadoestacion == null && other.idestadoestacion != null) || (this.idestadoestacion != null && !this.idestadoestacion.equals(other.idestadoestacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Estadosestaciones[ idestadoestacion=" + idestadoestacion + " ]";
    }
    
}
