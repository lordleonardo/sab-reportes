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
@Table(name = "TIPOSTECNOLOGIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipostecnologias.findAll", query = "SELECT t FROM Tipostecnologias t"),
    @NamedQuery(name = "Tipostecnologias.findByIdtipotecnologia", query = "SELECT t FROM Tipostecnologias t WHERE t.idtipotecnologia = :idtipotecnologia"),
    @NamedQuery(name = "Tipostecnologias.findByTipotecnologia", query = "SELECT t FROM Tipostecnologias t WHERE t.tipotecnologia = :tipotecnologia")})
public class Tipostecnologias implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOTECNOLOGIA")
    private BigDecimal idtipotecnologia;
    @Size(max = 100)
    @Column(name = "TIPOTECNOLOGIA")
    private String tipotecnologia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipotecnologia")
    private Collection<Estaciones> estacionesCollection;

    public Tipostecnologias() {
    }

    public Tipostecnologias(BigDecimal idtipotecnologia) {
        this.idtipotecnologia = idtipotecnologia;
    }

    public BigDecimal getIdtipotecnologia() {
        return idtipotecnologia;
    }

    public void setIdtipotecnologia(BigDecimal idtipotecnologia) {
        this.idtipotecnologia = idtipotecnologia;
    }

    public String getTipotecnologia() {
        return tipotecnologia;
    }

    public void setTipotecnologia(String tipotecnologia) {
        this.tipotecnologia = tipotecnologia;
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
        hash += (idtipotecnologia != null ? idtipotecnologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipostecnologias)) {
            return false;
        }
        Tipostecnologias other = (Tipostecnologias) object;
        if ((this.idtipotecnologia == null && other.idtipotecnologia != null) || (this.idtipotecnologia != null && !this.idtipotecnologia.equals(other.idtipotecnologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Tipostecnologias[ idtipotecnologia=" + idtipotecnologia + " ]";
    }
    
}
