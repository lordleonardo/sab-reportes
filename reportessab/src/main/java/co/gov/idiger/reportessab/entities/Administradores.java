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
@Table(name = "ADMINISTRADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a"),
    @NamedQuery(name = "Administradores.findByIdadministrador", query = "SELECT a FROM Administradores a WHERE a.idadministrador = :idadministrador"),
    @NamedQuery(name = "Administradores.findByAdministrador", query = "SELECT a FROM Administradores a WHERE a.administrador = :administrador")})
public class Administradores implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDADMINISTRADOR")
    private BigDecimal idadministrador;
    @Size(max = 100)
    @Column(name = "ADMINISTRADOR")
    private String administrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadministrador")
    private Collection<Estaciones> estacionesCollection;

    public Administradores() {
    }

    public Administradores(BigDecimal idadministrador) {
        this.idadministrador = idadministrador;
    }

    public BigDecimal getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(BigDecimal idadministrador) {
        this.idadministrador = idadministrador;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
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
        hash += (idadministrador != null ? idadministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradores)) {
            return false;
        }
        Administradores other = (Administradores) object;
        if ((this.idadministrador == null && other.idadministrador != null) || (this.idadministrador != null && !this.idadministrador.equals(other.idadministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Administradores[ idadministrador=" + idadministrador + " ]";
    }
    
}
