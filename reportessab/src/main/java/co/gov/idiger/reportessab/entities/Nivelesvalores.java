/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leo Montes
 */
@Entity
@Table(name = "NIVELESVALORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivelesvalores.findAll", query = "SELECT n FROM Nivelesvalores n")})
public class Nivelesvalores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDNIVELESVALORES")
    private BigDecimal idnivelesvalores;
    @Column(name = "COTASENSOR")
    private BigDecimal cotasensor;
    @Column(name = "MINSENSOR")
    private BigDecimal minsensor;
    @Column(name = "COTABM")
    private BigDecimal cotabm;
    @Column(name = "NIVELDESBORDAMIENTO")
    private BigDecimal niveldesbordamiento;
    @Column(name = "VALORREFERENCIA")
    private BigDecimal valorreferencia;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "IDUSUARIO")
    private BigDecimal idusuario;
    @JoinColumn(name = "IDSENSOR", referencedColumnName = "IDSENSOR")
    @ManyToOne(optional = false)
    private Sensores idsensor;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Column(name = "IDTIPOLECTURA")
    private BigDecimal idLectura;

    public BigDecimal getIdnivelesvalores() {
        return idnivelesvalores;
    }

    public void setIdnivelesvalores(BigDecimal idnivelesvalores) {
        this.idnivelesvalores = idnivelesvalores;
    }

    public BigDecimal getCotasensor() {
        return cotasensor;
    }

    public void setCotasensor(BigDecimal cotasensor) {
        this.cotasensor = cotasensor;
    }

    public BigDecimal getMinsensor() {
        return minsensor;
    }

    public void setMinsensor(BigDecimal minsensor) {
        this.minsensor = minsensor;
    }

    public BigDecimal getCotabm() {
        return cotabm;
    }

    public void setCotabm(BigDecimal cotabm) {
        this.cotabm = cotabm;
    }

    public BigDecimal getNiveldesbordamiento() {
        return niveldesbordamiento;
    }

    public void setNiveldesbordamiento(BigDecimal niveldesbordamiento) {
        this.niveldesbordamiento = niveldesbordamiento;
    }

    public BigDecimal getValorreferencia() {
        return valorreferencia;
    }

    public void setValorreferencia(BigDecimal valorreferencia) {
        this.valorreferencia = valorreferencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public Sensores getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(Sensores idsensor) {
        this.idsensor = idsensor;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigDecimal getIdLectura() {
        return idLectura;
    }

    public void setIdLectura(BigDecimal idLectura) {
        this.idLectura = idLectura;
    }

}
