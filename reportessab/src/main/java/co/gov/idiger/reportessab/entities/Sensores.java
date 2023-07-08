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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "SENSORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensores.findAll", query = "SELECT s FROM Sensores s"),
    @NamedQuery(name = "Sensores.findByIdsensor", query = "SELECT s FROM Sensores s WHERE s.idsensor = :idsensor"),
    @NamedQuery(name = "Sensores.findByLatitud", query = "SELECT s FROM Sensores s WHERE s.latitud = :latitud"),
    @NamedQuery(name = "Sensores.findByLongitud", query = "SELECT s FROM Sensores s WHERE s.longitud = :longitud"),
    @NamedQuery(name = "Sensores.findByEstado", query = "SELECT s FROM Sensores s WHERE s.estado = :estado"),
    @NamedQuery(name = "Sensores.findByVisible", query = "SELECT s FROM Sensores s WHERE s.visible = :visible")})
public class Sensores implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSENSOR")
    private BigDecimal idsensor;
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Column(name = "VISIBLE")
    private BigInteger visible;
    @JoinColumn(name = "IDTIPOSENSOR", referencedColumnName = "IDTIPOSENSOR")
    @ManyToOne(optional = false)
    private Tipossensores idtiposensor;
    @JoinColumn(name = "IDESTACION", referencedColumnName = "IDESTACION")
    @ManyToOne(optional = false)
    private Estaciones idestacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsensor")
    private Collection<Lecturas> lecturasCollection;

    public Sensores() {
    }

    public Sensores(BigDecimal idsensor) {
        this.idsensor = idsensor;
    }

    public BigDecimal getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(BigDecimal idsensor) {
        this.idsensor = idsensor;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigInteger getVisible() {
        return visible;
    }

    public void setVisible(BigInteger visible) {
        this.visible = visible;
    }

    public Tipossensores getIdtiposensor() {
        return idtiposensor;
    }

    public void setIdtiposensor(Tipossensores idtiposensor) {
        this.idtiposensor = idtiposensor;
    }

    public Estaciones getIdestacion() {
        return idestacion;
    }

    public void setIdestacion(Estaciones idestacion) {
        this.idestacion = idestacion;
    }

    @XmlTransient
    public Collection<Lecturas> getLecturasCollection() {
        return lecturasCollection;
    }

    public void setLecturasCollection(Collection<Lecturas> lecturasCollection) {
        this.lecturasCollection = lecturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsensor != null ? idsensor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensores)) {
            return false;
        }
        Sensores other = (Sensores) object;
        if ((this.idsensor == null && other.idsensor != null) || (this.idsensor != null && !this.idsensor.equals(other.idsensor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Sensores[ idsensor=" + idsensor + " ]";
    }
    
}
