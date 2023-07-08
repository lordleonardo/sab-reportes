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
@Table(name = "PROPIETARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietarios.findAll", query = "SELECT p FROM Propietarios p"),
    @NamedQuery(name = "Propietarios.findByIdpropietario", query = "SELECT p FROM Propietarios p WHERE p.idpropietario = :idpropietario"),
    @NamedQuery(name = "Propietarios.findByPropietario", query = "SELECT p FROM Propietarios p WHERE p.propietario = :propietario")})
public class Propietarios implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROPIETARIO")
    private BigDecimal idpropietario;
    @Size(max = 100)
    @Column(name = "PROPIETARIO")
    private String propietario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpropietario")
    private Collection<Estaciones> estacionesCollection;

    public Propietarios() {
    }

    public Propietarios(BigDecimal idpropietario) {
        this.idpropietario = idpropietario;
    }

    public BigDecimal getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(BigDecimal idpropietario) {
        this.idpropietario = idpropietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
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
        hash += (idpropietario != null ? idpropietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietarios)) {
            return false;
        }
        Propietarios other = (Propietarios) object;
        if ((this.idpropietario == null && other.idpropietario != null) || (this.idpropietario != null && !this.idpropietario.equals(other.idpropietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Propietarios[ idpropietario=" + idpropietario + " ]";
    }
    
}
