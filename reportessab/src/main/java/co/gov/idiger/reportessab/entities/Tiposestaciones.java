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
@Table(name = "TIPOSESTACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposestaciones.findAll", query = "SELECT t FROM Tiposestaciones t"),
    @NamedQuery(name = "Tiposestaciones.findByIdtipoestacion", query = "SELECT t FROM Tiposestaciones t WHERE t.idtipoestacion = :idtipoestacion"),
    @NamedQuery(name = "Tiposestaciones.findByTipoestacion", query = "SELECT t FROM Tiposestaciones t WHERE t.tipoestacion = :tipoestacion")})
public class Tiposestaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOESTACION")
    private BigDecimal idtipoestacion;
    @Size(max = 30)
    @Column(name = "TIPOESTACION")
    private String tipoestacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoestacion")
    private Collection<Estaciones> estacionesCollection;

    public Tiposestaciones() {
    }

    public Tiposestaciones(BigDecimal idtipoestacion) {
        this.idtipoestacion = idtipoestacion;
    }

    public BigDecimal getIdtipoestacion() {
        return idtipoestacion;
    }

    public void setIdtipoestacion(BigDecimal idtipoestacion) {
        this.idtipoestacion = idtipoestacion;
    }

    public String getTipoestacion() {
        return tipoestacion;
    }

    public void setTipoestacion(String tipoestacion) {
        this.tipoestacion = tipoestacion;
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
        hash += (idtipoestacion != null ? idtipoestacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposestaciones)) {
            return false;
        }
        Tiposestaciones other = (Tiposestaciones) object;
        if ((this.idtipoestacion == null && other.idtipoestacion != null) || (this.idtipoestacion != null && !this.idtipoestacion.equals(other.idtipoestacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Tiposestaciones[ idtipoestacion=" + idtipoestacion + " ]";
    }
    
}
