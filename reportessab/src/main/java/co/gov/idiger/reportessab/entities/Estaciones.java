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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ESTACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estaciones.findAll", query = "SELECT e FROM Estaciones e"),
    @NamedQuery(name = "Estaciones.findByIdestacion", query = "SELECT e FROM Estaciones e WHERE e.idestacion = :idestacion"),
    @NamedQuery(name = "Estaciones.findByEstacion", query = "SELECT e FROM Estaciones e WHERE e.estacion = :estacion"),
    @NamedQuery(name = "Estaciones.findByFrecuenciaregistro", query = "SELECT e FROM Estaciones e WHERE e.frecuenciaregistro = :frecuenciaregistro"),
    @NamedQuery(name = "Estaciones.findByFrecuenciatransmision", query = "SELECT e FROM Estaciones e WHERE e.frecuenciatransmision = :frecuenciatransmision"),
    @NamedQuery(name = "Estaciones.findByUbicacion", query = "SELECT e FROM Estaciones e WHERE e.ubicacion = :ubicacion"),
    @NamedQuery(name = "Estaciones.findByDescripcionubicacion", query = "SELECT e FROM Estaciones e WHERE e.descripcionubicacion = :descripcionubicacion"),
    @NamedQuery(name = "Estaciones.findByLatitud", query = "SELECT e FROM Estaciones e WHERE e.latitud = :latitud"),
    @NamedQuery(name = "Estaciones.findByLongitud", query = "SELECT e FROM Estaciones e WHERE e.longitud = :longitud"),
    @NamedQuery(name = "Estaciones.findByAltitud", query = "SELECT e FROM Estaciones e WHERE e.altitud = :altitud")})
public class Estaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDESTACION")
    private BigDecimal idestacion;
    @Size(max = 100)
    @Column(name = "ESTACION")
    private String estacion;
    @Column(name = "FRECUENCIAREGISTRO")
    private BigInteger frecuenciaregistro;
    @Column(name = "FRECUENCIATRANSMISION")
    private BigInteger frecuenciatransmision;
    @Size(max = 200)
    @Column(name = "UBICACION")
    private String ubicacion;
    @Size(max = 1000)
    @Column(name = "DESCRIPCIONUBICACION")
    private String descripcionubicacion;
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Column(name = "ALTITUD")
    private BigInteger altitud;
    @JoinColumn(name = "IDTIPOTECNOLOGIA", referencedColumnName = "IDTIPOTECNOLOGIA")
    @ManyToOne(optional = false)
    private Tipostecnologias idtipotecnologia;
    @JoinColumn(name = "IDTIPOESTACION", referencedColumnName = "IDTIPOESTACION")
    @ManyToOne(optional = false)
    private Tiposestaciones idtipoestacion;
    @JoinColumn(name = "IDPROPIETARIO", referencedColumnName = "IDPROPIETARIO")
    @ManyToOne(optional = false)
    private Propietarios idpropietario;
    @JoinColumn(name = "IDLOCALIDAD", referencedColumnName = "IDLOCALIDAD")
    @ManyToOne(optional = false)
    private Localidades idlocalidad;
    @JoinColumn(name = "IDESTADOESTACION", referencedColumnName = "IDESTADOESTACION")
    @ManyToOne(optional = false)
    private Estadosestaciones idestadoestacion;
    @JoinColumn(name = "IDADMINISTRADOR", referencedColumnName = "IDADMINISTRADOR")
    @ManyToOne(optional = false)
    private Administradores idadministrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestacion")
    private Collection<Sensores> sensoresCollection;

    public Estaciones() {
    }

    public Estaciones(BigDecimal idestacion) {
        this.idestacion = idestacion;
    }

    public BigDecimal getIdestacion() {
        return idestacion;
    }

    public void setIdestacion(BigDecimal idestacion) {
        this.idestacion = idestacion;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public BigInteger getFrecuenciaregistro() {
        return frecuenciaregistro;
    }

    public void setFrecuenciaregistro(BigInteger frecuenciaregistro) {
        this.frecuenciaregistro = frecuenciaregistro;
    }

    public BigInteger getFrecuenciatransmision() {
        return frecuenciatransmision;
    }

    public void setFrecuenciatransmision(BigInteger frecuenciatransmision) {
        this.frecuenciatransmision = frecuenciatransmision;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcionubicacion() {
        return descripcionubicacion;
    }

    public void setDescripcionubicacion(String descripcionubicacion) {
        this.descripcionubicacion = descripcionubicacion;
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

    public BigInteger getAltitud() {
        return altitud;
    }

    public void setAltitud(BigInteger altitud) {
        this.altitud = altitud;
    }

    public Tipostecnologias getIdtipotecnologia() {
        return idtipotecnologia;
    }

    public void setIdtipotecnologia(Tipostecnologias idtipotecnologia) {
        this.idtipotecnologia = idtipotecnologia;
    }

    public Tiposestaciones getIdtipoestacion() {
        return idtipoestacion;
    }

    public void setIdtipoestacion(Tiposestaciones idtipoestacion) {
        this.idtipoestacion = idtipoestacion;
    }

    public Propietarios getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(Propietarios idpropietario) {
        this.idpropietario = idpropietario;
    }

    public Localidades getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Localidades idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public Estadosestaciones getIdestadoestacion() {
        return idestadoestacion;
    }

    public void setIdestadoestacion(Estadosestaciones idestadoestacion) {
        this.idestadoestacion = idestadoestacion;
    }

    public Administradores getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(Administradores idadministrador) {
        this.idadministrador = idadministrador;
    }

    @XmlTransient
    public Collection<Sensores> getSensoresCollection() {
        return sensoresCollection;
    }

    public void setSensoresCollection(Collection<Sensores> sensoresCollection) {
        this.sensoresCollection = sensoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestacion != null ? idestacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estaciones)) {
            return false;
        }
        Estaciones other = (Estaciones) object;
        if ((this.idestacion == null && other.idestacion != null) || (this.idestacion != null && !this.idestacion.equals(other.idestacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getEstacion();
    }
    
}
