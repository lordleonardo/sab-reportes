/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "LOCALIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l"),
    @NamedQuery(name = "Localidades.findByIdlocalidad", query = "SELECT l FROM Localidades l WHERE l.idlocalidad = :idlocalidad"),
    @NamedQuery(name = "Localidades.findByLocalidad", query = "SELECT l FROM Localidades l WHERE l.localidad = :localidad"),
    @NamedQuery(name = "Localidades.findByObjectid", query = "SELECT l FROM Localidades l WHERE l.objectid = :objectid"),
    @NamedQuery(name = "Localidades.findByArea", query = "SELECT l FROM Localidades l WHERE l.area = :area"),
    @NamedQuery(name = "Localidades.findByPerimetro", query = "SELECT l FROM Localidades l WHERE l.perimetro = :perimetro")})
public class Localidades implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLOCALIDAD")
    private BigDecimal idlocalidad;
    @Size(max = 100)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "OBJECTID")
    private BigInteger objectid;
    @Column(name = "AREA")
    private BigInteger area;
    @Column(name = "PERIMETRO")
    private BigInteger perimetro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlocalidad")
    private Collection<Estaciones> estacionesCollection;

    public Localidades() {
    }

    public Localidades(BigDecimal idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public BigDecimal getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(BigDecimal idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }



    public BigInteger getObjectid() {
        return objectid;
    }

    public void setObjectid(BigInteger objectid) {
        this.objectid = objectid;
    }

    public BigInteger getArea() {
        return area;
    }

    public void setArea(BigInteger area) {
        this.area = area;
    }

    public BigInteger getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(BigInteger perimetro) {
        this.perimetro = perimetro;
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
        hash += (idlocalidad != null ? idlocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidades)) {
            return false;
        }
        Localidades other = (Localidades) object;
        if ((this.idlocalidad == null && other.idlocalidad != null) || (this.idlocalidad != null && !this.idlocalidad.equals(other.idlocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getLocalidad().substring(0, 1).toUpperCase() + getLocalidad().substring(1).toLowerCase();
    }

    }
